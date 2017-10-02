name := """Cordofonos"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.0"

libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"
libraryDependencies += "com.adrianhurt" %% "play-bootstrap" % "1.0-P25-B3"
libraryDependencies += "org.avaje" % "ebean" % "2.7.3"
libraryDependencies +="javax.persistence" % "persistence-api" % "1.0.2"
// libraryDependencies += filters
// libraryDependencies += "org.webjars" % "bootstrap" % "3.3.7-1" exclude("org.webjars", "jquery")
// libraryDependencies += "org.webjars" % "jquery" % "3.2.1"