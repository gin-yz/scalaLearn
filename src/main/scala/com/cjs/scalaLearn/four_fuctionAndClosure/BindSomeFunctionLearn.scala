//绑定部分参数函数
package com.cjs.scalaLearn.four_fuctionAndClosure

import java.util.Date


object BindSomeFunctionLearn {
  def log(date: Date,message:String): Unit ={
    println(s"$date------$message")
  }

  def main(args: Array[String]): Unit = {
    val date = new Date();
    val bindDateFunction = log(date,_:String)

    bindDateFunction("cjs")
    bindDateFunction("cjs1")
    bindDateFunction("cjs2")
  }
}
