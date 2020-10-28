//惰性求质数
package com.cjs.scalaLearn.lazyLearn

object StreamLazyLearn2 extends App {
  // #snip_12-10
  def isDivisibleBy(number: Int, divisor: Int) = number % divisor == 0

  def isPrime(number: Int) =
    number > 1 && !(2 until number).exists { isDivisibleBy(number, _) }

  def primes(starting: Int): Stream[Int] = {
    println(s"computing for $starting")
    if (isPrime(starting))
      starting #:: primes(starting + 1)
    else
      primes(starting + 1)
  }

  // #snip_12-10

  // #snip_12-11
  val primesFrom100 = primes(100)

  println(primesFrom100.take(3).toList)
  println("Let's ask for more...")
  println(primesFrom100.take(4).toList) //因为已经执行了前面的3个，所以继续上面的开始运行
  // #snip_12-11

}
