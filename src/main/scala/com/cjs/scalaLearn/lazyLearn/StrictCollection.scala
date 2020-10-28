package com.cjs.scalaLearn.lazyLearn

object StrictCollection extends App {
  // #snip
  val people = List(
    ("Mark", 32),
    ("Bob", 22),
    ("Jane", 8),
    ("Jill", 21),
    ("Nick", 50),
    ("Nancy", 42),
    ("Mike", 19),
    ("Sara", 12),
    ("Paula", 42),
    ("John", 21))

  def isOlderThan17(person: (String, Int)): Boolean = {
    println(s"isOlderThan17 called for $person")
    val (_, age) = person
    age > 17
  }

  def isNameStartsWithJ(person: (String, Int)): Boolean = {
    println(s"isNameStartsWithJ called for $person")
    val (name, _) = person
    name.startsWith("J")
  }

  println(people.filter { //严格过滤
    isOlderThan17
  }.filter {
    isNameStartsWithJ
  })

  println(people.view.filter { //惰性过滤,不调用不会执行,先执行第一个filter，若为true，再执行第二个filter，一个一个的执行，上面的是先把全部的都使用第一个filter过滤,再执行第二个ｆｉｌｔｅｒ
    isOlderThan17
  }.filter {
    isNameStartsWithJ
  }.head) //使用head调用才会被执行,若有元素通过了之后，立马停止执行,若换成.last，那么会一个一个元素的执行两个filter，不如上面的高效
  // #snip
}
