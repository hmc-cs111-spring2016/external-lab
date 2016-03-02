name := "Calculator Lab"

version := "1.0"

scalaVersion := "2.11.7"

// parser-combinator library
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4"

// read-eval-print loop library
libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

// testing libraries
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.0" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
