lazy val commonSettings = Seq(
  scalaVersion := "2.11.8"
  organization := "ar.com.allentiak",
  //version := "0.0.1",
)

lazy val root = (project in file(".")).
  settings(
    commonSettings: _*,
    name := "scala-exercises",
    name := "portfolio-manager",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.6" % "test")
      )
