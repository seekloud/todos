package com.neo.sk.todos2018.front.pages

import com.neo.sk.todos2018.front.Index
import com.neo.sk.todos2018.front.common.{PageRoute, Routes}
import com.neo.sk.todos2018.front.components.{Model, Model2}
import com.neo.sk.todos2018.front.utils.{Http, JsFunc, Shortcut}
import com.neo.sk.todos2018.shared.ptcl.UserProtocol._
import mhtml._
import org.scalajs.dom
import org.scalajs.dom._
import org.scalajs.dom.html.TextArea
import mhtml.Var
import org.scalajs.dom.html.Input
import io.circe.parser._
import io.circe.generic.auto._
import io.circe.syntax._

import scala.xml.{Elem, Node}
import scala.concurrent.ExecutionContext.Implicits.global
import com.neo.sk.todos2018.shared.ptcl._

/**
  * User: sky
  * Date: 2018/6/1
  * Time: 15:07
  */
object MainPage extends Index {
  override val locationHashString="#/MainPage"

  override def render:Elem = {
    <div>Hello World!</div>
  }
}
