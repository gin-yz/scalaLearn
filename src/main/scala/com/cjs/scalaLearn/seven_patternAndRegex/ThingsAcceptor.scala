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
//一个错误案例
package com.cjs.scalaLearn.seven_patternAndRegex

object ThingsAcceptor extends App {
  // #snip_9-13
  case class Apple()
  case class Orange()
  case class Book()

  object ThingsAcceptor {
    def acceptStuff(thing: Any): Unit = { //尽量避免使用Any接收
      thing match {
        case Apple() => println("Thanks for the Apple")
        case Orange() => println("Thanks for the Orange")
        case Book() => println("Thanks for the Book")
        case _ => println(s"Excuse me, why did you send me $thing")
      }
    }
  }
  // #snip_9-13

  // #snip_9-14
  ThingsAcceptor.acceptStuff(Apple())
  ThingsAcceptor.acceptStuff(Book())
  ThingsAcceptor.acceptStuff(Apple) //因为是Ａｎｙ，可以接收其伴生
  // #snip_9-14

}
