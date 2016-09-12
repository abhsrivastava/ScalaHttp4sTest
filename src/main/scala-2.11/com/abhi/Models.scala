package com.abhi.models

import argonaut.{Argonaut, CodecJson}
import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._

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
