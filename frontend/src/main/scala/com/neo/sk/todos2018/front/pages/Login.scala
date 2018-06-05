package com.neo.sk.todos2018.front.pages

import com.neo.sk.todos2018.front.utils.{Http, JsFunc}
import com.neo.sk.todos2018.front.{Index, Routes}
import com.neo.sk.todos2018.shared.ptcl.SuccessRsp
import org.scalajs.dom
import org.scalajs.dom.html.Input
import com.neo.sk.todos2018.shared.ptcl.UserProtocol._
import com.neo.sk.todos2018.shared.ptcl.ToDoListProtocol._
import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.parser._
import scala.concurrent.ExecutionContext.Implicits.global
import com.neo.sk.todos2018.front.styles.LoginStyles._
/**
  * Created by haoshuhan on 2018/6/4.
  */
object Login extends Index{
  def login() : Unit = {
    val username=dom.window.document.getElementById("username").asInstanceOf[Input].value
    val password=dom.window.document.getElementById("password").asInstanceOf[Input].value
    val data = UserLoginReq(username, password).asJson.noSpaces
    Http.postJsonAndParse[SuccessRsp](Routes.User.login, data).map {
      case Right(rsp) =>
        if(rsp.errCode == 0) {
          JsFunc.alert("登录成功！")
          dom.window.location.hash = s"#/List/$username"
        } else if(rsp.errCode == 100102){
          JsFunc.alert(s"用户名不存在!")
        } else if(rsp.errCode == 100103){
          JsFunc.alert(s"密码不正确！")
        } else {
          JsFunc.alert("登录失败，请稍后再试！")
        }

      case Left(error) =>
        println(s"login error: $error")
        JsFunc.alert("登录失败，请输入正确的水木账号密码！")
    }
  }

  def app: xml.Node = {
    <div>
      <div>
        <div class={welcome.htmlClass}>欢迎登录</div>
      </div>
      <div>
        <div class={container.htmlClass}>用户名：<input class={input.htmlClass} id="username"></input>
        </div>
        <div class={container.htmlClass}>
          <pre>密  码：<input class={input.htmlClass} id="password"></input>
          </pre>
        </div>
      </div>
      <button class={button.htmlClass} onclick={() => login()}>登录</button>
    </div>
  }
}
