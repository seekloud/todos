

val scalaV = "2.12.6"

val projectName = "todos2018"
val projectVersion ="2018.05.25"

resolvers += Resolver.sonatypeRepo("snapshots")

val projectMainClass = "com.neo.sk.todos2018.Boot"

def commonSettings = Seq(
  version := projectVersion,
  scalaVersion := scalaV,
  scalacOptions ++= Seq(
    //"-deprecation",
    "-feature"
  )
)

lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared"))
  .settings(name := "shared")
  .settings(commonSettings: _*)

lazy val sharedJvm = shared.jvm
lazy val sharedJs = shared.js

// Scala-Js frontend
lazy val frontend = (project in file("frontend"))
  .enablePlugins(ScalaJSPlugin)
  .settings(name := "frontend")
  .settings(commonSettings: _*)
  .settings(
    inConfig(Compile)(
      Seq(
        fullOptJS,
        fastOptJS,
        scalaJSUseMainModuleInitializer,
        packageJSDependencies,
        packageMinifiedJSDependencies
      ).map(f => (crossTarget in f) ~= (_ / "sjsout"))
    ))
  .settings(skip in packageJSDependencies := false)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    //mainClass := Some("com.neo.sk.virgour.front.Main"),
    libraryDependencies ++= Seq(
      "io.circe" %%% "circe-core" % "0.9.2" withSources(),
      "io.circe" %%% "circe-generic" % "0.9.2",
      "io.circe" %%% "circe-parser" % "0.9.2",
      "org.scala-js" %%% "scalajs-dom" % "0.9.2",
      "io.suzaku" %%% "diode" % "1.1.2",
      //"com.lihaoyi" %%% "upickle" % upickleV,
      "com.lihaoyi" %%% "scalatags" % "0.6.7" withSources(),
      "com.github.japgolly.scalacss" %%% "core" % "0.5.5" withSources(),
      //"org.scala-js" %%% "scalajs-java-time" % scalaJsJavaTime
      //"com.lihaoyi" %%% "utest" % "0.3.0" % "test"
      "in.nvilla" %%% "monadic-html" % "0.4.0-RC1" withSources(),
      "com.lihaoyi" %%% "scalatags" % "0.6.7" withSources(),
      "com.github.japgolly.scalacss" %%% "core" % "0.5.5" withSources()

    )
  )
  .dependsOn(sharedJs)





// Akka Http based backend
lazy val backend = (project in file("backend")).enablePlugins(PackPlugin)
  .settings(commonSettings: _*)
  .settings(
    mainClass in reStart := Some(projectMainClass),
    javaOptions in reStart += "-Xmx2g"
  )
  .settings(name := "backend")
  .settings(
    //pack
    // If you need to specify main classes manually, use packSettings and packMain
    //packSettings,
    // [Optional] Creating `hello` command that calls org.mydomain.Hello#main(Array[String])
    packMain := Map("todos2018" -> projectMainClass),
    packJvmOpts := Map("todos2018" -> Seq("-Xmx64m", "-Xms32m")),
    packExtraClasspath := Map("todos2018" -> Seq("."))
  )
  .settings(
    libraryDependencies ++= Dependencies.backendDependencies
  )
  .settings {
    (resourceGenerators in Compile) += Def.task {
      val fastJsOut = (fastOptJS in Compile in frontend).value.data
      val fastJsSourceMap = fastJsOut.getParentFile / (fastJsOut.getName + ".map")
      Seq(
        fastJsOut,
        fastJsSourceMap
      )
    }.taskValue
  }
  //  .settings(
  //    (resourceGenerators in Compile) += Def.task {
  //      val fullJsOut = (fullOptJS in Compile in frontend).value.data
  //      val fullJsSourceMap = fullJsOut.getParentFile / (fullJsOut.getName + ".map")
  //      Seq(
  //        fullJsOut,
  //        fullJsSourceMap
  //      )
  //    }.taskValue)
  .settings((resourceGenerators in Compile) += Def.task {
  Seq(
    (packageJSDependencies in Compile in frontend).value
    //(packageMinifiedJSDependencies in Compile in frontend).value
  )
}.taskValue)
  .settings(
    (resourceDirectories in Compile) += (crossTarget in frontend).value,
    watchSources ++= (watchSources in frontend).value
  )
  .dependsOn(sharedJvm)

lazy val root = (project in file("."))
  .aggregate(frontend, backend)
  .settings(name := projectName)





