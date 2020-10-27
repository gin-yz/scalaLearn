/*
* 定义边界，默认为"|"
* */
package com.cjs.scalaLearn.fromJavaToScala

object MultiLine2 extends App {
  // #snip
  val str = """In his famous inaugural speech, John F. Kennedy said
              	|"And so, my fellow Americans: ask not what your country can do
              	|for you-ask what you can do for your country." He then proceeded
              	|to speak to the citizens of the World...""".stripMargin('|')
  println(str)
  // #snip

}
