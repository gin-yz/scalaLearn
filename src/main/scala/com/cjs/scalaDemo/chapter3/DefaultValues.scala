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

object DefaultValues extends App {
  // #snip_3-14
  def mail(destination: String = "head office", mailClass: String = "first"): Unit =
    println(s"sending to $destination by $mailClass class")
  // #snip_3-14

  // #snip_3-15
  mail("Houston office", "Priority")
  mail("Boston office")
  // #snip_3-15

}
