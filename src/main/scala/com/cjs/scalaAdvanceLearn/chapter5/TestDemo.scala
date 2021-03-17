package com.cjs.scalaAdvanceLearn.chapter5

object TestDemo {

  def main(args: Array[String]): Unit = {
    val value = List[Int](1 to 10:_*)

    val value1 = value.take(2).map(_*2)
    println(value1)

  }

}
