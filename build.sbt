organization := "com.mobiworx.urlifier"

name := "urlifier"

version := "0.2"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "2.4" % "test"	
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

licenses := Seq("BSD-style" -> url("http://www.opensource.org/licenses/bsd-license.php"))

homepage := Some(url("http://github.com/mobiworx/urlifier"))

pomExtra := (
  <url>http://github.com/mobiworx/urlifier</url>
  <licenses>
    <license>
      <name>BSD-style</name>
      <url>http://www.opensource.org/licenses/bsd-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:mobiworx/urlifier.git</url>
    <connection>scm:git:git@github.com:mobiworx/urlifier.git</connection>
  </scm>
  <developers>
    <developer>
      <name>Mobiworx</name>
    </developer>
  </developers>)