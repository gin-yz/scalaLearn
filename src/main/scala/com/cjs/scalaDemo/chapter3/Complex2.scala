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

object Complex2 extends App {

  // #snip
  class Complex(val real: Int, val imaginary: Int) {
    def +(operand: Complex): Complex = {
      println("Calling +")
      new Complex(real + operand.real, imaginary + operand.imaginary)
    }

    def *(operand: Complex): Complex = {
      println("Calling *")
      new Complex(
        real * operand.real - imaginary * operand.imaginary,
        real * operand.imaginary + imaginary * operand.real)
    }

    override def toString: String = {
      val sign = if (imaginary < 0) "" else "+"
      s"$real$sign${imaginary}i"
    }
  }

  val c1 = new Complex(1, 4)
  val c2 = new Complex(2, -3)
  val c3 = new Complex(2, 2)
  println(c1 + c2 * c3)
  // #snip


}
