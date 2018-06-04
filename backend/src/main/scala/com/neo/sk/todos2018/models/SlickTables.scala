package com.neo.sk.todos2018.models

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object SlickTables extends {
  val profile = slick.jdbc.PostgresProfile
} with SlickTables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait SlickTables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(tAdmin.schema, tCommentC.schema, tCommentP.schema, tDataDownload.schema, tDataInfo.schema, tDataThumb.schema, tFileDownload.schema, tFileInfo.schema, tTestResult.schema, tUsers.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table tAdmin
   *  @param adminName Database column admin_name SqlType(varchar), PrimaryKey, Length(255,true)
   *  @param pwdMd5 Database column pwd_md5 SqlType(varchar), Length(255,true)
   *  @param registerTime Database column register_time SqlType(int8) */
  case class rAdmin(adminName: String, pwdMd5: String, registerTime: Long)
  /** GetResult implicit for fetching rAdmin objects using plain SQL queries */
  implicit def GetResultrAdmin(implicit e0: GR[String], e1: GR[Long]): GR[rAdmin] = GR{
    prs => import prs._
    rAdmin.tupled((<<[String], <<[String], <<[Long]))
  }
  /** Table description of table admin. Objects of this class serve as prototypes for rows in queries. */
  class tAdmin(_tableTag: Tag) extends profile.api.Table[rAdmin](_tableTag, "admin") {
    def * = (adminName, pwdMd5, registerTime) <> (rAdmin.tupled, rAdmin.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(adminName), Rep.Some(pwdMd5), Rep.Some(registerTime)).shaped.<>({r=>import r._; _1.map(_=> rAdmin.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column admin_name SqlType(varchar), PrimaryKey, Length(255,true) */
    val adminName: Rep[String] = column[String]("admin_name", O.PrimaryKey, O.Length(255,varying=true))
    /** Database column pwd_md5 SqlType(varchar), Length(255,true) */
    val pwdMd5: Rep[String] = column[String]("pwd_md5", O.Length(255,varying=true))
    /** Database column register_time SqlType(int8) */
    val registerTime: Rep[Long] = column[Long]("register_time")
  }
  /** Collection-like TableQuery object for table tAdmin */
  lazy val tAdmin = new TableQuery(tag => new tAdmin(tag))

  /** Entity class storing rows of table tCommentC
   *  @param id Database column id SqlType(bigserial), AutoInc
   *  @param userid Database column userid SqlType(int8)
   *  @param commentText Database column comment_text SqlType(varchar), Length(500,true)
   *  @param date Database column date SqlType(int8)
   *  @param mainLayer Database column main_layer SqlType(int4)
   *  @param datasetid Database column datasetid SqlType(int8)
   *  @param username Database column username SqlType(varchar), Length(50,true) */
  case class rCommentC(id: Long, userid: Long, commentText: String, date: Long, mainLayer: Int, datasetid: Long, username: String)
  /** GetResult implicit for fetching rCommentC objects using plain SQL queries */
  implicit def GetResultrCommentC(implicit e0: GR[Long], e1: GR[String], e2: GR[Int]): GR[rCommentC] = GR{
    prs => import prs._
    rCommentC.tupled((<<[Long], <<[Long], <<[String], <<[Long], <<[Int], <<[Long], <<[String]))
  }
  /** Table description of table comment_c. Objects of this class serve as prototypes for rows in queries. */
  class tCommentC(_tableTag: Tag) extends profile.api.Table[rCommentC](_tableTag, "comment_c") {
    def * = (id, userid, commentText, date, mainLayer, datasetid, username) <> (rCommentC.tupled, rCommentC.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userid), Rep.Some(commentText), Rep.Some(date), Rep.Some(mainLayer), Rep.Some(datasetid), Rep.Some(username)).shaped.<>({r=>import r._; _1.map(_=> rCommentC.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc */
    val id: Rep[Long] = column[Long]("id", O.AutoInc)
    /** Database column userid SqlType(int8) */
    val userid: Rep[Long] = column[Long]("userid")
    /** Database column comment_text SqlType(varchar), Length(500,true) */
    val commentText: Rep[String] = column[String]("comment_text", O.Length(500,varying=true))
    /** Database column date SqlType(int8) */
    val date: Rep[Long] = column[Long]("date")
    /** Database column main_layer SqlType(int4) */
    val mainLayer: Rep[Int] = column[Int]("main_layer")
    /** Database column datasetid SqlType(int8) */
    val datasetid: Rep[Long] = column[Long]("datasetid")
    /** Database column username SqlType(varchar), Length(50,true) */
    val username: Rep[String] = column[String]("username", O.Length(50,varying=true))
  }
  /** Collection-like TableQuery object for table tCommentC */
  lazy val tCommentC = new TableQuery(tag => new tCommentC(tag))

  /** Entity class storing rows of table tCommentP
   *  @param id Database column id SqlType(bigserial), AutoInc
   *  @param datasetid Database column datasetid SqlType(int8)
   *  @param userid Database column userid SqlType(int8)
   *  @param commentText Database column comment_text SqlType(varchar), Length(500,true)
   *  @param date Database column date SqlType(int8)
   *  @param username Database column username SqlType(varchar), Length(50,true)
   *  @param layer Database column layer SqlType(serial), AutoInc */
  case class rCommentP(id: Long, datasetid: Long, userid: Long, commentText: String, date: Long, username: String, layer: Int)
  /** GetResult implicit for fetching rCommentP objects using plain SQL queries */
  implicit def GetResultrCommentP(implicit e0: GR[Long], e1: GR[String], e2: GR[Int]): GR[rCommentP] = GR{
    prs => import prs._
    rCommentP.tupled((<<[Long], <<[Long], <<[Long], <<[String], <<[Long], <<[String], <<[Int]))
  }
  /** Table description of table comment_p. Objects of this class serve as prototypes for rows in queries. */
  class tCommentP(_tableTag: Tag) extends profile.api.Table[rCommentP](_tableTag, "comment_p") {
    def * = (id, datasetid, userid, commentText, date, username, layer) <> (rCommentP.tupled, rCommentP.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(datasetid), Rep.Some(userid), Rep.Some(commentText), Rep.Some(date), Rep.Some(username), Rep.Some(layer)).shaped.<>({r=>import r._; _1.map(_=> rCommentP.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc */
    val id: Rep[Long] = column[Long]("id", O.AutoInc)
    /** Database column datasetid SqlType(int8) */
    val datasetid: Rep[Long] = column[Long]("datasetid")
    /** Database column userid SqlType(int8) */
    val userid: Rep[Long] = column[Long]("userid")
    /** Database column comment_text SqlType(varchar), Length(500,true) */
    val commentText: Rep[String] = column[String]("comment_text", O.Length(500,varying=true))
    /** Database column date SqlType(int8) */
    val date: Rep[Long] = column[Long]("date")
    /** Database column username SqlType(varchar), Length(50,true) */
    val username: Rep[String] = column[String]("username", O.Length(50,varying=true))
    /** Database column layer SqlType(serial), AutoInc */
    val layer: Rep[Int] = column[Int]("layer", O.AutoInc)
  }
  /** Collection-like TableQuery object for table tCommentP */
  lazy val tCommentP = new TableQuery(tag => new tCommentP(tag))

  /** Entity class storing rows of table tDataDownload
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param downloadUser Database column download_user SqlType(int8)
   *  @param downloadTime Database column download_time SqlType(int8)
   *  @param dataName Database column data_name SqlType(varchar), Length(255,true)
   *  @param dataId Database column data_id SqlType(int8) */
  case class rDataDownload(id: Long, downloadUser: Long, downloadTime: Long, dataName: String, dataId: Long)
  /** GetResult implicit for fetching rDataDownload objects using plain SQL queries */
  implicit def GetResultrDataDownload(implicit e0: GR[Long], e1: GR[String]): GR[rDataDownload] = GR{
    prs => import prs._
    rDataDownload.tupled((<<[Long], <<[Long], <<[Long], <<[String], <<[Long]))
  }
  /** Table description of table data_download. Objects of this class serve as prototypes for rows in queries. */
  class tDataDownload(_tableTag: Tag) extends profile.api.Table[rDataDownload](_tableTag, "data_download") {
    def * = (id, downloadUser, downloadTime, dataName, dataId) <> (rDataDownload.tupled, rDataDownload.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(downloadUser), Rep.Some(downloadTime), Rep.Some(dataName), Rep.Some(dataId)).shaped.<>({r=>import r._; _1.map(_=> rDataDownload.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column download_user SqlType(int8) */
    val downloadUser: Rep[Long] = column[Long]("download_user")
    /** Database column download_time SqlType(int8) */
    val downloadTime: Rep[Long] = column[Long]("download_time")
    /** Database column data_name SqlType(varchar), Length(255,true) */
    val dataName: Rep[String] = column[String]("data_name", O.Length(255,varying=true))
    /** Database column data_id SqlType(int8) */
    val dataId: Rep[Long] = column[Long]("data_id")

    /** Index over (dataId) (database name data_download_data_id) */
    val index1 = index("data_download_data_id", dataId)
    /** Index over (downloadUser) (database name data_download_user) */
    val index2 = index("data_download_user", downloadUser)
  }
  /** Collection-like TableQuery object for table tDataDownload */
  lazy val tDataDownload = new TableQuery(tag => new tDataDownload(tag))

  /** Entity class storing rows of table tDataInfo
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param dataName Database column data_name SqlType(varchar), Length(255,true)
   *  @param owner Database column owner SqlType(int8)
   *  @param uploadTime Database column upload_time SqlType(int8)
   *  @param description Database column description SqlType(text)
   *  @param dataSize Database column data_size SqlType(int8), Default(0)
   *  @param dataAddress Database column data_address SqlType(varchar), Length(255,true)
   *  @param isTest Database column is_test SqlType(bool), Default(false)
   *  @param testDescription Database column test_description SqlType(text), Default()
   *  @param testFunction Database column test_function SqlType(varchar), Length(255,true), Default(None)
   *  @param cover Database column cover SqlType(varchar), Length(255,true), Default()
   *  @param downloadCnt Database column download_cnt SqlType(int4), Default(0)
   *  @param thumbUp Database column thumb_up SqlType(int4), Default(0)
   *  @param thumbDown Database column thumb_down SqlType(int4), Default(0)
   *  @param replyNum Database column reply_num SqlType(int4), Default(0)
   *  @param lastReplyTime Database column last_reply_time SqlType(int8), Default(0)
   *  @param isDelete Database column is_delete SqlType(int4), Default(0)
   *  @param example Database column example SqlType(varchar), Length(512,true), Default()
   *  @param resultExample Database column result_example SqlType(varchar), Length(512,true), Default()
   *  @param testDataAddress Database column test_data_address SqlType(int8), Default(0)
   *  @param resultDataAddress Database column result_data_address SqlType(int8), Default(0) */
  case class rDataInfo(id: Long, dataName: String, owner: Long, uploadTime: Long, description: String, dataSize: Long = 0L, dataAddress: String, isTest: Boolean = false, testDescription: String = "", testFunction: Option[String] = None, cover: String = "", downloadCnt: Int = 0, thumbUp: Int = 0, thumbDown: Int = 0, replyNum: Int = 0, lastReplyTime: Long = 0L, isDelete: Int = 0, example: String = "", resultExample: String = "", testDataAddress: Long = 0L, resultDataAddress: Long = 0L)
  /** GetResult implicit for fetching rDataInfo objects using plain SQL queries */
  implicit def GetResultrDataInfo(implicit e0: GR[Long], e1: GR[String], e2: GR[Boolean], e3: GR[Option[String]], e4: GR[Int]): GR[rDataInfo] = GR{
    prs => import prs._
    rDataInfo.tupled((<<[Long], <<[String], <<[Long], <<[Long], <<[String], <<[Long], <<[String], <<[Boolean], <<[String], <<?[String], <<[String], <<[Int], <<[Int], <<[Int], <<[Int], <<[Long], <<[Int], <<[String], <<[String], <<[Long], <<[Long]))
  }
  /** Table description of table data_info. Objects of this class serve as prototypes for rows in queries. */
  class tDataInfo(_tableTag: Tag) extends profile.api.Table[rDataInfo](_tableTag, "data_info") {
    def * = (id, dataName, owner, uploadTime, description, dataSize, dataAddress, isTest, testDescription, testFunction, cover, downloadCnt, thumbUp, thumbDown, replyNum, lastReplyTime, isDelete, example, resultExample, testDataAddress, resultDataAddress) <> (rDataInfo.tupled, rDataInfo.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(dataName), Rep.Some(owner), Rep.Some(uploadTime), Rep.Some(description), Rep.Some(dataSize), Rep.Some(dataAddress), Rep.Some(isTest), Rep.Some(testDescription), testFunction, Rep.Some(cover), Rep.Some(downloadCnt), Rep.Some(thumbUp), Rep.Some(thumbDown), Rep.Some(replyNum), Rep.Some(lastReplyTime), Rep.Some(isDelete), Rep.Some(example), Rep.Some(resultExample), Rep.Some(testDataAddress), Rep.Some(resultDataAddress)).shaped.<>({r=>import r._; _1.map(_=> rDataInfo.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get, _19.get, _20.get, _21.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column data_name SqlType(varchar), Length(255,true) */
    val dataName: Rep[String] = column[String]("data_name", O.Length(255,varying=true))
    /** Database column owner SqlType(int8) */
    val owner: Rep[Long] = column[Long]("owner")
    /** Database column upload_time SqlType(int8) */
    val uploadTime: Rep[Long] = column[Long]("upload_time")
    /** Database column description SqlType(text) */
    val description: Rep[String] = column[String]("description")
    /** Database column data_size SqlType(int8), Default(0) */
    val dataSize: Rep[Long] = column[Long]("data_size", O.Default(0L))
    /** Database column data_address SqlType(varchar), Length(255,true) */
    val dataAddress: Rep[String] = column[String]("data_address", O.Length(255,varying=true))
    /** Database column is_test SqlType(bool), Default(false) */
    val isTest: Rep[Boolean] = column[Boolean]("is_test", O.Default(false))
    /** Database column test_description SqlType(text), Default() */
    val testDescription: Rep[String] = column[String]("test_description", O.Default(""))
    /** Database column test_function SqlType(varchar), Length(255,true), Default(None) */
    val testFunction: Rep[Option[String]] = column[Option[String]]("test_function", O.Length(255,varying=true), O.Default(None))
    /** Database column cover SqlType(varchar), Length(255,true), Default() */
    val cover: Rep[String] = column[String]("cover", O.Length(255,varying=true), O.Default(""))
    /** Database column download_cnt SqlType(int4), Default(0) */
    val downloadCnt: Rep[Int] = column[Int]("download_cnt", O.Default(0))
    /** Database column thumb_up SqlType(int4), Default(0) */
    val thumbUp: Rep[Int] = column[Int]("thumb_up", O.Default(0))
    /** Database column thumb_down SqlType(int4), Default(0) */
    val thumbDown: Rep[Int] = column[Int]("thumb_down", O.Default(0))
    /** Database column reply_num SqlType(int4), Default(0) */
    val replyNum: Rep[Int] = column[Int]("reply_num", O.Default(0))
    /** Database column last_reply_time SqlType(int8), Default(0) */
    val lastReplyTime: Rep[Long] = column[Long]("last_reply_time", O.Default(0L))
    /** Database column is_delete SqlType(int4), Default(0) */
    val isDelete: Rep[Int] = column[Int]("is_delete", O.Default(0))
    /** Database column example SqlType(varchar), Length(512,true), Default() */
    val example: Rep[String] = column[String]("example", O.Length(512,varying=true), O.Default(""))
    /** Database column result_example SqlType(varchar), Length(512,true), Default() */
    val resultExample: Rep[String] = column[String]("result_example", O.Length(512,varying=true), O.Default(""))
    /** Database column test_data_address SqlType(int8), Default(0) */
    val testDataAddress: Rep[Long] = column[Long]("test_data_address", O.Default(0L))
    /** Database column result_data_address SqlType(int8), Default(0) */
    val resultDataAddress: Rep[Long] = column[Long]("result_data_address", O.Default(0L))

    /** Index over (isDelete) (database name data_info_isdelete_index) */
    val index1 = index("data_info_isdelete_index", isDelete)
    /** Index over (isTest) (database name data_info_istest_index) */
    val index2 = index("data_info_istest_index", isTest)
    /** Index over (owner) (database name data_info_owner) */
    val index3 = index("data_info_owner", owner)
    /** Index over (thumbUp) (database name data_info_thump_index) */
    val index4 = index("data_info_thump_index", thumbUp)
  }
  /** Collection-like TableQuery object for table tDataInfo */
  lazy val tDataInfo = new TableQuery(tag => new tDataInfo(tag))

  /** Entity class storing rows of table tDataThumb
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int8)
   *  @param dataId Database column data_id SqlType(int8)
   *  @param thumb Database column thumb SqlType(bool), Default(true)
   *  @param createTime Database column create_time SqlType(int8), Default(0) */
  case class rDataThumb(id: Long, userId: Long, dataId: Long, thumb: Boolean = true, createTime: Long = 0L)
  /** GetResult implicit for fetching rDataThumb objects using plain SQL queries */
  implicit def GetResultrDataThumb(implicit e0: GR[Long], e1: GR[Boolean]): GR[rDataThumb] = GR{
    prs => import prs._
    rDataThumb.tupled((<<[Long], <<[Long], <<[Long], <<[Boolean], <<[Long]))
  }
  /** Table description of table data_thumb. Objects of this class serve as prototypes for rows in queries. */
  class tDataThumb(_tableTag: Tag) extends profile.api.Table[rDataThumb](_tableTag, "data_thumb") {
    def * = (id, userId, dataId, thumb, createTime) <> (rDataThumb.tupled, rDataThumb.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userId), Rep.Some(dataId), Rep.Some(thumb), Rep.Some(createTime)).shaped.<>({r=>import r._; _1.map(_=> rDataThumb.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int8) */
    val userId: Rep[Long] = column[Long]("user_id")
    /** Database column data_id SqlType(int8) */
    val dataId: Rep[Long] = column[Long]("data_id")
    /** Database column thumb SqlType(bool), Default(true) */
    val thumb: Rep[Boolean] = column[Boolean]("thumb", O.Default(true))
    /** Database column create_time SqlType(int8), Default(0) */
    val createTime: Rep[Long] = column[Long]("create_time", O.Default(0L))

    /** Index over (dataId) (database name data_thump_data_id) */
    val index1 = index("data_thump_data_id", dataId)
    /** Index over (userId) (database name data_thump_user) */
    val index2 = index("data_thump_user", userId)
  }
  /** Collection-like TableQuery object for table tDataThumb */
  lazy val tDataThumb = new TableQuery(tag => new tDataThumb(tag))

  /** Entity class storing rows of table tFileDownload
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param downloadUser Database column download_user SqlType(int8)
   *  @param downloadTime Database column download_time SqlType(int8)
   *  @param fileName Database column file_name SqlType(varchar), Length(255,true)
   *  @param fileId Database column file_id SqlType(int8) */
  case class rFileDownload(id: Long, downloadUser: Long, downloadTime: Long, fileName: String, fileId: Long)
  /** GetResult implicit for fetching rFileDownload objects using plain SQL queries */
  implicit def GetResultrFileDownload(implicit e0: GR[Long], e1: GR[String]): GR[rFileDownload] = GR{
    prs => import prs._
    rFileDownload.tupled((<<[Long], <<[Long], <<[Long], <<[String], <<[Long]))
  }
  /** Table description of table file_download. Objects of this class serve as prototypes for rows in queries. */
  class tFileDownload(_tableTag: Tag) extends profile.api.Table[rFileDownload](_tableTag, "file_download") {
    def * = (id, downloadUser, downloadTime, fileName, fileId) <> (rFileDownload.tupled, rFileDownload.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(downloadUser), Rep.Some(downloadTime), Rep.Some(fileName), Rep.Some(fileId)).shaped.<>({r=>import r._; _1.map(_=> rFileDownload.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column download_user SqlType(int8) */
    val downloadUser: Rep[Long] = column[Long]("download_user")
    /** Database column download_time SqlType(int8) */
    val downloadTime: Rep[Long] = column[Long]("download_time")
    /** Database column file_name SqlType(varchar), Length(255,true) */
    val fileName: Rep[String] = column[String]("file_name", O.Length(255,varying=true))
    /** Database column file_id SqlType(int8) */
    val fileId: Rep[Long] = column[Long]("file_id")

    /** Index over (fileId) (database name file_download_data_id) */
    val index1 = index("file_download_data_id", fileId)
    /** Index over (downloadUser) (database name file_download_user) */
    val index2 = index("file_download_user", downloadUser)
  }
  /** Collection-like TableQuery object for table tFileDownload */
  lazy val tFileDownload = new TableQuery(tag => new tFileDownload(tag))

  /** Entity class storing rows of table tFileInfo
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param owner Database column owner SqlType(int8)
   *  @param fileType Database column file_type SqlType(varchar), Length(255,true)
   *  @param fileSize Database column file_size SqlType(int8)
   *  @param fileAddress Database column file_address SqlType(varchar), Length(255,true)
   *  @param fileName Database column file_name SqlType(varchar), Length(255,true), Default()
   *  @param state Database column state SqlType(int4), Default(0)
   *  @param downloadCnt Database column download_cnt SqlType(int4), Default(0) */
  case class rFileInfo(id: Long, owner: Long, fileType: String, fileSize: Long, fileAddress: String, fileName: String = "", state: Int = 0, downloadCnt: Int = 0)
  /** GetResult implicit for fetching rFileInfo objects using plain SQL queries */
  implicit def GetResultrFileInfo(implicit e0: GR[Long], e1: GR[String], e2: GR[Int]): GR[rFileInfo] = GR{
    prs => import prs._
    rFileInfo.tupled((<<[Long], <<[Long], <<[String], <<[Long], <<[String], <<[String], <<[Int], <<[Int]))
  }
  /** Table description of table file_info. Objects of this class serve as prototypes for rows in queries. */
  class tFileInfo(_tableTag: Tag) extends profile.api.Table[rFileInfo](_tableTag, "file_info") {
    def * = (id, owner, fileType, fileSize, fileAddress, fileName, state, downloadCnt) <> (rFileInfo.tupled, rFileInfo.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(owner), Rep.Some(fileType), Rep.Some(fileSize), Rep.Some(fileAddress), Rep.Some(fileName), Rep.Some(state), Rep.Some(downloadCnt)).shaped.<>({r=>import r._; _1.map(_=> rFileInfo.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column owner SqlType(int8) */
    val owner: Rep[Long] = column[Long]("owner")
    /** Database column file_type SqlType(varchar), Length(255,true) */
    val fileType: Rep[String] = column[String]("file_type", O.Length(255,varying=true))
    /** Database column file_size SqlType(int8) */
    val fileSize: Rep[Long] = column[Long]("file_size")
    /** Database column file_address SqlType(varchar), Length(255,true) */
    val fileAddress: Rep[String] = column[String]("file_address", O.Length(255,varying=true))
    /** Database column file_name SqlType(varchar), Length(255,true), Default() */
    val fileName: Rep[String] = column[String]("file_name", O.Length(255,varying=true), O.Default(""))
    /** Database column state SqlType(int4), Default(0) */
    val state: Rep[Int] = column[Int]("state", O.Default(0))
    /** Database column download_cnt SqlType(int4), Default(0) */
    val downloadCnt: Rep[Int] = column[Int]("download_cnt", O.Default(0))

    /** Index over (owner) (database name file_info_owner) */
    val index1 = index("file_info_owner", owner)
  }
  /** Collection-like TableQuery object for table tFileInfo */
  lazy val tFileInfo = new TableQuery(tag => new tFileInfo(tag))

  /** Entity class storing rows of table tTestResult
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int8)
   *  @param dataId Database column data_id SqlType(int8)
   *  @param description Database column description SqlType(text), Default()
   *  @param grade Database column grade SqlType(float4), Default(0.0)
   *  @param isMax Database column is_max SqlType(bool), Default(true)
   *  @param createTime Database column create_time SqlType(int8), Default(0)
   *  @param resultAddress Database column result_address SqlType(int8)
   *  @param isDone Database column is_done SqlType(int4), Default(0) */
  case class rTestResult(id: Long, userId: Long, dataId: Long, description: String = "", grade: Float = 0.0F, isMax: Boolean = true, createTime: Long = 0L, resultAddress: Long, isDone: Int = 0)
  /** GetResult implicit for fetching rTestResult objects using plain SQL queries */
  implicit def GetResultrTestResult(implicit e0: GR[Long], e1: GR[String], e2: GR[Float], e3: GR[Boolean], e4: GR[Int]): GR[rTestResult] = GR{
    prs => import prs._
    rTestResult.tupled((<<[Long], <<[Long], <<[Long], <<[String], <<[Float], <<[Boolean], <<[Long], <<[Long], <<[Int]))
  }
  /** Table description of table test_result. Objects of this class serve as prototypes for rows in queries. */
  class tTestResult(_tableTag: Tag) extends profile.api.Table[rTestResult](_tableTag, "test_result") {
    def * = (id, userId, dataId, description, grade, isMax, createTime, resultAddress, isDone) <> (rTestResult.tupled, rTestResult.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(userId), Rep.Some(dataId), Rep.Some(description), Rep.Some(grade), Rep.Some(isMax), Rep.Some(createTime), Rep.Some(resultAddress), Rep.Some(isDone)).shaped.<>({r=>import r._; _1.map(_=> rTestResult.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int8) */
    val userId: Rep[Long] = column[Long]("user_id")
    /** Database column data_id SqlType(int8) */
    val dataId: Rep[Long] = column[Long]("data_id")
    /** Database column description SqlType(text), Default() */
    val description: Rep[String] = column[String]("description", O.Default(""))
    /** Database column grade SqlType(float4), Default(0.0) */
    val grade: Rep[Float] = column[Float]("grade", O.Default(0.0F))
    /** Database column is_max SqlType(bool), Default(true) */
    val isMax: Rep[Boolean] = column[Boolean]("is_max", O.Default(true))
    /** Database column create_time SqlType(int8), Default(0) */
    val createTime: Rep[Long] = column[Long]("create_time", O.Default(0L))
    /** Database column result_address SqlType(int8) */
    val resultAddress: Rep[Long] = column[Long]("result_address")
    /** Database column is_done SqlType(int4), Default(0) */
    val isDone: Rep[Int] = column[Int]("is_done", O.Default(0))

    /** Index over (dataId) (database name test_result_data_id) */
    val index1 = index("test_result_data_id", dataId)
    /** Index over (userId) (database name test_result_user) */
    val index2 = index("test_result_user", userId)
  }
  /** Collection-like TableQuery object for table tTestResult */
  lazy val tTestResult = new TableQuery(tag => new tTestResult(tag))

  /** Entity class storing rows of table tUsers
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param nickName Database column nick_name SqlType(varchar), Length(255,true)
   *  @param headImg Database column head_img SqlType(varchar), Length(255,true)
   *  @param password Database column password SqlType(varchar), Length(255,true)
   *  @param email Database column email SqlType(varchar), Length(255,true)
   *  @param registerTime Database column register_time SqlType(int8)
   *  @param credit Database column credit SqlType(int4), Default(0)
   *  @param smId Database column sm_id SqlType(varchar), Length(255,true), Default(None)
   *  @param isBanned Database column is_banned SqlType(bool), Default(false) */
  case class rUsers(id: Long, nickName: String, headImg: String, password: String, email: String, registerTime: Long, credit: Int = 0, smId: Option[String] = None, isBanned: Boolean = false)
  /** GetResult implicit for fetching rUsers objects using plain SQL queries */
  implicit def GetResultrUsers(implicit e0: GR[Long], e1: GR[String], e2: GR[Int], e3: GR[Option[String]], e4: GR[Boolean]): GR[rUsers] = GR{
    prs => import prs._
    rUsers.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[Long], <<[Int], <<?[String], <<[Boolean]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class tUsers(_tableTag: Tag) extends profile.api.Table[rUsers](_tableTag, "users") {
    def * = (id, nickName, headImg, password, email, registerTime, credit, smId, isBanned) <> (rUsers.tupled, rUsers.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(nickName), Rep.Some(headImg), Rep.Some(password), Rep.Some(email), Rep.Some(registerTime), Rep.Some(credit), smId, Rep.Some(isBanned)).shaped.<>({r=>import r._; _1.map(_=> rUsers.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column nick_name SqlType(varchar), Length(255,true) */
    val nickName: Rep[String] = column[String]("nick_name", O.Length(255,varying=true))
    /** Database column head_img SqlType(varchar), Length(255,true) */
    val headImg: Rep[String] = column[String]("head_img", O.Length(255,varying=true))
    /** Database column password SqlType(varchar), Length(255,true) */
    val password: Rep[String] = column[String]("password", O.Length(255,varying=true))
    /** Database column email SqlType(varchar), Length(255,true) */
    val email: Rep[String] = column[String]("email", O.Length(255,varying=true))
    /** Database column register_time SqlType(int8) */
    val registerTime: Rep[Long] = column[Long]("register_time")
    /** Database column credit SqlType(int4), Default(0) */
    val credit: Rep[Int] = column[Int]("credit", O.Default(0))
    /** Database column sm_id SqlType(varchar), Length(255,true), Default(None) */
    val smId: Rep[Option[String]] = column[Option[String]]("sm_id", O.Length(255,varying=true), O.Default(None))
    /** Database column is_banned SqlType(bool), Default(false) */
    val isBanned: Rep[Boolean] = column[Boolean]("is_banned", O.Default(false))

    /** Index over (nickName) (database name user_nickname_index) */
    val index1 = index("user_nickname_index", nickName)
  }
  /** Collection-like TableQuery object for table tUsers */
  lazy val tUsers = new TableQuery(tag => new tUsers(tag))
}
