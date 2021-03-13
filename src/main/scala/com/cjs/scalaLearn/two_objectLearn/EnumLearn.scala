package com.cjs.scalaLearn.two_objectLearn

import com.cjs.scalaLearn.two_objectLearn.EnumLearn.Currency.Currency
import com.cjs.scalaLearn.two_objectLearn.EnumLearn.CurrencySelf


object EnumLearn {
  object Currency extends Enumeration {
    type Currency= this.Value //Value是Enumeration类中的一个实现方法，用来初始化类型对象
    val CNY, GBP, INR, JPY, NOK, PLN, SEK, USD = this.Value
  }

  object CurrencySelf extends Enumeration{
    //type CurrencySelf = this.Value
    //这么写，每次指定枚举类型的时候可以直接指定CurrencySelf，而无需下面MoneySelf类中CurrencySelf.Value
    val CNY: CurrencySelf.Value = Value(10,"CNY")
    val GBY: CurrencySelf.Value = Value(11,"GBY")
    val INR: CurrencySelf.Value = Value(12,"INR")
  }

  object CurrencySelf2 extends Enumeration {
    val CNY, GBP, INR, JPY, NOK, PLN, SEK, USD = Value
  }

  class Money(val amount: Int, val currency: Currency) {
    override def toString = s"$amount $currency"
  }

  class MoneySelf(val amount: Int, val currency: CurrencySelf.Value) {
    override def toString = s"$amount $currency"
  }

  def main(args: Array[String]): Unit = {
    val rmb = new Money(1000,Currency.CNY)

    Currency.values.foreach(value=>println(value))

    CurrencySelf.values.foreach(value=>println(value.id))

    CurrencySelf2.values.foreach(println(_))

    val moneySelf = new MoneySelf(100, CurrencySelf.CNY)
  }
}
