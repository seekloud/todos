package com.neo.sk.todos2018.shared.ptcl

/**
  * User: sky
  * Date: 2018/6/1
  * Time: 15:45
  */
object ToDoListProtocol {
  //添加记录
  case class AddRecordReq(
                         record:String
                         )
  case class DelRecordReq(
                         record:String,
                         time:Long
                         )
  //获得列表
  case class GetListRsp(
                       list:Option[List[(String,Long)]],
                       errCode:Int=0,
                       msg:String="Ok"
                       ) extends CommonRsp
}
