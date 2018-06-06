package com.neo.sk.todos2018.models.dao

import com.neo.sk.todos2018.utils.DBUtil.db
import slick.jdbc.PostgresProfile.api._
import com.neo.sk.todos2018.models.SlickTables._
import scala.concurrent.ExecutionContext.Implicits.global._
import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global
import com.neo.sk.todos2018.common.AppSettings
/**
  * User: sky
  * Date: 2018/6/1
  * Time: 15:17
  */
object UserDAO {
  def getUserByName(name:String)={
    Future.successful(AppSettings.userMap.get(name))
  }
}
