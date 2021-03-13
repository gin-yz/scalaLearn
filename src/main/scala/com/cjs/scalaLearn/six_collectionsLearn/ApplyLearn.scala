package com.cjs.scalaLearn.six_collectionsLearn

object ApplyLearn {
  class Person private (val firstName:String,val lastName:String)

  object Person{
    def apply(firstName: String, lastName: String): Person = new Person(firstName, lastName)
  }

  def main(args: Array[String]): Unit = {
    //调用Person伴随()的时候，自动调用apply方法
    val friends = List(Person("Brian", "Sletten"), Person("Neal", "Ford"), Person("Scott", "Davis"), Person("Stuart", "Halloway"))

    val lastNames = for(i<-friends;lastName = i.lastName) yield lastName

    println(lastNames)

    friends.map(_.lastName).foreach(println(_))
  }

}
