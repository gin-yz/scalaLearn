package com.cjs.scalaLearn.testDemo

object User {

  class Car(val year: Int) {
    private var milesDrive: Int = 0

    def miles: Int = milesDrive

    def drive(distance: Int): Unit = {
      milesDrive += Math.abs(distance)
    }
  }

  def main(args: Array[String]): Unit = {
    val car1 = new Car(2020)
    println(car1.year)
    println(car1.miles)
    car1.drive(10)
    println(car1.miles)
  }
}
