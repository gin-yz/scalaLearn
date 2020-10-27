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

package com.cjs.scalaLearn.howToUsedType

object FanxingAdvance2 extends App {
  //记住：这是范形不是数组
  class MyList[+T] //上转型
  var list1 = new MyList[Int]
  var list2: MyList[Any] = _
  list2 = list1 // OK

  class MyList2[-T]
  var list3 = new MyList2[Any]
  var list4 :MyList[Int] = _
//  list4 = list3 //虽然这样不对．只是说明可以这样定义
}
