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
  * changed by Xu Si-ran, delete user
  */
object ToDoListDAO {
  private val log = LoggerFactory.getLogger(this.getClass)
  private val list:mutable.HashSet[(String,Long)]=mutable.HashSet() //(record,time)

  def addRecord(record:String)={
    try {
      list.add(record,System.currentTimeMillis())
      Future.successful(1)
    } catch {
      case  e: Throwable =>
        log.error(s"add record error with error $e")
        Future.successful(-1)
    }
  }

  def delRecord(record:String,time:Long)={
    try {
      list.remove(record,time)
      Future.successful(1)
    } catch {
      case  e: Throwable =>
        log.error(s"del record error with error $e")
        Future.successful(-1)
    }
  }

  def getRecordList()={
    try{
      Future.successful(list.map(r=>(r._1,r._2)).toList.sortBy(_._2))
    } catch {
      case e: Throwable=>
        log.error(s"get recordList error with error $e")
        Future.successful(Nil)
    }
  }

}
