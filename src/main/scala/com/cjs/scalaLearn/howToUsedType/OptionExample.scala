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
/*
* 如果值不存在，可以使用这个包装
* */
package com.cjs.scalaLearn.howToUsedType

object OptionExample extends App {
  // #snip
  def commentOnPractice(input: String) = {
    //Some和None继承了Option类，返回Option对象
    if (input == "test") Some("good") else None
  }

  for (input <- Set("test", "hack")) {
    val comment = commentOnPractice(input)
    val commentDisplay = comment.getOrElse("Found no comments") //若为None，则返回Found no comments
    println(s"input: $input comment: $commentDisplay")
  }
  // #snip
}
