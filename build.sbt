name := "ScalaHttpTest"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq (
  "org.http4s" %% "http4s-client" % "0.14.5",
  "org.http4s" %% "http4s-blaze-client" % "0.14.5",
  "org.http4s" %% "http4s-argonaut" % "0.14.5",
  "org.http4s" %% "http4s-core" % "0.14.5",
  "org.http4s" %% "http4s-dsl" % "0.14.5",
  "org.http4s" %% "http4s-jawn" % "0.14.5",
  "io.circe" %% "circe-core" % "0.5.1",
  "org.http4s" % "blaze-http_2.11" % "0.12.0",
  "io.circe" %% "circe-generic" % "0.5.1",
  "io.circe" %% "circe-parser" % "0.5.1"
)