package com.cjs.scalaAdvanceLearn.chapter3

object ListTest {
  def main(args: Array[String]): Unit = {
    val value = List[Int](1 to 5:_*)
    val value3 = List[Int](1 to 10:_*)

    val value1 = value.foldLeft(List[String]())((x, y) => x.appended(y.toString))

    val value2 = value.map(x => x.toString)
    println(value2)

    println(List.concat(value,value3))

  }

}
