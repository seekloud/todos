package com.neo.sk.todos2018.shared.ptcl

/**
  * User: sky
  * Date: 2018/6/1
  * Time: 15:45
  *
  * update by zhangtao: 2019-3-23
  *
  */
object ToDoListProtocol {


  //添加记录
  case class AddRecordReq(content: String)

  case class DelRecordReq(id: Int)

  //获得列表
  case class TaskRecord(
    id: Int,
    content: String,
    time: Long,
  )
  case class GetListRsp(
    list: Option[List[TaskRecord]],
    errCode: Int = 0,
    msg: String = "Ok"
  ) extends CommonRsp

}
