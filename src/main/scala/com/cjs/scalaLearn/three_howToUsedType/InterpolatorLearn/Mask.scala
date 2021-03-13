package com.cjs.scalaLearn.three_howToUsedType.InterpolatorLearn

object Mask extends App {
  // #snip

  import MyInterpolator._

  val ssn = "123-45-6789"
  val account = "0246781263"
  val balance = 20145.23

  println(
    mask"""Account: $account

    |Social Security Number: $ssn

    |Balance: $$^$balance
    |Thanks for your business.""".stripMargin)
  // #snip

}
