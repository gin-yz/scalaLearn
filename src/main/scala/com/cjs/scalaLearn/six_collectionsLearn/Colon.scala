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
//以":"结尾的方法，调用目标是操作符后
//不允许使用字母做为操作符， 方法jumpOver:()不行，jumpOver_:()可以
//除了以:结尾的操作符之外，还有一组调用目标也是跟随它们之后的实例的操作符
//见unary.scala
package com.cjs.scalaLearn.six_collectionsLearn

object Colon extends App {
  // #snip_8-25
  class Cow {
    def ^(moon: Moon): Unit = println("Cow jumped over the moon")
  }
  class Moon {
    def ^:(cow: Cow): Unit = println("This cow jumped over the moon too")
  }
  // #snip_8-25

  // #snip_8-26
  val cow = new Cow
  val moon = new Moon

  cow ^ moon
  cow ^: moon //等价于moon.^:(cow)
  moon.^:(cow)
  // #snip_8-26

}
