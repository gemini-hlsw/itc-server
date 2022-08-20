import com.typesafe.sbt.packager.docker.Cmd

// Plugins
enablePlugins(JavaAppPackaging)
enablePlugins(BuildInfoPlugin)
enablePlugins(GitVersioning)

// Project Settings
name                 := "itc-server"
scalaVersion         := "2.11.12"
scalacOptions        += "-Yrangepos"
libraryDependencies ++= Seq(
  "org.eclipse.jetty" %  "jetty-server"  % "9.4.48.v20220622",
  "org.eclipse.jetty" %  "jetty-servlet" % "9.4.48.v20220622"
)

buildInfoKeys := Seq[BuildInfoKey](name, version, git.gitDescribedVersion, buildInfoBuildNumber)
buildInfoPackage := "itc"
