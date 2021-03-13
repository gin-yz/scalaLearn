/*
* 单例模式,使用工厂
* */
package com.cjs.scalaLearn.two_objectLearn

object Singleton extends App {
  // #snip
  import scala.collection._

  class Marker(val color: String) {
    println(s"Creating ${this}")

    override def toString = s"marker color $color"
  }

  object MarkerFactory {
    private val markers =
      mutable.Map( //可变集合
        "red" -> new Marker("red"),
        "blue" -> new Marker("blue"),
        "yellow" -> new Marker("yellow"))

    def getMarker(color: String): Marker = {
      markers.getOrElseUpdate(color, new Marker(color))
    }
  }

  println(MarkerFactory.getMarker("blue"))
  println(MarkerFactory.getMarker("blue"))
  println(MarkerFactory.getMarker("red"))
  println(MarkerFactory.getMarker("red"))
  println(MarkerFactory.getMarker("green"))
  println(MarkerFactory.getMarker("green"))
  // #snip

}
