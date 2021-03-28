package com.cjs.scalaAdvanceLearn.chapter7

object Test {
  sealed trait Par[+A]

//  object Par{
//    def unit[A](a: =>A):Par[A]
//  }

  def sum(ints:IndexedSeq[Int]):Int={
    if(ints.size<=1) ints.headOption.getOrElse(0)
    else {
      val (l,r) = ints.splitAt(ints.length / 2)
      sum(l)+sum(r)
    }
  }


  def main(args: Array[String]): Unit = {
  }


}
