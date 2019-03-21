package com.neo.sk.todos2018.utils

import java.io.File

import com.neo.sk.todos2018.common.AppSettings._
import org.slf4j.LoggerFactory
import io.circe.syntax._

import scala.concurrent.ExecutionContext.Implicits.global
import io.circe.generic.auto._
import io.circe.parser.decode

/**
  * User: easego
  * Date: 2018/4/18
  * Time: 14:41
  */

object HestiaClient extends HttpUtil {

  case class uploadRsp(fileName: String, errCode: Int, msg: String)

  case class uploadRep(appId: String, sn: String, timestamp: String, nonce: String, signature: String, url: String, fileName: String = "")

//  private val hestiaBaseUrl = hestiaProtocol + "://" + hestiaHost + ":" + hestiaPort
  private val hestiaBaseUrl = hestiaProtocol + "://" + hestiaDomain
  private val appId = hestiaAppId
  private val secureKey = hestiaSecureKey
  private val hestiaImgPrefix = hestiaProtocol + "://" + hestiaAddress + s"/hestia/files/image/$appId/"

  private val log = LoggerFactory.getLogger(this.getClass)

  def genImgUrl(uri: String) = hestiaImgPrefix + uri

  def upload(url: String) = {
    val uploadUrl = hestiaBaseUrl + "/hestia/files/uploadByUrl"
    val sn = appId + System.currentTimeMillis().toString
    val (timestamp, nonce, signature) = SecureUtil.generateSignatureParameters(List(appId, sn), secureKey)

    val params = uploadRep(appId, sn, timestamp, nonce, signature, url).asJson.noSpaces

    postJsonRequestSend(s"upload $url", uploadUrl,
      List(
        "appId" -> appId,
        "sn" -> sn,
        "timestamp" -> timestamp,
        "nonce" -> nonce,
        "signature" -> signature,
        "url" -> url
      ), params).map {
      case Right(str) =>
        decode[uploadRsp](str) match {
          case Right(rsp) =>
            if (rsp.errCode == 0) {
              Right(rsp.fileName)
            }
            else {
              log.error(s"upload $url error.error:${rsp.msg}")
              Left(s"${rsp.msg}")
            }

          case Left(e) =>
            log.error(s"upload $url parse error.$e")
            Left(s"Error.$e")
        }

      case Left(e) =>
        log.error(s"upload $url failed:" + e)
        Left(s"Error.$e")
    }
  }

  def upload(file: File, fileName: String) = {
    val uploadUrl = hestiaBaseUrl + "/hestia/files/upload"
    val sn = appId + System.currentTimeMillis().toString
    val (timestamp, nonce, signature) = SecureUtil.generateSignatureParameters(List(appId, sn), secureKey)
    postFileRequestSend(s"upload ${file.getName}", uploadUrl,
      List(
        "appId" -> appId,
        "sn" -> sn,
        "timestamp" -> timestamp,
        "nonce" -> nonce,
        "signature" -> signature
      ), file, fileName).map {
      case Right(str) =>
        decode[uploadRsp](str) match {
          case Right(rsp) =>
            if (rsp.errCode == 0)
              Right(rsp.fileName)
            else {
              log.error(s"upload ${file.getName}  error.error:${rsp.msg}")
              Left(s"${rsp.msg}")
            }

          case Left(e) =>
            log.error(s"upload ${file.getName}  parse error.$e")
            Left(s"Error.$e")
        }

      case Left(e) =>
        log.error(s"upload ${file.getName} failed:" + e)
        Left(s"Error.$e")
    }
  }


  def main(args: Array[String]): Unit = {}

}