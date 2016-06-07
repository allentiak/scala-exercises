lazy val commonSettings = Seq(
  version := "0.0.1",
  scalaVersion := "2.11.8"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "merging-intervals",
    libraryDependencies ++= Seq(
 	    "org.scalatest" %% "scalatest" % "2.2.6" % "test"
      )
    )
