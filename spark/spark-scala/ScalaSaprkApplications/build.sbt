import scala.collection.Seq

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

def saprkVersion = "3.4.1"
lazy val root = (project in file("."))
  .settings(
    name := "ScalaSaprkApplications"
  )
javacOptions ++= Seq("-source", "17", "-target", "17")
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % saprkVersion  % "provided",
  "org.apache.spark" %% "spark-sql" % saprkVersion % "compile"

)
