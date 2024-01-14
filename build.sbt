import jsenv.playwright.PWEnv
import org.scalajs.linker.interface.ModuleSplitStyle
import sbt.Test

lazy val `test-vite` = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalablyTypedConverterExternalNpmPlugin)
  .settings(
//    javaOptions += "-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005",
    scalaVersion := "3.3.1",
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("testvite"))
        )
    },
    libraryDependencies += "com.microsoft.playwright" % "playwright" % "1.40.0",
    libraryDependencies += "com.microsoft.playwright" % "driver-bundle" % "1.40.0",
    libraryDependencies += "com.raquo" %%% "laminar" % "15.0.1",
    libraryDependencies += "org.scalactic" %%% "scalactic" % "3.2.17",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.17" % Test,
    externalNpm := baseDirectory.value,
    Test / fork := false,
    Test / jsEnv := new jsenv.playwright.PWEnv(
      browserName = "chrome",
      headless = true,
      showLogs = true
    ),
    Test / parallelExecution := false
  )
