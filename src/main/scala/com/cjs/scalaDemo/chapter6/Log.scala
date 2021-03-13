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

package com.cjs.scalaDemo.chapter6

object Log extends App {
  //  #snip_6-27
  import java.util.Date

  def log(date: Date, message: String): Unit = {
    //...
    println(s"$date ---- $message")
  }

  val date = new Date(1420095600000L)
  log(date, "message1")
  log(date, "message2")
  log(date, "message3")
  //  #snip_6-27

  {
    //  #snip_6-28
    val date = new Date(1420095600000L)
    val logWithDateBound = log(date, _: String)
    logWithDateBound("message1")
    logWithDateBound("message2")
    logWithDateBound("message3")
    //  #snip_6-28
  }

}
