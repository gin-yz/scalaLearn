/*
继承学习
* */
package com.cjs.scalaLearn.objectLearn

object extendClassLearn {

  class Vehicle(val id: Int, val year: Int) {
    var cnm: Int = _

    override def toString: String = s"$id,$year"

    //重写构造方法
    def this(id: Int, year: Int, cnm: Int) {
      this(id, year)
      this.cnm = cnm
    }
  }

  class Car(override val id: Int, override val year: Int, var fuelLevel: Int) extends Vehicle(id=10, year,cnm=1) {
    //可以指定父类中的值，但是子类在构造的时候会调用父类的构造方法，会覆盖掉先前指定的值
    override def toString: String = s"${super.toString},$fuelLevel"
  }

  class Car2(override val id: Int, override val year: Int, var fuelLevel: Int) extends Vehicle(id, year) {
    override def toString: String = s"${super.toString},$fuelLevel"
  }

  def main(args: Array[String]): Unit = {
    val car = new Car(1, 2, 3)
    println(car) //1,2,3
    car.fuelLevel = 5
    println(car.cnm) //1
  }
}
