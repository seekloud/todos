package com.neo.sk.todos2018.front.components

import scala.xml.Elem

/**
  * Created by YXY on Date: 2018/3/22
  */
class ModelCancel(title:String,modleBody:Elem,confirmStr:Boolean,minheight:Int,minwidth:Int,successFun:()=>Unit,cancelFun:()=>Unit) extends Model(title, modleBody, confirmStr, minheight, minwidth, successFun) {

  override def hide():Unit ={
//    dom.document.body.removeChild(dom.document.getElementById("modledom"))
    cancelFun()

  }


}


object ModelCancel{
  def apply(title: String, modleBody: Elem, confirmStr: Boolean, minheight: Int, minwidth: Int, successFun: () => Unit, cancelFun: () => Unit): ModelCancel = new ModelCancel(title, modleBody, confirmStr, minheight, minwidth, successFun, cancelFun)
}