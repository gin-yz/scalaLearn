/*
 * Copyright 2018 pragmatic-scala.reactiveplatform.xyz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cjs.scalaLearn.patternAndRegex

object MatchListAndMoreTail extends App {
  // #snip
  def processItems(items: List[String]): Unit = {
    items match {
      case List("apple", "ibm") => println("Apples and IBMs")
      case List("red", "blue", "white") => println("Stars and Stripes...")
      case List("red", "blue", _*) => println("colors red, blue,... ")
      //注意，otherFruits表示了之后所有的变量，后面要加@_*
      case List("apple", "orange", otherFruits@_*) => println("apples, oranges, and " + otherFruits)
    }
  }

  processItems(List("apple", "ibm"))
  processItems(List("red", "blue", "green"))
  processItems(List("red", "blue", "white"))
  processItems(List("apple", "orange", "grapes", "dates"))

  /*结果
  * Apples and IBMs
    colors red, blue,...
    Stars and Stripes...
    apples, oranges, and List(grapes, dates)*/
  // #snip

}
