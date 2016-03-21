lazy val commonSettings = Seq(
  scalaVersion := "2.11.8"
  organization := "ar.com.allentiak",
  //version := "0.0.1",

  unmanagedJars in Compile += file(System.getenv("HOME") + "/R/x86_64-pc-linux-gnu-library/3.2/rscala/java/rscala_2.11-1.0.9.jar")
)

lazy val root = (project in file(".")).
  settings(
    commonSettings: _*,
    name := "scala-exercises",
    name := "portfolio-manager",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "2.2.6" % "test")
      )
