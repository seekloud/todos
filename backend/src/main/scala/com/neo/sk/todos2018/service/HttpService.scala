package com.neo.sk.todos2018.service

import akka.actor.{ActorRef, ActorSystem, Scheduler}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.scaladsl.{Flow, Sink, Source}
import akka.stream.{Materializer, OverflowStrategy}
import akka.util.Timeout

import scala.concurrent.ExecutionContextExecutor


trait HttpService extends ResourceService
  with ToDoListService
{

  implicit val system: ActorSystem

  implicit val executor: ExecutionContextExecutor

  implicit val materializer: Materializer

  implicit val timeout: Timeout

  implicit val scheduler: Scheduler


  val routes: Route =
    ignoreTrailingSlash {
      pathPrefix("todos2018") {
        pathEndOrSingleSlash {
          getFromResource("html/index.html")
        } ~
          resourceRoutes ~ listRoutes
      }
    }


}

