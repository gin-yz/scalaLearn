//高阶函数的例子
package com.cjs.scalaLearn.fuctionAndClosure

object ExtendAndHighLevelFunction extends App {
  def totalResultOverRange(number: Int, codeBlock: Int => Int): Int = { //接受输入参数类型为Ｉｎｔ，输出参数类型为Ｉｎｔ,若输入参数为空，则使用()代替
    var result = 0
    for (i <- 1 to number) {
      result += codeBlock(i)
    }
    result
  }

  def selfFoldLeft(arr: Array[Int], initalValue: Int, operation: (Int, Int) => Int): Int = {
    var result = initalValue
    arr.foreach(i => result = operation(result, i))
    result
  }

  //求和
  println(totalResultOverRange(10, i => i))
  //偶数求和
  println(totalResultOverRange(10, i => if (i % 2 == 0) i else 0))

  //自定义foldLeft
  var array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  //求和
  println(selfFoldLeft(array, 0, (op1, op2) => op1 + op2))
  //找最大值
  println(selfFoldLeft(array, Int.MinValue, (op1, op2) => Math.max(op1, op2)))
  //使用foldLeft找最大值
  println(array.foldLeft(Int.MinValue){(op1,op2)=>Math.max(op1,op2)})
  println(array.foldLeft(Int.MinValue){Math.max}) //更精简的版本
  println((Int.MinValue/:array){Math.max}) //foldLeft可以用/:代替
}
