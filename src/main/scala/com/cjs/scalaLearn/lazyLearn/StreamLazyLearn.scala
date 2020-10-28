//终极惰性流
package com.cjs.scalaLearn.lazyLearn

object StreamLazyLearn extends App {
  // #snip
  def generate(starting: Int): Stream[Int] = { //指定返回是stream
    starting #:: generate(starting + 1) //#::同List的::差不多，前插，不过是惰性的
  }

  println(generate(25)) //不会运行
  // #snip

  //take(10),取前十个元素
  println(generate(25).take(10).force)
  println(generate(25).take(10).toList)
  // #snip_12-8

  //takeWhile取范围
  println(generate(25).takeWhile { _ < 40 }.force)
  // #snip_12-9

}
