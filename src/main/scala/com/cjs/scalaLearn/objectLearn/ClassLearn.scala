/*
* 重载构造函数
* */
package com.cjs.scalaLearn.objectLearn

object ClassLearn extends App {
  // #snip
  class Person(val firstName: String, val lastName: String) {
    var position: String = _ //变量初始化使用"_"指定默认值,也可以使用null\

    println(s"Creating $toString")

    def this(firstName: String, lastName: String, positionHeld: String) {
      this(firstName, lastName)
      position = positionHeld
    }
    override def toString: String = {
      s"$firstName $lastName holds $position position"
    }
  }

  val john = new Person("John", "Smith", "Analyst")
  println(john)
  val bill = new Person("Bill", "Walker")
  println(bill)
  // #snip

}
