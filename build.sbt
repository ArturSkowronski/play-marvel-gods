name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

resolvers += "repo.codahale.com" at "http://repo.codahale.com"

libraryDependencies ++= Seq(
	jdbc,
	anorm,
	cache,
	ws
)

libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.11"

scalacOptions ++= Seq("-language:dynamics")
