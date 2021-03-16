package com.cjs.scalaLearn.testDemo

object demoTest extends App {
  val value = List(1, 2, 3, 4)

  private val i: Int = value.foldLeft(0)((x, _) => x + 1)
  println(i)

  private val i1: Int = value.foldRight(0)((_, x) => x + 1)
  println(i1)
}
