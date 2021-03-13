package com.cjs.scalaLearn.one_fromJavaToScala

object SInterpolatorLearn {


  def main(args: Array[String]): Unit = {

    val discount = 10
    var prcie = 215.12
    val message = s"hehehahah,:$$${prcie * (1 - discount / 100.0)}%2.2f" //s
    val message2= f"hehehahah,:$$${prcie * (1 - discount / 100.0)}%2.2f" //f


    prcie = 100
    println(message)
    println(message2)
  }

}
