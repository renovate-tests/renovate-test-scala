name := "renovate-test-scala"

version := "0.1"

scalaVersion := "2.13.3"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")


initialize := {
  val _ = initialize.value
  if (sys.props("java.specification.version") != "1.8")
    sys.error("Java 8 is required for this project!")
}

scalacOptions := Seq(
  "-deprecation",
  "-feature",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-Wdead-code",
  "-Wunused:imports",
  "-Ymacro-annotations"
)

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials.domain")

resolvers ++= Seq(
  "Sefaira Releases" at "https://artifactory.domain.tools/artifactory/domain-release-sbt"
)

// Sefaira dependencies
libraryDependencies ++= Seq(
  "com.domain"                 %% "lib-accounts"             %  "15.0.0",
  "com.typesafe.akka"          %% "akka-actor"               %  "2.6.9"

)