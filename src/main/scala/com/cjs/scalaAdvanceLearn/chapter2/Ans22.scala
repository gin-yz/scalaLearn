/**
 * 范形例子
 */
package com.cjs.scalaAdvanceLearn.chapter2

import com.cjs.scalaDemo.chapter8.Friends.Person

import scala.annotation.tailrec

object Ans22 {
  def findFirst[T](ss: Array[T], key: T): Int = {
    @tailrec
    def loop(n: Int): Int = {
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)
    }

    loop(0)
  }

  def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = {
    as.map(a => (a, true)).reduceLeft((x, y) => {
      val res = gt(x._1, y._1)
      (y._1, res && x._2)
    })._2
  }


  def isSorted2[A](as: Array[A], op: (A, A) => Boolean): Boolean = {
    @tailrec
    def go(n: Int): Boolean = {
      if (n == as.length - 1) true
      else if (!op(as(n), as(n + 1))) false
      else go(n + 1)
    }

    go(0)
  }

  def isSorted3[A](as: Array[A], op: (A, A) => Boolean): Boolean = {
    for (i <- 0 until as.length - 1) {
      if (!op(as(i), as(i + 1))) return false
    }
    true
  }

  def isSorted4[A](as: Array[A], op: (A, A) => Boolean): Boolean = {
    for (i <- 0 to as.length) {
      if (!op(as(i), as(i + 1))) return false
    }
    true
  }

  def partial1[A,B,C](a: A, f: (A,B) => C): B => C =
    (b: B) => f(a, b)

  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b)

  def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
    (a, b) => f(a)(b)
  }

  def compose[A,B,C](f:A=>B,g:B=>C):A=>C={
    a=>g(f(a))
  }

  def main(args: Array[String]): Unit = {

    val arr1 = Array[Int](1, 2, 3, 40, 5)

    println(isSorted(arr1, (x: Int, y: Int) => x < y))

    println(isSorted2(arr1, (x: Int, y: Int) => x < y))

    println(isSorted3(arr1, (x: Int, y: Int) => x < y))

    println(isSorted4(arr1, ((x: Int, y: Int) => x < y)))

    val intToInt1 = partial1(1, (x: Int, y: Int) => x + y)

    println(intToInt1(1))

    val intToIntToInt = curry((x: Int, y: Int) => x + y)

    val intToInt = intToIntToInt(1)

    val i = intToInt(2)

    println(i)

    val function = uncurry((x: Int) => (y: Int) => x + y)

    println(function(1,2))

    val intToInt2 = compose((x: Int) => x + 1, (y: Int) => y + 2)

    val i1 = intToInt2(1)

    val intToIntToInt1 = curry((x: Int, y: Int) => x + y)

    val i2 = intToIntToInt1(2)(2)
    println(i2)


  }


}
