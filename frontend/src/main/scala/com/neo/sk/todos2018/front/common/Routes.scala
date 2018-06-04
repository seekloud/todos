package com.neo.sk.todos2018.front.common

object Routes {

  object UserRoutes{
    private val baseUrl = "/todos2018/user"

    val login= baseUrl +"/userLogin"

    val logout= baseUrl +"/userLogout"

    val signUp = baseUrl + "/userSign"

    /**检查Session*/
    val checkSession = baseUrl + "/checkSession"
  }

}

object PageRoute{
  val mainPage    =  "#/MainPage"
  val todos2018Page  =  "#/todos2018Page"
}