package com.cjs.scalaLearn.objectLearn

import com.cjs.scalaLearn.objectLearn.EnumLearn.Currency.Currency


object EnumLearn {
  object Currency extends Enumeration {
    type Currency= Value //Value是Enumeration类中的一个实现方法，用来初始化类型对象
    val CNY, GBP, INR, JPY, NOK, PLN, SEK, USD = Value
  }

  class Money(val amount: Int, val currency: Currency) {
    override def toString = s"$amount $currency"
  }

  def main(args: Array[String]): Unit = {
    val rmb = new Money(1000,Currency.CNY)

    Currency.values.foreach(value=>println(value))
  }
}
