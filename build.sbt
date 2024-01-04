import org.scalajs.linker.interface.ModuleSplitStyle
import jsenv.playwright.PWEnv
lazy val `test-vite` = project.in(file("."))
  .enablePlugins(ScalaJSPlugin) // Enable the Scala.js plugin in this project
  .enablePlugins(ScalablyTypedConverterExternalNpmPlugin)
  .settings(
    scalaVersion := "3.3.1",
    scalacOptions ++= Seq("-encoding", "utf-8", "-deprecation", "-feature"),

    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "testvite" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("testvite")))
    },

    libraryDependencies += "com.microsoft.playwright" % "playwright" % "1.40.0",
    // Depend on Laminar
    libraryDependencies += "com.raquo" %%% "laminar" % "15.0.1",
    libraryDependencies += "org.scalameta" %%% "munit" % "0.7.29" % Test,

    // Tell ScalablyTyped that we manage `npm install` ourselves
    externalNpm := baseDirectory.value,
    jsEnv := new PWEnv("chrome")
  )
