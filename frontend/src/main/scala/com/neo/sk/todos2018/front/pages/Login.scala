package com.neo.sk.todos2018.front.pages

import com.neo.sk.todos2018.front.{Index, Routes}
import com.neo.sk.todos2018.front.utils.{Http, JsFunc}
import com.neo.sk.todos2018.shared.ptcl.{CommonRsp, SuccessRsp}
import com.neo.sk.todos2018.shared.ptcl.LoginProtocol.{UserLoginReq, UserLoginRsp}
import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.parser._
import org.scalajs.dom
import org.scalajs.dom.html.Input

import scala.xml.Node
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * User: XuSiRan
  * Date: 2019/3/26
  * Time: 17:40
  */
object Login extends Index{

  private def userLogin(): Unit ={
    val userName = dom.document.getElementById("userName").asInstanceOf[Input].value
    val password = dom.document.getElementById("userPassword").asInstanceOf[Input].value
    Http.postJsonAndParse[SuccessRsp](Routes.Login.userLogin, UserLoginReq(userName, password).asJson.noSpaces).map{
      case Right(rsp) =>
        if(rsp.errCode == 0){
          JsFunc.alert("登陆成功")
          dom.window.location.hash = "/List"
        }
        else{
          JsFunc.alert(s"登陆失败：${rsp.msg}")
        }
      case Left(error) =>
        JsFunc.alert(s"parse error,$error")
    }
  }

  override def app: Node =
    <div>
      <div class = "LoginForm">
        <h2>欢迎登陆</h2>
        <div class = "inputContent">
          <span>用户名</span>
          <input id = "userName"></input>
        </div>
        <div class = "inputContent">
          <span>密码</span>
          <input id = "userPassword" type = "password"></input>
        </div>
        <button onclick = {()=> userLogin()}>登陆</button>
      </div>
    </div>
}
