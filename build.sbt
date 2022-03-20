name := """personnes"""
organization := "ch.yano"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

// Dependencies
libraryDependencies ++= Seq(
  guice,
  jdbc,
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "mysql" % "mysql-connector-java" % "8.0.27",
  "com.typesafe.play" %% "play-slick" % "5.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0" % Test
)
