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

package com.cjs.scalaDemo.chapter3

object OptionalSemicolon extends App {

  // #snip
  val list1 = new java.util.ArrayList[Int];
  {
    println("Created list1")
  }

  val list2 = new java.util.ArrayList[Int] {
    println("Created list2")
  }

  println(list1.getClass)
  println(list2.getClass)
  // #snip

}