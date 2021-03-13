//trait(特质)类似接口，与ｊａｖａ接口的所有用法都差不多
//一个类使用多个特质的时候，使用with,如果只有一个，使用extends
//多个时，从右到左调用trait
package com.cjs.scalaLearn.five_traitLearn

object UseTraitLearn {

  trait Friend {
    val name: String
    def listen(): Unit = println(s"$name listen to me")
  }

  class Animal(override val name: String) extends Friend
  class Human

  class Man(override val name: String) extends Human with Friend {
    override def listen(): Unit = println(s"$name are man listen to me")
  }

  class Dog(override val name: String) extends Animal(name)

  class CJS(val name:String) extends Human
  class CJS2() extends Human

  def listenFriend(friend: Friend): Unit = friend.listen()

  def main(args: Array[String]): Unit = {
    val dog = new Dog("hehe")
    val man = new Man("haha")

    listenFriend(dog)
    listenFriend(man)

    val friend:Friend = dog
    friend.listen()

    //可以动态指定
    val friendCJS:Friend = new CJS("cjs") with Friend
    friendCJS.listen()

    val friendCJS2:Friend = new CJS2 with Friend{
      override val name: String = "cjs2"
      override def listen(): Unit = println(s"I am $name , and listening")
    }
    friendCJS2.listen()

  }

}
