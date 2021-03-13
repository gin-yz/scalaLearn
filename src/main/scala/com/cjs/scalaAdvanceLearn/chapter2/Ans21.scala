package com.cjs.scalaAdvanceLearn.chapter2

import scala.annotation.tailrec

object Ans21 {
  def fib(n: Int): Int = {
    @tailrec
    def loop(n: Int, pre: Int, cur: Int): Int = {
      if (n == 1) pre
      else loop(n - 1, cur, pre + cur)
    }

    loop(n, 0, 1)
  }
}

