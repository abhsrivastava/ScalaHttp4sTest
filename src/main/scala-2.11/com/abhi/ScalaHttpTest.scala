package com.abhi

/**
  * Created by abhishek on 9/10/16.
  */
import argonaut._
import Argonaut._
import org.http4s.client.blaze.{PooledHttp1Client}
import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
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

final case class FileStatuses(val fileStatus: FileStatus)
object FileStatuses {
  implicit val fileStatusesCodecJson: CodecJson[FileStatuses] =
    Argonaut.casecodec1(FileStatuses.apply, FileStatuses.unapply)("FileStatuses")
  implicit val fileStatusesEntityDecoder: EntityDecoder[FileStatuses] =
    jsonOf[FileStatuses]
  implicit val fileStatusesEntityEncoder : EntityEncoder[FileStatuses] =
    jsonEncoderOf[FileStatuses]
}

final case class FileStatus(val fileStatusArray: List[FileStatusArray])
object FileStatus {
  implicit val fileStatusesCodecJson: CodecJson[FileStatus] =
    Argonaut.casecodec1(FileStatus.apply, FileStatus.unapply)("FileStatus")
  implicit val fileStatusesEntityDecoder: EntityDecoder[FileStatus] =
    jsonOf[FileStatus]
  implicit val fileStatusesEntityEncoder : EntityEncoder[FileStatus] =
    jsonEncoderOf[FileStatus]
}

final case class FileStatusArray(
                       val fileId : Int = 0,
                       val accessTime: Int = 0,
                       val blockSize: Int = 0,
                       val childrenNum: Int = 0,
                       val group: String = "",
                       val length : Int = 0,
                       val modificationTime: Long = 0,
                       val owner: String = "",
                       val pathSuffix: String = "",
                       val permission: String = "",
                       val replication : Int = 0,
                       val storagePolicy : Int = 0,
                       val `type`: String = ""
                     )
object FileStatusArray {
  def apply () : FileStatusArray = {
    new FileStatusArray()
  }
  implicit val fileStatusCodecJson: CodecJson[FileStatusArray] =
    Argonaut.casecodec13(FileStatusArray.apply, FileStatusArray.unapply)("accessTime", "blockSize", "childrenNum", "fileId", "group", "length", "modificationTime", "owner", "pathSuffix", "permission", "replication", "storagePolicy", "type")
  implicit val fileStatusEntityDecoder: EntityDecoder[FileStatusArray] =
    jsonOf[FileStatusArray]
  implicit val fileStatusEntityEncoder: EntityEncoder[FileStatusArray] =
    jsonEncoderOf[FileStatusArray]
}

//{"FileStatuses":{"FileStatus":[
//{"accessTime":0,"blockSize":0,"childrenNum":0,"fileId":16398,"group":"supergroup","length":0,"modificationTime":1459909590753,"owner":"hdfs","pathSuffix":"benchmarks",
// "permission":"777","replication":0,"storagePolicy":0,"type":"DIRECTORY"},
//  ]}}
