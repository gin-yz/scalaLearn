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

object ImplicitParameters extends App {
  // #snip
  class Wifi(name: String) {
    override def toString: String = name
  }

  def connectToNetwork(user: String)(implicit wifi: Wifi): Unit = {
    println(s"User: $user connected to WIFI $wifi")
  }

  def atOffice(): Unit = {
    println("--- at the office ---")
    implicit val officeNetwork: Wifi = new Wifi("office-network")
    val cafeteriaNetwork = new Wifi("cafe-connect")

    connectToNetwork("guest")(cafeteriaNetwork)
    connectToNetwork("Jill Coder")
    connectToNetwork("Joe Hacker")
  }

  def atJoesHome(): Unit = {
    println("--- at Joe's home ---")
    implicit def homeNetwork: Wifi = new Wifi("home-network")

    connectToNetwork("guest")(homeNetwork)
    connectToNetwork("Joe Hacker")
  }

  atOffice()
  atJoesHome()
  // #snip
}
