package com.neo.sk.todos2018.models.dao

import com.neo.sk.todos2018.utils.DBUtil.db
import slick.jdbc.PostgresProfile.api._
import com.neo.sk.todos2018.models.SlickTables._

import scala.concurrent.ExecutionContext.Implicits.global._
import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global
import com.neo.sk.todos2018.common.AppSettings
import org.slf4j.LoggerFactory

import scala.collection.mutable
/**
  * User: sky
  * Date: 2018/6/1
  * Time: 15:17
  */
object ToDoListDAO {
  private val log = LoggerFactory.getLogger(this.getClass)
  private val listMap:mutable.HashSet[(String,String,Long)]=mutable.HashSet() //(name,record,time)

  def addRecord(userName:String,record:String)={
    try {
      listMap.add(userName,record,System.currentTimeMillis())
      Future(1)
    } catch {
      case  e: Throwable =>
        log.error(s"add record error with error $e")
        Future(-1)
    }
  }

  def delRecord(userName:String,record:String,time:Long)={
    try {
      listMap.remove(userName,record,time)
      Future(1)
    } catch {
      case  e: Throwable =>
        log.error(s"del record error with error $e")
        Future(-1)
    }
  }

  def getRecordList(userName:String)={
    try{
      Future(listMap.filter(_._1==userName).map(r=>(r._2,r._3)).toList.sortBy(_._2))
    } catch {
      case e: Throwable=>
        log.error(s"get recordList error with error $e")
        Future(Nil)
    }
  }

}
