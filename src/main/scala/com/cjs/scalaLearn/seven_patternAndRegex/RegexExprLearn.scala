package com.cjs.scalaLearn.seven_patternAndRegex

object RegexExprLearn {
  def main(args: Array[String]): Unit = {
    val pattern = "[Ss]cala".r //末尾加r
    val string = "Scala is scalable and cool"

    println(pattern.findAllIn(string).mkString(", "))
    println(pattern findFirstIn string)
    println(pattern.findAllMatchIn(string).mkString(", "))
    println(pattern.replaceAllIn(string,"cjs"))
  }

}
