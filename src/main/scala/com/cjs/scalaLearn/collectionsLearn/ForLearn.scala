package com.cjs.scalaLearn.collectionsLearn

object ForLearn {
  def main(args: Array[String]): Unit = {
    val result = for (i <- 1 to 10) //１到１０乘２返回
      yield i * 2 //使用yield返回
    println(result.toList)

    val result2 = (1 to 10).map(_ * 2)
    println(result2)

    val doubleresult = for (i<- 1 to 10;if i%2==0) //增加过滤器，偶数加倍
      yield i*2
    println(doubleresult)

    val doubleResult2 = for { //另外一种写法
      i<- 1 to 10
      if i % 2 ==0
    } yield i*2
    println(doubleResult2)

    //多个生成器时，相当于多个for嵌套执行，最右边的为最内层的循环
    val mutliResult = for (i<- 1 to 10;j<-11 to 50) yield s"$i,$j" //ｉ，ｊ的全排，先是i=1时,j从１１到５０
    println(mutliResult)
  }

}
