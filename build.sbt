import com.typesafe.sbt.packager.docker.Cmd

// Plugins
enablePlugins(JavaAppPackaging)

// Project Settings
name                 := "itc-server"
scalaVersion         := "2.11.12"
scalacOptions        += "-Yrangepos"
libraryDependencies ++= Seq(
  "org.eclipse.jetty" %  "jetty-server"  % "11.0.11",
  "org.eclipse.jetty" %  "jetty-servlet" % "11.0.11"
)

