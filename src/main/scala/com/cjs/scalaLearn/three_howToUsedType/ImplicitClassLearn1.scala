/*
* 搞个伴随注入，不是很优雅
* */
package com.cjs.scalaLearn.three_howToUsedType

object TransFormerDate{
  val ago = "ago"
  val before = "before"

  implicit def TransFormerFun(offset:Int):TransFormerDate = new TransFormerDate(offset)
}

class TransFormerDate private(val dayNumber:Int){
  import java.time.LocalDate
  val currentDate: LocalDate = LocalDate.now
  def day(op:String):LocalDate={
    if(op=="ago") this.currentDate.plusDays(dayNumber)
    else if (op=="before") this.currentDate.minusDays(dayNumber)
    else currentDate
  }
}


object HeheTest extends App {
  import TransFormerDate._

  println(2 day ago)
  println(2 day before)
}

