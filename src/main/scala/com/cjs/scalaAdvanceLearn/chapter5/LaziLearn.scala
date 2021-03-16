package com.cjs.scalaAdvanceLearn.chapter5

object LaziLearn {
  def if2[A](cond: Boolean, onTrue: () => A, onFalse: () => A): A = {
    if (cond) onTrue() else onFalse()
  }

  //和上方等效
  def if2_lazy[A](cond: Boolean, onTrue: => A, onFalse: => A): A = {
    if (cond) onTrue else onFalse
  }

  def maybeTwice2(b: Boolean, i: => Int): Int = {
    if (b) i + i
    else 0
  }
  def maybeTwice2_lazy(b: Boolean, i: => Int): Int = {
    lazy val j = i
    if (b) j+j
    else 0
  }

  def main(args: Array[String]): Unit = {
    println(maybeTwice2(true, {
      println("hi");
      1 + 41
    }))

    println(maybeTwice2_lazy(true, {
      println("hi");
      1 + 41
    }))
  }

}
