package com.neo.sk.todos2018.front.pages

import com.neo.sk.todos2018.front.{Index, Routes}
import com.neo.sk.todos2018.front.utils.{Http, JsFunc, TimeTool}
import com.neo.sk.todos2018.shared.ptcl.SuccessRsp
import com.neo.sk.todos2018.shared.ptcl.ToDoListProtocol.{AddRecordReq, DelRecordReq, GetListRsp, TaskRecord}
import mhtml._
import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.parser._
import com.neo.sk.todos2018.front.styles.ListStyles._
import org.scalajs.dom
import org.scalajs.dom.html.Input

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by haoshuhan on 2018/6/4.
  * changed by Xu Si-ran on 2019/3/21
  * update by zhangtao, 2019-3-23: record id.
  */
object TaskList{

  val url = "#/" + "List"

  val taskList = Var(List.empty[TaskRecord])
  var inputValue = ""

  def getDeleteButton(id: Int) =  <button class={deleteButton.htmlClass} onclick={()=>deleteRecord(id)}>删除</button>

  def addRecord: Unit = {
    val data = AddRecordReq(inputValue).asJson.noSpaces
    Http.postJsonAndParse[SuccessRsp](Routes.List.addRecord, data).map {
      case Right(rsp) =>
        if(rsp.errCode == 0) {
          JsFunc.alert("添加成功！")
          getList
        } else {
          JsFunc.alert("添加失败！")
          println(rsp.msg)
        }

      case Left(error) =>
        println(s"parse error,$error")
    }
  }

  def deleteRecord(id: Int): Unit = {
    val data = DelRecordReq(id).asJson.noSpaces
    Http.postJsonAndParse[SuccessRsp](Routes.List.delRecord, data).map {
      case Right(rsp) =>
        if(rsp.errCode == 0) {
          JsFunc.alert("执行成功！但是现在并没有进行删除操作。")
          getList
        } else {
          JsFunc.alert("删除失败！")
          println(rsp.msg)
        }

      case Left(error) =>
        println(s"parse error,$error")
    }
  }

  def getList: Unit = {
    Http.getAndParse[GetListRsp](Routes.List.getList).map {
      case Right(rsp) =>
        if(rsp.errCode == 0){
          taskList := rsp.list.get
        } else {
          JsFunc.alert(rsp.msg)
          dom.window.location.hash = s"#/Login"
          println(rsp.msg)
        }
      case Left(error) =>
        println(s"get task list error,$error")
    }
  }

  val taskListRx = taskList.map {
    case Nil => <div style ="margin: 30px; font-size: 17px;">暂无任务记录</div>
    case list => <div style ="margin: 20px; font-size: 17px;">
      <table>
        <tr>
          <th class={th.htmlClass}>任务</th>
          <th class={th.htmlClass}>创建时间</th>
          <th class={th.htmlClass}>操作</th>
        </tr>
        {list.map {l =>
        <tr>
          <td class={td.htmlClass}>{l.content}</td>
          <td class={td.htmlClass}>{TimeTool.dateFormatDefault(l.time)}</td>
          <td class={td.htmlClass}>{getDeleteButton(l.id)}</td>
        </tr>
      }
        }

      </table>

    </div>
  }

  def logout(): Unit = {
    Http.getAndParse[SuccessRsp](Routes.Login.userLogout).map{
      case Right(rsp) =>
        if(rsp.errCode == 0){
          JsFunc.alert("退出成功")
          taskList := Nil
          dom.window.location.hash = "/Login"
        }
        else{
          JsFunc.alert(s"退出失败：${rsp.msg}")
        }
      case Left(error) =>
        JsFunc.alert(s"parse error,$error")
    }
  }

  def app: xml.Node = {
   getList
  <div>
    <div>
      <button class={logoutButton.htmlClass} onclick={()=>logout()}>退出</button></div>
    <div style="margin:30px;font-size:25px;">任务记录</div>
    <div style="margin-left:30px;">
      <input class={input.htmlClass} onchange={(e: dom.Event) => inputValue = e.target.asInstanceOf[Input].value}></input>
    <button class={addButton.htmlClass} onclick={()=>addRecord}>+添加</button>
    </div>
    {taskListRx}
  </div>
  }

}
