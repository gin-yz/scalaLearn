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
//自实现提取器
package com.cjs.scalaLearn.patternAndRegex

object ExtractorLearn extends App {
  object StockService {
    def process(input: String): Unit = {
      input match {
        case Symbol() => println(s"Look up price for valid symbol $input")
        // #snip_9-20
        case ReceiveStockPrice(symbol @ Symbol(), price) => //sumbol,price为返回值
          println(s"Received price $$$price for symbol $symbol") //注意，先调用ReceiveStockPrice提取器返回结果，然后再调用Symbol提取器进行判断,使用@连接
        // #snip_9-20
        case _ => println(s"Invalid input $input")
      }
    }
  }

  //提取器1
  object Symbol {
    def unapply(symbol: String): Boolean = symbol == "GOOG" || symbol == "IBM"
    // you'd look up database above... here only GOOG and IBM are recognized
  }

  //提取器2
  object ReceiveStockPrice {
    def unapply(input: String): Option[(String, Double)] = { //注意这里使用()包裹返回值
      try {
        if (input contains ":") {
          val splitQuote = input.split(":")
          Some((splitQuote(0), splitQuote(1).toDouble))
        } else {
          None
        }
      } catch {
        case _: NumberFormatException => None
      }
    }
  }

  StockService.process("GOOG")
  StockService.process("GOOG:310.84")
  StockService.process("GOOG:BUY")
  StockService.process("ERR:12.21")

}
