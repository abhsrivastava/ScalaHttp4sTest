name := "ScalaHttpTest"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq (
  "org.http4s" %% "http4s-client" % "0.14.5",
  "org.http4s" %% "http4s-blaze-client" % "0.14.5",
  "org.http4s" %% "http4s-argonaut" % "0.14.5"
)