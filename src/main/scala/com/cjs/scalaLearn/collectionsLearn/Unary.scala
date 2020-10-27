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

package com.cjs.scalaLearn.collectionsLearn

object Unary extends App {

  // #snip_8-27
  class Sample {
    //重写unary_方法,可以重新定义+-!~
    //+-!~的操作对象在后
    def unary_+(): Unit = println("Called unary +")
    def unary_-(): Unit = println("called unary -")
    def unary_!(): Unit = println("called unary !")
    def unary_~(): Unit = println("called unary ~")
  }

  val sample = new Sample
  +sample
  -sample
  !sample
  ~sample
  // #snip_8-27

}
