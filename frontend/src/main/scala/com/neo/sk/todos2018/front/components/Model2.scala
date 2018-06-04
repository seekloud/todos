package com.neo.sk.todos2018.front.components

import mhtml._
import org.scalajs.dom

import scala.xml.Elem

/**
  * User: YOUSEIGEN
  * Date: 2018/3/11
  * Time: 11:45
  */


class Model2(title:String,modleBody:Elem,confirmStr:Boolean,minheight:Int,minwidth:Int,successFun:()=>Unit){

val modelDom=
<div id="modledom" class="model" >
  <center>
  <div class="modelbox" style={s"max-height:${minheight}px;max-width:${minwidth}px;"}>
      <span style="color:#8E98B4;line-height:44px;float:right;font-size:17px;cursor:pointer;" onclick={()=>{hide()} } >X</span>
    {
    modleBody
    }
  </div>
  </center>
</div>

  def hide():Unit ={
    dom.document.body.removeChild(dom.document.getElementById("modledom"))
  }



  mount(dom.document.body,modelDom)

}


object Model2 {
  //  def apply(title: String, modleBody: Elem, confirmStr: String, successFun: () => Unit): Model = new Model(title, modleBody, confirmStr, successFun)
  def apply(title: String, modleBody: Elem, confirmStr: Boolean, minheight: Int, minwidth: Int, successFun: () => Unit): Model2 = new Model2(title, modleBody, confirmStr, minheight, minwidth, successFun)
}
