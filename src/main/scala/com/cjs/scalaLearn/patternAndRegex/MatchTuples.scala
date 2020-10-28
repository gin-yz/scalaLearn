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

object MatchTuples extends App {
  // #snip
  def processCoordinates(input: Any): Unit = { //input为Any
    input match {
      case (39, -104) => println("hehe") //可直接匹配字符的值
      case (arg1, arg2) => printf("Processing (%d, %d)...%n", arg1, arg2) //也可指定参数
      case "done" => println("done")
      case _ => println("invalid input")
    }
  }

  processCoordinates((39, -104))
  processCoordinates((1, 2))
  processCoordinates("done")
  // #snip
}
