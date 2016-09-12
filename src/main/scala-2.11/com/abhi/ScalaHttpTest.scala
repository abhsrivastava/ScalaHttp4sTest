package com.abhi

/**
  * Created by abhishek on 9/10/16.
  */
import argonaut._
import Argonaut._
import org.http4s.client.blaze.{PooledHttp1Client}
import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import com.abhi.models._

object ScalaHttpTest extends App {

  def method1() : Unit = {
    val c = PooledHttp1Client()
    val task = c.expect[FileStatuses]("""http://127.0.0.1:50070/webhdfs/v1/user/?op=LISTSTATUS""")
    val result = task.run
    println(result)
//    val x = FileStatuses(FileStatus(fileStatusArray = List(FileStatusArray(), FileStatusArray())))
//    println(x.asJson)
    c.shutdownNow()
  }

  method1()
}