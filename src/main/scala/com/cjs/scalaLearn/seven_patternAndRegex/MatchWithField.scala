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

package com.cjs.scalaLearn.seven_patternAndRegex

object MatchWithField extends App {

  // #snip
  class Sample {
    val max = 50

    def process(input: Int): Unit = {
      input match {
        case `max` => println(s"same with class max") //使用`变量名`可以访问类中变量
        case max => println(s"You matched max $max and class max is ${this.max}")
      }
    }
  }

  val sample = new Sample
  try {
    sample.process(0)
  } catch {
    case ex: Throwable => println("hehe" + ex)
  }
  sample.process(100)
  sample.process(50)
  // #snip

}
