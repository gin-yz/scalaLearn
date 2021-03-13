//创建一个正则表达式时，就是创建一个提取器，可以直接使用，返回Option[参数１，参数２.....]
package com.cjs.scalaLearn.seven_patternAndRegex

object RegexExtratorLearn extends App {
  // #snip_9-25
  def process(input: String): Unit = {
    val MatchStock = """^(.+):(\d*\.\d+)""".r
    input match {
      case MatchStock("GOOG", price) => println(s"We got GOOG at $$$price") //返回值是Some("GOOG",310.84)
      case MatchStock("IBM", price) => println(s"IBM's trading at $$$price")
      case MatchStock(symbol, price) => println(s"Price of $symbol is $$$price")
      case _ => println(s"not processing $input")
    }
  }
  process("GOOG:310.84")
  process("IBM:84.01")
  process("GE:15.96")
  // #snip_9-25

}
