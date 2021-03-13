package com.cjs.scalaLearn.one_fromJavaToScala

object arrayExplodeLearn {
  def max(values: Int*): Int = values.foldLeft(Int.MinValue) {Math.max}

  val numbers: Array[Int] = Array(1, 2, 3, 4, 5, 6)


  def main(args: Array[String]): Unit = {
    println(max(numbers: _*))
  }
}
