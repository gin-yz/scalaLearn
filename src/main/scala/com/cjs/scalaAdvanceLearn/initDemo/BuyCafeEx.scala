package com.cjs.scalaAdvanceLearn.initDemo

object BuyCafeEx {

  class CreditCard()

  class Coffee(val name: String, val price: Double)

  case class Charge(cc: CreditCard, amount: Double) {
    def combine(other: Charge): Charge = {
      if (other.cc == cc) Charge(cc, other.amount + amount)
      else throw new Exception("can not combine creditCard charge")
    }
  }

  class Cafe {
    def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
      val cup = new Coffee("cjs", 11)
      (cup, Charge(cc, cup.price))
    }

    def buyCoffees(cc: CreditCard, number: Int): (List[Coffee], Charge) = {
      val purchases: List[(Coffee, Charge)] = List.fill(number) {
        buyCoffee(cc)
      }

      val (coffees, charges): (List[Coffee], List[Charge]) = purchases.unzip

      (coffees, charges.reduce(_ combine _))
    }

    //将相同信用卡的charge聚合成一个charge
    def coalesce(charges: List[Charge]): List[Charge] = {
      charges.groupBy(_.cc).values.map(_.reduce(_ combine _)).toList //仔细体会，高深
    }
  }

}

