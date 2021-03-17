package com.cjs.scalaAdvanceLearn.chapter5

object LaziLearn {
  def if2[A](cond: Boolean, onTrue: () => A, onFalse: () => A): A = {
    if (cond) onTrue() else onFalse()
  }

  //和上方等效,注意，不一样的地方！！！
  //在if2_lazy的函数中，onTrue就直接是一个类型为A的值了
  def if2_lazy[A](cond: Boolean, onTrue: => A, onFalse: => A): A = {
    val value = onTrue //value就直接是一个类型为A的值了
    if (cond) onTrue else onFalse
  }

  def maybeTwice2(b: Boolean, i: => Int): Int = {
    if (b) i + i
    else 0
  }

  def maybeTwice2_lazy(b: Boolean, i: => Int): Int = {
    lazy val j = i
    if (b) j + j
    else 0
  }

  case class Cons[+A](h: () => A)

  def main(args: Array[String]): Unit = {

    if2(true,()=>println,()=>println)

    if2_lazy(true,println,println)

    println(maybeTwice2(true, {
      println("hi");
      1 + 41
    }))

    //解释为什么只输出一个hi：
    //当j+j第一次调用j的时候，会执行整个代码块，此时输出"hi"，并保存返回值42给j
    //第二次调用+后面的j时，直接返回第一次的结果42，所以不会再调用println("hi")
    println(maybeTwice2_lazy(true, {
      println("hi");
      1 + 41
    }))

  }

}
