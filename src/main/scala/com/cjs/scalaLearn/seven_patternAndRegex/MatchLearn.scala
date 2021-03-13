package com.cjs.scalaLearn.seven_patternAndRegex

object MatchLearn {

  def activityOne(day:String):Unit={
    day match {
      case "Monday"=>println("hehe")
      case "Saturdy"=>println("haha")
      case "Friday"=>println("aaaa")
      case _=>println("none")
    }
  }

  object DayOfWeek extends Enumeration {
    val SUNDAY: DayOfWeek.Value = Value("Sunday")
    val MONDAY: DayOfWeek.Value = Value("Monday")
    val TUESDAY: DayOfWeek.Value = Value("Tuesday")
    val WEDNESDAY: DayOfWeek.Value = Value("Wednesday")
    val THURSDAY: DayOfWeek.Value = Value("Thursday")
    val FRIDAY: DayOfWeek.Value = Value("Friday")
    val SATURDAY: DayOfWeek.Value = Value("Saturday")
  }

  def activityTwo(day: DayOfWeek.Value): Unit = {
    day match {
      case DayOfWeek.SUNDAY => println("Eat, sleep, repeat...")
      case DayOfWeek.SATURDAY => println("Hang out with friends")
      case _ => println("...code for fun...")
    }
  }



  def main(args: Array[String]): Unit = {
    val list = List("Monday","Saturday","Friday","Sunday")
    list.foreach(activityOne)

    activityTwo(DayOfWeek.SUNDAY)
    activityTwo(DayOfWeek.MONDAY)
    println(DayOfWeek.MONDAY) //打印Value的值(Monday)，但是不能使用如：activityTwo("Monday")错误
  }

}
