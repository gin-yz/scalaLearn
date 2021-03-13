/*
*反射的最终，类比于python的ｔｙｐｅ
* */

package com.cjs.scalaLearn.two_objectLearn

object TypeFromOther {
  class CJS(val name:String)

  def main(args: Array[String]): Unit = {
    type cjsdsg = CJS //得到类的类型
    val cjs = new cjsdsg("cjs")
    println(cjs.name)
    println(cjs.getClass)
  }

}
