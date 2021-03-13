package com.cjs.scalaAdvanceLearn.testDemo

object Test extends App {
  var hehe:Int = (1 to 10).reduce(_+_)

  print(hehe)
}
