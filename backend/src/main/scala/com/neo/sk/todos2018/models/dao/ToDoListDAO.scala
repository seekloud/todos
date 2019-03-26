package com.neo.sk.todos2018.models.dao

import org.slf4j.LoggerFactory

import scala.collection.mutable
import scala.concurrent.Future

/**
  * User: sky
  * Date: 2018/6/1
  * Time: 15:17
  * changed by Xu Si-ran, delete user
  * update by Tao 2019-3-23, add Record class and rename list to recordList.
  */
case class Record(id: Int, time: Long, author: String, content: String)


object ToDoListDAO {
  private val log = LoggerFactory.getLogger(this.getClass)

  private val recordList: mutable.TreeMap[Int, Record] = new mutable.TreeMap()
  private var currentId = 1

  private def getNextId(): Int = {
    val nextId = currentId
    currentId += 1
    nextId
  }

  def addRecord(author: String, content: String): Future[Int] = {
    try {

      if (author.length == 0 ) {
        log.error(s"empty author")
        Future.successful(-1)
      } else if (content.length == 0) {
        log.error(s"empty content")
        Future.successful(-1)
      } else {
        val id = getNextId()
        recordList.put(id, Record(id, System.currentTimeMillis(), author, content))
        Future.successful(1)
      }


    } catch {
      case e: Throwable =>
        log.error(s"add record error with error $e")
        Future.successful(-1)
    }
  }

  def delRecord(id: Int): Future[Int] = {
    try {
      recordList.remove(id)
      Future.successful(1)
    } catch {
      case e: Throwable =>
        log.error(s"del record error with error $e")
        Future.successful(-1)
    }
  }

  def getRecordList(author: String): Future[List[Record]] = {
    try {
      Future.successful(recordList.filter(list => list._2.author == author).values.toList.sortBy(_.time))
    } catch {
      case e: Throwable =>
        log.error(s"get recordList error with error $e")
        Future.successful(Nil)
    }
  }

}
