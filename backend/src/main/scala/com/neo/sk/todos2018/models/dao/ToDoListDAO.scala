package com.neo.sk.todos2018.models.dao

import org.slf4j.LoggerFactory
import com.neo.sk.todos2018.utils.DBUtil.db
import com.neo.sk.todos2018.models.SlickTables._
import slick.jdbc.PostgresProfile.api._
import scala.collection.mutable
import scala.concurrent.Future

/**
  * User: sky
  * Date: 2018/6/1
  * Time: 15:17
  * changed by Xu Si-ran, delete user
  * update by Tao 2019-3-23, add Record class and rename list to recordList.
  * 以下用slick操作数据库，若出现找不到表的情况，需要修改配置文件数据库的路径为绝对路径（没有..）
  */
//case class Record(id: Int, author: String, content: String, time: Long)
//
//trait FetchInfoDAOTable{
//  import com.neo.sk.todos2018.utils.DBUtil.driver.api._
//
//  class RecordInfoTable(tag: Tag) extends Table[Record](tag, "RECORD_INFO") {
//    def * = (id, author, content, time) <> (Record.tupled, Record.unapply)
//
//    val id = column[Int]("ID", O.AutoInc, O.PrimaryKey)
//    val author = column[String]("AUTHOR")
//    val content = column[String]("CONTENT")
//    val time = column[Long]("TIME")
//
//  }
//
//  protected val recordInfoTableQuery = TableQuery[RecordInfoTable]
//}


object ToDoListDAO{
  private val log = LoggerFactory.getLogger(this.getClass)

  def addRecord(author: String, content: String): Future[Int] = {
    try {
      if (author.length == 0 ) {
        log.error(s"empty author")
        Future.successful(-1)
      } else if (content.length == 0) {
        log.error(s"empty content")
        Future.successful(-1)
      } else {
        db.run(tRecordInfo.map(t => (t.author, t.content, t.time)) += (author, content, System.currentTimeMillis()))
      }
    } catch {
      case e: Throwable =>
        log.error(s"add record error with error $e")
        Future.successful(-1)
    }
  }

  def delRecord(id: Int): Future[Int] = {
    try {
      // 待补充
      Future.successful(1)
    } catch {
      case e: Throwable =>
        log.error(s"del record error with error $e")
        Future.successful(-1)
    }
  }

  def getRecordList(author: String): Future[Seq[rRecordInfo]] = {
    try {
      db.run(tRecordInfo.filter(t => t.author === author).result)
    } catch {
      case e: Throwable =>
        log.error(s"get recordList error with error $e")
        Future.successful(Nil)
    }
  }

}
