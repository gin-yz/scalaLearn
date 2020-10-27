//柯里化
package com.cjs.scalaLearn.fuctionAndClosure

object CurryingLearn{
  def selfFoldLeftNoCurry(arr: Array[Int], initValue: Int, operateor: (Int, Int) => Int): Int = {
    var result = initValue
    arr.foreach(i => {
      result = operateor(result, i)
    })
    result
  }

  def selfFoldLeftWithCurry(arr: Array[Int], initValue: Int)(operateor: (Int, Int) => Int): Int = {
    var result = initValue
    arr.foreach(i => {
      result = operateor(result, i)
    })
    result
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(selfFoldLeftNoCurry(array, 0, (op1, op2) => op1 + op2))
    //柯里化后
    println(selfFoldLeftWithCurry(array,Int.MinValue){Math.max})

  }
}
