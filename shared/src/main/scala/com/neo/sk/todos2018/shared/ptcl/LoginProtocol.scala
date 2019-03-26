package com.neo.sk.todos2018.shared.ptcl

/**
  * User: XuSiRan
  * Date: 2019/3/26
  * Time: 19:02
  */
object LoginProtocol {

  case class UserLoginReq(
    userName: String,
    password: String
  )

  case class UserLoginRsp(
    errCode: Int,
    msg: String
  ) extends CommonRsp

}
