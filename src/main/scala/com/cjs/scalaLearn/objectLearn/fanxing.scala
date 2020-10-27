package com.cjs.scalaLearn.objectLearn

object fanxing {
  def echo[T](input1: T, input2: T): Unit = {
    println(s"$input1,${input2.getClass}")
  }

  def echo2[T1, T2](input1: T1, input2: T2): Unit = {
    println(s"$input1,${input2.getClass}")
  }

  class Message[T](val content: T) {
    override def toString: String = s"content is $content"

    def is[V](value: V): Boolean = value == content
  }


  def main(args: Array[String]): Unit = {
    //随便放
    echo("cjs", 1)
    //提醒放置的类型
    echo[String]("cjs1", "dsg")

    val msg: Message[String] = new Message("cjs")
    val msg2 = new Message("cjs1")
    val msg3 = new Message[Int](123)

    println(msg.is("cjs"))
    println(msg2.is(true))
    println(msg3.is("123"))
  }
}
