package com.neo.sk.todos2018.service

import akka.actor.{ActorSystem, Scheduler}
import akka.http.scaladsl.model.headers.{CacheDirective, `Cache-Control`}
import akka.http.scaladsl.server.Directive0
import akka.http.scaladsl.server.Directives.mapResponseHeaders
import akka.stream.Materializer
import akka.util.Timeout
import com.neo.sk.todos2018.utils.CirceSupport
import org.slf4j.LoggerFactory

import scala.concurrent.ExecutionContextExecutor

trait BaseService extends CirceSupport with SessionBase with ServiceUtils{

  def addCacheControlHeaders(first: CacheDirective, more: CacheDirective*): Directive0 = {
    mapResponseHeaders { headers =>
      `Cache-Control`(first, more: _*) +: headers
    }
  }

  implicit val system: ActorSystem

  implicit val executor: ExecutionContextExecutor

  implicit val materializer: Materializer

  implicit val timeout: Timeout

  implicit val scheduler: Scheduler

  private val log = LoggerFactory.getLogger("com.neo.sk.dogwood.http.BaseService")

  lazy val regex = "(10.*|localhost|192.*|127.*)".r

}
