package com.cjs.scalaLearn.four_fuctionAndClosure

object Use_Learn {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println((0/:arr){(op1,op2)=>op1+op2})
    println((0 /: arr) { _ + _ })

    println(arr.filter(_ < 5).mkString(", ")) //生成了一个新的数组
    println(arr.filter(op => op < 5).mkString(", "))
  }

}
