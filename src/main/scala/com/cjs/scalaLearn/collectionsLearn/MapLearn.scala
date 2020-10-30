package com.cjs.scalaLearn.collectionsLearn

import java.util.NoSuchElementException

import scala.collection.mutable

object MapLearn {
  def main(args: Array[String]): Unit = {
    val feeds = Map( //默认都是不可变对象
      "cjs" -> "dsg",
      "cjs2" -> "dsg2",
      "cjs3" -> "dsg3"
    )
    println(feeds filterKeys (_ startsWith "cjs"))

    val feeds2 = feeds filter (items => {
      val (k, v) = items
      (k startsWith "c") && (v endsWith "2")
    })
    println(feeds2)

    val result = feeds.get("cjs1") //get()方法得到Some或None对象
    println(result.getOrElse("null cjs1"))
    println(feeds.get("cjs"))

    println(feeds("cjs")) //直接得到对象

    try {
      println(feeds("cjs1")) //会抛空异常
    } catch {
      case _: NoSuchElementException =>println("Not found")
    }

    val newFeeds = feeds.updated("cjs4","dsg4")
    println(newFeeds)

    val mutableFeeds: mutable.Map[String, String] = scala.collection.mutable.Map(
      "cjs" -> "dsg",
      "cjs2" -> "dsg2",
      "cjs3" -> "dsg3"
    )
    mutableFeeds("cjs5") = "dsg5"
    println(mutableFeeds)
  }

}
