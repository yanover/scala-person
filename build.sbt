name := """personnes"""
organization := "ch.yano"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

// Dependencies
libraryDependencies ++= Seq(
    guice,
    jdbc,
    "mysql" % "mysql-connector-java" % "5.1.41",
    "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
)

