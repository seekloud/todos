package com.neo.sk.todos2018.front.utils

import io.circe.{Decoder, Error}
import org.scalajs.dom
import org.scalajs.dom.experimental._
import org.scalajs.dom.raw.{FileReader, FormData}

import scala.concurrent.Future


object DataStore {

  var Res_Ver:List[(Long,Long)] = List.empty[(Long,Long)]

  val prefix = "http://flowdev.neoap.com"//"https://niuap.com"

  val cloudy = prefix + "/"

  val meeting = prefix + "/cloudy/user/meeting"

  val address = prefix + "/cloudy/user/address"

  val login = prefix + "/login"
}
