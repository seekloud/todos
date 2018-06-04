package com.neo.sk.todos2018.shared

/**
  * User: sky
  * Date: 2018/3/10
  * Time: 16:12
  */
package object ptcl {

  trait CommonRsp {
    val errCode: Int
    val msg: String
  }


  final case class ErrorRsp(
                             errCode: Int,
                             msg: String
                           ) extends CommonRsp

  final case class SuccessRsp(
                               errCode: Int = 0,
                               msg: String = "ok"
                             ) extends CommonRsp
}
