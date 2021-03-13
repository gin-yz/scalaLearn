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

package com.cjs.scalaLearn.three_howToUsedType

object FanxingAdvance extends App {

  // #snip_5-18
  class Pet(val name: String) {
    override def toString: String = name
  }

  class Dog(override val name: String) extends Pet(name)

  def workWithPets(pets: Array[Pet]): Unit = {}

  // #snip_5-18

  // #snip_5-19
  val dogs: Array[Dog] = Array(new Dog("Rover"), new Dog("Comet"))
  // #snip_5-19

  //  workWithPets(dogs) // Compilation ERROR

  //:<相当于java范型中的extends,传入的子类为pet或其子类
  def playWithPets[T <: Pet](pets: Array[T]): Unit =
    println("Playing with pets: " + pets.mkString(", "))

  // #snip_5-20

  // #snip_5-21
  playWithPets(dogs)
  // #snip_5-21

  //>:相当于java范型中的super,谁大谁是爹,":"统一在右边
  def copyPets[C, S >: C](fromPets: Array[C], toPets: Array[S]): Unit = {
    for (i <- fromPets.indices) { //等效于for(i <- 0 until fromPets.length)
      toPets(i) = fromPets(i)
    }
    //这样不行，每次都只能ｇｅｔ到值，不是引用
    //    fromPets.zip(toPets).foreach(i=>{
    //      var (from, to) = i
    //      to = from
    //    })
    println(toPets.mkString("Array(", ", ", ")"))
  }

  val pets = new Array[Dog](10)
  copyPets(dogs, pets)
  println("Playing with pets2: " + pets.mkString(", "))

  // #snip_5-22

}
