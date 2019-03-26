package com.neo.sk.todos2018.front

/**
  * Created by haoshuhan on 2018/6/4.
  */
object Routes {
  val base = "/todos2018"

  object Login{
    val baseUrl = base + "/login"
    val userLogin = baseUrl + "/userLogin"
    val userLogout = baseUrl + "/userLogout"
  }

  object List {
    val baseUrl = base + "/list"
    val getList = baseUrl + "/getList"
    val addRecord = baseUrl + "/addRecord"
    val delRecord = baseUrl + "/delRecord"
  }

}
