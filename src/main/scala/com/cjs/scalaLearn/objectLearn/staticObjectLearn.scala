package com.cjs.scalaLearn.objectLearn

object staticObjectLearn {

  import scala.collection._

  class Marker private(val color: String) {
    println(s"Creating ${this}")

    override def toString = s"marker color $color"
  }

  object Marker {
    private val markers = mutable.Map(
      "red" -> new Marker("red"),
      "blue" -> new Marker("blue"),
      "yellow" -> new Marker("yellow")
    )

    def supportedColors: Iterable[String] = markers.keys

    def apply(color: String): Marker = {
      markers.getOrElseUpdate(color, op = new Marker(color))
    }

  }

  def main(args: Array[String]): Unit = {
    println(Marker("blue")) //因为写了apply对象，可以直接传值
    println(Marker("red"))
    println(Marker("green"))
    println(Marker.supportedColors)
  }
}
