useJGit

// Plugins
enablePlugins(JavaAppPackaging)
enablePlugins(GitVersioning)
enablePlugins(BuildInfoPlugin)

git.useGitDescribe := true

// Project Settings
name                 := "itc-server"
scalaVersion         := "2.13.11"
scalacOptions        += "-Yrangepos"
libraryDependencies ++= Seq(
  "org.eclipse.jetty" %  "jetty-server"  % "9.4.48.v20220622",
  "org.eclipse.jetty" %  "jetty-servlet" % "9.4.48.v20220622"
)

buildInfoKeys := Seq[BuildInfoKey](name, version, git.gitDescribedVersion, git.baseVersion, buildInfoBuildNumber)
buildInfoPackage := "itc"
