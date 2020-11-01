package com.cjs.scalaLearn.collectionsLearn

object SetLearn {
  def main(args: Array[String]): Unit = {
    val colors = Set("Bule", "Green", "Red")
    val colors2 = colors + "Black"
    println(colors) //colors不变
    println(colors2)

    val colors3 = Set(1, 2, 3, "cjs")
    println(colors3)

    val feeds1 = Set("cjs1", "cjs2", "cjs3")
    val feeds2 = Set("cjs2", "cjs3", "cjs4")
    println(feeds1 filter (_ contains "cjs"))c
    println(feeds1 ++ feeds2)
    println(feeds1 & feeds2)
    println(feeds1 map ("dsg " + _))
    feeds1 foreach { arg => println("cjs " + arg) }
//    feeds1 foreach{println("cjs "+_);} //不知道为什么不行
  }
}