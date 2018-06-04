package com.neo.sk.todos2018.front.components

import mhtml._
import org.scalajs.dom

import scala.xml.Elem

/**
  * User: YOUSEIGEN
  * Date: 2018/3/11
  * Time: 11:45
  */


class Model(title:String,modleBody:Elem,confirmStr:Boolean,minheight:Int,minwidth:Int,successFun:()=>Unit){


  val modelDom=
    <div id="modledom" class="model" >
      <div class="modelbox" style={s"min-height:${minheight}px;min-width:${minwidth}px;"}>
        <div style="background-color:rgba(222, 223, 224, 1);height:44px;width:100%;border-radius:8px 8px 0 0;">
          <span style="font-family: PingFangSC-Regular;font-size: 16px;color: #1D2341;letter-spacing: 0.19px;line-height:44px;float:left;margin-left:18px;">{s"$title"}</span>
          <span style="color:#8E98B4;line-height:44px;float:right;margin-right:17px;font-size:17px;cursor:pointer;" onclick={()=>{hide()} } >X</span>
        </div>
        {
        modleBody
        }
        {
        if (confirmStr) {
          <div class="modelbottom">
            <img src="/todos2018/static/img/success.png" style="height:30px;width:30px;margin-left:33%;" onclick={() => {
              successFun()
            }}></img>
            <img src="/todos2018/static/img/error.png" style="height:30px;width:30px;margin-left:5%;" onclick={() => {
              hide()
            }}></img>
          </div>
        } else {
          <div class="modelbottom"></div>
        }
        }
      </div>
    </div>


  def hide():Unit ={
    dom.document.body.removeChild(dom.document.getElementById("modledom"))
  }


  def build()={
    <div id="modledom" class="model" >
      <div class="modelbox">
        <div style="background-color:#F2F5FA;height:44px;border-radius:8px 8px 0 0;">
          <span style="font-family: PingFangSC-Regular;font-size: 16px;color: #1D2341;letter-spacing: 0.19px;line-height:44px;float:left;margin-left:18px;">{"我是标题"}</span>
          <span style="color:#8E98B4;line-height:44px;float:right;margin-right:17px;font-size:17px;" onclick={()=>{hide()} } >X</span>
        </div>
      </div>
    </div>
  }

  mount(dom.document.body,modelDom)

  //  mount(body,a,MountSettings.default)

}


object Model {
  //  def apply(title: String, modleBody: Elem, confirmStr: String, successFun: () => Unit): Model = new Model(title, modleBody, confirmStr, successFun)
  def apply(title: String, modleBody: Elem, confirmStr: Boolean, minheight: Int, minwidth: Int, successFun: () => Unit): Model = new Model(title, modleBody, confirmStr, minheight, minwidth, successFun)
}





//<div id="modledom" class="model" >
//<div class="modelbox">
//<div style="background-color:#F2F5FA;height:44px;border-radius:8px 8px 0 0;">
//<span style="font-family: PingFangSC-Regular;font-size: 16px;color: #1D2341;letter-spacing: 0.19px;line-height:44px;float:left;margin-left:18px;">{s"$title"}</span>
//<span style="color:#8E98B4;line-height:44px;float:right;margin-right:17px;font-size:17px;" onclick={()=>{hide()} } >X</span>
//</div>
//<div class="modelbody">
//<div style="margin:26px 19%">
//<div style="font-family: PingFangSC-Regular;font-size: 14px;margin-bottom:20px;">
//<span style="color: #8E98B4;margin-right:50px;">标题</span>
//<input type="text" placeholder="请输入" style="height:32px;width:400px;background: #FFFFFF;border: 1px solid #D9DFEB;border-radius: 4px;padding-left:10px;"></input>
//</div>
//<div style="font-family: PingFangSC-Regular;font-size: 14px;">
//<span style="color: #8E98B4;margin-right:22px;">选择能力</span>
//<div style="display:inline-block;color: #1D2341;line-height: 16px;width:412px;" >
//<div style="display:flex;flex-wrap:wrap;">
//<div class="abicheck">
//<input type="checkbox" id="HDmeet"></input>
//<label for="HDmeet">高清视频会议</label>
//</div>
//<div class="abicheck">
//<input type="checkbox" id="Livemeet"></input>
//<label for="Livemeet">会议直播</label>
//</div>
//<div class="abicheck">
//<input type="checkbox" id="MultiMedia"></input>
//<label for="MultiMedia">多媒体会议</label>
//</div>
//</div>
//</div>
//</div>
//
//<div style="font-family: PingFangSC-Regular;font-size: 14px;margin-bottom:20px;">
//<span style="color: #8E98B4;margin-right:50px;">姓名</span>
//<input type="text" placeholder="请输入" style="height:32px;width:400px;background: #FFFFFF;border: 1px solid #D9DFEB;border-radius: 4px;padding-left:10px;"></input>
//</div>
//<div style="font-family: PingFangSC-Regular;font-size: 14px;margin-bottom:20px;">
//<span style="color: #8E98B4;margin-right:50px;">公司</span>
//<input type="text" placeholder="请输入" style="height:32px;width:400px;background: #FFFFFF;border: 1px solid #D9DFEB;border-radius: 4px;padding-left:10px;"></input>
//</div>
//<div style="font-family: PingFangSC-Regular;font-size: 14px;margin-bottom:20px;">
//<span style="color: #8E98B4;margin-right:49px;">手机</span>
//<div style="display:inline-block;">
//<div style="background: #8E98B4;border-radius: 4px 0 0 4px;font-size: 16px;color: #FFFFFF;letter-spacing: 0.19px;width:40px;height:34px;line-height:34px;display:inline-block;text-align:center;">+86</div>
//<input type="text" placeholder="请输入" style="height:32px;width:360px;background: #FFFFFF;border: 1px solid #D9DFEB;border-radius:0 4px 4px 0;padding-left:10px;float:right;"></input>
//</div>
//</div>
//<div style="font-family: PingFangSC-Regular;font-size: 14px;margin-bottom:20px;">
//<span style="color: #8E98B4;margin-right:50px;">邮箱</span>
//<input type="text" placeholder="请输入" style="height:32px;width:400px;background: #FFFFFF;border: 1px solid #D9DFEB;border-radius: 4px;padding-left:10px;"></input>
//</div>
//
//</div>
//
//</div>
//<div class="modelbottom">
//<button class="modelbutton" style="color: #FFFFFF;border: 0px ;background-color:#4D78FB;">申请</button>
//<button class="modelbutton" style="color: #4D78FB;border: 1px solid #4D78FB;background-color:#FFFFFF;" onclick={()=>{hide()} }>取消</button>
//</div>
//</div>
//</div>
