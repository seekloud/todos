import sbt._

/**
  * User: Taoz
  * Date: 6/13/2017
  * Time: 9:38 PM
  */
object Dependencies {

  val slickV = "3.3.0"
  val akkaV = "2.5.21"
  val akkaHttpV = "10.1.7"
  val scalaXmlV = "1.1.1"
  val circeVersion = "0.11.1"



  val scalaJsDomV = "0.9.6"
  val scalaTagsV = "0.6.5"
  val diodeV = "1.1.4"


  val akkaSeq = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV withSources (),
    "com.typesafe.akka" %% "akka-actor-typed" % akkaV withSources (),
    "com.typesafe.akka" %% "akka-slf4j" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV
  )

  val akkaHttpSeq = Seq(
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV
  )

  val circeSeq = Seq(
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion
  )

  val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.1.1"
  val slick = "com.typesafe.slick" %% "slick" % "3.3.0"
  val slickCodeGen = "com.typesafe.slick" %% "slick-codegen" % "3.3.0"
  val scalikejdbc = "org.scalikejdbc" %% "scalikejdbc" % "3.3.3"
  val scalikejdbcConfig = "org.scalikejdbc" %% "scalikejdbc-config" % "3.3.3"

  val scalatags = "com.lihaoyi" %% "scalatags" % "0.6.7"
  val nscalaTime = "com.github.nscala-time" %% "nscala-time" % "2.22.0"
  val hikariCP = "com.zaxxer" % "HikariCP" % "3.3.1"
  val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"
  val codec = "commons-codec" % "commons-codec" % "1.12"
  val postgresql = "org.postgresql" % "postgresql" % "42.2.5"
  val asynchttpclient = "org.asynchttpclient" % "async-http-client" % "2.8.1"
  val ehcache = "net.sf.ehcache" % "ehcache" % "2.10.6"
  val h2Database = "com.h2database" % "h2" % "1.4.196"



  val backendDependencies =
    Dependencies.akkaSeq ++
      Dependencies.akkaHttpSeq ++
      Dependencies.circeSeq ++
      Seq(
        Dependencies.scalaXml,
        Dependencies.slick,
        Dependencies.slickCodeGen,
        Dependencies.scalikejdbc,
        Dependencies.scalikejdbcConfig,
        Dependencies.scalatags,
        Dependencies.nscalaTime,
        Dependencies.hikariCP,
        Dependencies.logback,
        Dependencies.codec,
        Dependencies.postgresql,
        Dependencies.asynchttpclient,
        Dependencies.ehcache,
        Dependencies.h2Database
      )



}