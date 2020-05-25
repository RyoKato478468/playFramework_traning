name := """app01"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.8"

libraryDependencies += guice

//h2db接続用のライブラリを追加
libraryDependencies += "com.h2database" % "h2" % "1.4.192"
