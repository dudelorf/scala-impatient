import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"

lazy val root = (project in file("."))
  .settings(
    name := "impatient",
    libraryDependencies += scalaTest % Test
  )
