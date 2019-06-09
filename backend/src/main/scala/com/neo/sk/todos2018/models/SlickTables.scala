package com.neo.sk.todos2018.models

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object SlickTables extends {
  val profile = slick.jdbc.H2Profile
} with SlickTables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait SlickTables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = tRecordInfo.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table tRecordInfo
   *  @param id Database column ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param author Database column AUTHOR SqlType(VARCHAR), Length(63,true)
   *  @param content Database column CONTENT SqlType(VARCHAR), Length(1023,true)
   *  @param time Database column TIME SqlType(BIGINT) */
  case class rRecordInfo(id: Int, author: String, content: String, time: Long)
  /** GetResult implicit for fetching rRecordInfo objects using plain SQL queries */
  implicit def GetResultrRecordInfo(implicit e0: GR[Int], e1: GR[String], e2: GR[Long]): GR[rRecordInfo] = GR{
    prs => import prs._
    rRecordInfo.tupled((<<[Int], <<[String], <<[String], <<[Long]))
  }
  /** Table description of table RECORD_INFO. Objects of this class serve as prototypes for rows in queries. */
  class tRecordInfo(_tableTag: Tag) extends profile.api.Table[rRecordInfo](_tableTag, "RECORD_INFO") {
    def * = (id, author, content, time) <> (rRecordInfo.tupled, rRecordInfo.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(author), Rep.Some(content), Rep.Some(time))).shaped.<>({r=>import r._; _1.map(_=> rRecordInfo.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column AUTHOR SqlType(VARCHAR), Length(63,true) */
    val author: Rep[String] = column[String]("AUTHOR", O.Length(63,varying=true))
    /** Database column CONTENT SqlType(VARCHAR), Length(1023,true) */
    val content: Rep[String] = column[String]("CONTENT", O.Length(1023,varying=true))
    /** Database column TIME SqlType(BIGINT) */
    val time: Rep[Long] = column[Long]("TIME")
  }
  /** Collection-like TableQuery object for table tRecordInfo */
  lazy val tRecordInfo = new TableQuery(tag => new tRecordInfo(tag))
}
