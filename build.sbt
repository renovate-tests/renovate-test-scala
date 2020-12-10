name := "renovate-test-scala"

version := "0.1"

scalaVersion := "2.13.4"

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

resolvers +=
  "Artifactory" at "https://mariuscarp.jfrog.io/artifactory/frunza/"

publishTo := Some("Artifactory Realm" at "https://mariuscarp.jfrog.io/artifactory/frunza")
credentials += Credentials("Artifactory Realm", "mariuscarp.jfrog.io", "marius.carp", "Admin123!")


// Sefaira dependencies
libraryDependencies ++= Seq(
  "com.frunza"                 %% "lib-accounts"             %  "0.1",
  "com.typesafe.akka"          %% "akka-actor"               %  "2.6.9"

)