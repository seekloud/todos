package com.neo.sk.todos2018.common

import java.util.concurrent.TimeUnit

import com.neo.sk.todos2018.utils.SessionSupport.SessionConfig
import com.typesafe.config.{Config, ConfigFactory}
import org.slf4j.LoggerFactory

/**
  * User: Taoz
  * Date: 9/4/2015
  * Time: 4:29 PM
  */
object AppSettings {

  private implicit class RichConfig(config: Config) {
    val noneValue = "none"

    def getOptionalString(path: String): Option[String] =
      if (config.getAnyRef(path) == noneValue) None
      else Some(config.getString(path))

    def getOptionalLong(path: String): Option[Long] =
      if (config.getAnyRef(path) == noneValue) None
      else Some(config.getLong(path))

    def getOptionalDurationSeconds(path: String): Option[Long] =
      if (config.getAnyRef(path) == noneValue) None
      else Some(config.getDuration(path, TimeUnit.SECONDS))
  }


  val log = LoggerFactory.getLogger(this.getClass)
  val config = ConfigFactory.parseResources("product.conf").withFallback(ConfigFactory.load())

  val appConfig = config.getConfig("app")


  val httpInterface = appConfig.getString("http.interface")
  val httpPort = appConfig.getInt("http.port")
  val httpHost = appConfig.getString("http.host")
  val httpDomain =appConfig.getString("http.domain")

  val slickConfig = config.getConfig("slick.db")
  val slickUrl = slickConfig.getString("url")
  val slickUser = slickConfig.getString("user")
  val slickPassword = slickConfig.getString("password")
  val slickMaximumPoolSize = slickConfig.getInt("maximumPoolSize")
  val slickConnectTimeout = slickConfig.getInt("connectTimeout")
  val slickIdleTimeout = slickConfig.getInt("idleTimeout")
  val slickMaxLifetime = slickConfig.getInt("maxLifetime")


  val sConf = config.getConfig("session")
  val sessionConfig = SessionConfig(
    cookieName = sConf.getString("cookie.name"),
    serverSecret = sConf.getString("serverSecret"),
    domain = sConf.getOptionalString("cookie.domain"),
    path = sConf.getOptionalString("cookie.path"),
    secure = sConf.getBoolean("cookie.secure"),
    httpOnly = sConf.getBoolean("cookie.httpOnly"),
    maxAge = sConf.getOptionalDurationSeconds("cookie.maxAge"),
    sessionEncryptData = sConf.getBoolean("encryptData")
  )
  val sessionTimeOut = sConf.getInt("sessionTimeOut")

}
