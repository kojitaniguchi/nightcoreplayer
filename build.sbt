lazy val commonSettings = Seq(
  version := "1.0.0-SNAPSHOT",
  organization := "kojitaniguchi",
  scalaVersion := "2.11.8",
  test in assembly := {}
)

lazy val app = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    mainClass in assembly := Some("mediaplayer.nightcoreplayer.Main"),
    assemblyJarName in assembly := "nightcoreplayer.jar",
    unmanagedJars in Compile += {
      val ps = new sys.SystemProperties
      val jh = ps("java.home")
      Attributed.blank(file(jh) / "lib/ext/jfxrt.jar")
    }
  )
        
