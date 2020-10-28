package com.cjs.scalaLearn.testDemo

object FlatMapTest {
  def main(args: Array[String]): Unit = {
    val list = List("cjs_dsg","cjs1_dsg1")
    val mapList = list.map(_.split("_"))
    val faltMapList = list.flatMap(item=> item.split("_"))

    println(faltMapList)

  }

}
