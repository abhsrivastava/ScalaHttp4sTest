package com.abhi

/**
  * Created by abhishek on 9/10/16.
  */
import argonaut._
import org.http4s.client.blaze.PooledHttp1Client
import org.http4s.{UrlForm}
import org.http4s.argonaut._
import com.abhi.models._
import org.http4s.dsl._
import org.http4s.client._
object ScalaHttpTest extends App {

  def uploadFile() : Unit = {

  }

  def listDirectory() : Unit = {
    def onlyDirectory : PartialFunction[FileStatusArray, String] = {
      case x if (x.`type` == "DIRECTORY") => x.pathSuffix
    }

    val c = PooledHttp1Client()
    val task = c.expect[FileStatuses]("""http://127.0.0.1:50070/webhdfs/v1/user/?op=LISTSTATUS""")
    val result = task.run
    println(result.fileStatus.fileStatusArray.collect(onlyDirectory))
    val req = PUT(uri("http://127.0.01:50070/webhdfs/v1/user/?op=CREATE"), UrlForm("q" -> "https"))
    val task2 = c.expect[Json](req)
    val result2 = task.run
    c.shutdownNow()
  }

  listDirectory()
}