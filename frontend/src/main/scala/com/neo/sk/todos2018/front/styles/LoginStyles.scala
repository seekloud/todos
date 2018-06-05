package com.neo.sk.todos2018.front.styles
import scala.language.postfixOps
import scalacss.DevDefaults._

/**
  * Created by haoshuhan on 2018/6/4.
  */
object LoginStyles extends StyleSheet.Inline{
  import dsl._
  val welcome = style(
    fontSize(35 px),
    margin(20 px),
    textAlign.center
  )
  val container = style(
    textAlign.center,
    fontSize(17 px),
    margin(15 px, 0 px),
    height(30 px)
  )
  val input = style(
    width(160 px),
    height(30 px),
    borderRadius(5 px),
    fontSize(17 px)
  )

  val button = style(
    width(100 px),
    height(38 px),
    borderRadius(5 px),
    fontSize(17 px),
    marginLeft(48.%%)
  )

}
