# Test project to try out the scala-js-env-playwright

1. Clone git@github.com:gmkumar2005/scala-js-env-playwright.git
2. 'sbt publishLocal' in the scala-js-env-playwright project
3. Clone git@github.com:gmkumar2005/scalajs-sbt-vite-laminar-chartjs-example.git
4. `sbt test` in the scalajs-sbt-vite-laminar-chartjs-example project

## To use the scala-js-env-playwright in your project add the following to your plugins.sbt

```scala
libraryDependencies += "io.github.gmkumar2005" %% "scala-js-env-playwright" % "0.1.8"
```





## Scala.js with sbt, Vite, Laminar and Chart.js

This is an example of putting together:

* [Scala.js](https://www.scala-js.org/)
* [sbt](https://www.scala-sbt.org/)
* [Vite](https://vitejs.dev/)
* [Laminar](https://laminar.dev/)
* [Chart.js](https://www.chartjs.org/), statically typed with [ScalablyTyped](https://scalablytyped.org/)

## Install

You need to explicitly install the following software:

* sbt, as part of [getting started with Scala](https://docs.scala-lang.org/getting-started/index.html) (or if you prefer, through [its standalone download](https://www.scala-sbt.org/download.html))
* [Node.js](https://nodejs.org/en/)

Other software will be downloaded automatically by the commands below.

## Prepare

Before doing anything, including before importing in an IDE, run

```
$ npm install
```

## Development

Open two terminals.
In the first one, start `sbt` and, within, continuously build the Scala.js project:

```
$ sbt
...
> ~fastLinkJS
...
```

In the second one, start the Vite development server with

```
$ npm run dev
...
```

Follow the URL presented to you by Vite to open the application.

You can now continuously edit the `Main.scala` file, and Vite will automatically reload the page on save.

## Production build

Make a production build with

```
$ npm run build
```

You can then find the built files in the `dist/` directory.
You will need an HTTP server, such as `python3 -m http.server`, to open the files, as Vite rewrites `<script>` tags to prevent cross-origin requests.
