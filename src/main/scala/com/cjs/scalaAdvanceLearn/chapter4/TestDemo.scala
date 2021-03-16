package com.cjs.scalaAdvanceLearn.chapter4

object TestDemo {

  def main(args: Array[String]): Unit = {

    val list = List(Option(1), Option(2), Option(3))

    println(list(0).flatMap(x=>Some(x+1)))
  }

}
