//若返回的值有两种类型，可以使用Left和Right定义,其都是继承Either类
package com.cjs.scalaLearn.three_howToUsedType

object UsingEither extends App {
  def compute(input: Int) =
    if (input > 0)
      Right(math.sqrt(input))
    else
      Left("Error computing, invalid input")
  // #snip_5-11

  // #snip_5-12
  def displayResult(result: Either[String, Double]): Unit = {
    println(s"Raw: $result")
    result match {
      case Right(value) => println(s"result $value")
      case Left(err) => println(s"Error: $err")
    }
  }
  // #snip_5-12

  // #snip_5-13
  displayResult(compute(4))
  displayResult(compute(-4))
  // #snip_5-13

}
