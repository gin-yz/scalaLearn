//闭包的使用
package com.cjs.scalaLearn.four_fuctionAndClosure

object ClosureLearn {
  def loopThrough(number: Int)(closure: Int => Unit): Unit = {
    for (i <- 1 to number) closure(i)
  }

  def main(args: Array[String]): Unit = {
    var result = 0;
    val function0 = { value: Int => result += value }

    loopThrough(10){function0}
    println(result)
  }
}
