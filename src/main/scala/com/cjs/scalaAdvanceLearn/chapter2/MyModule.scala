package com.cjs.scalaAdvanceLearn.chapter2
import com.cjs.scalaAdvanceLearn.chapter2.Ans21.fib

object MyModule {
  def abs(n:Int):Int={
    if(n<0) -n
    else n
  }

  private def formatAbs(x:Int):String={
    val msg = "the absolute value of %d is %d"
    msg.format(x,abs(x))
  }

  private def formatFactorial(x:Int):String={
    val msg = "the factorial of %d is %d"
    msg.format(x,fib(x))
  }

  //抽象
  private def formatResult(name:String,x:Int,f:Int=>Int):String={
    val msg = "the %s of %d is %d"
    msg.format(name,x,f(x))
  }


  def main(args: Array[String]): Unit = {
    println(MyModule.formatAbs(-42))

    println(MyModule.formatFactorial(7))

    println(MyModule.formatResult("abs",-42,abs))

    println(MyModule.formatResult("factorial",7,fib))
  }
}
