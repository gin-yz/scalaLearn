/*
* 类似于代理模式，在方法执行前后进行相关操作
* */

package com.cjs.scalaLearn.fuctionAndClosure

object ExecuteAroundMethod extends App {

  // #snip_6-33
  class Resource private() {
    println("Starting transaction...")

    private def cleanUp(): Unit = {
      println("Ending transaction...")
    }

    def op1(): Unit = println("Operation 1")

    def op2(): Unit = println("Operation 2")

    def op3(): Unit = println("Operation 3")
  }

  object Resource {
    def use(codeBlock: Resource => Unit): Unit = {
      val resource = new Resource
      try {
        codeBlock(resource)
      } finally {
        resource.cleanUp()
      }
    }
  }

  Resource.use { resource =>
    resource.op1()
    resource.op2()
    resource.op3()
    resource.op1()
  }
  // #snip_6-34

}
