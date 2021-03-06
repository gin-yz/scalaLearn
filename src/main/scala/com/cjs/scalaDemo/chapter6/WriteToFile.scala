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

object WriteToFile extends App {
  //  #snip_6-35
  import java.io._

  def writeToFile(fileName: String)(codeBlock: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(new File(fileName))
    try {
      codeBlock(writer)
    } finally {
      writer.close()
    }
  }
  //  #snip_6-35

  //  #snip_6-36
  writeToFile("output/output.txt") { writer =>
    writer.write("hello from Scala")
  }
  //  #snip_6-36

}
