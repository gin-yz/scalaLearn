package com.cjs.scalaLearn.testDemo


object DateTest {
  var after = "after"
  var before = "before"

  implicit class DateSelf(val value: Int) {
    import java.time.LocalDate
    private var today = LocalDate.now

    def days(how: String): LocalDate = {
      how match {
        case "after" => today.plusDays(value)
        case "before" => today.minusDays(value)
        case _ => today
      }
    }
  }

//  implicit def transToDate(value: Int): DateSelf = new DateSelf(value)

//  def main(args: Array[String]): Unit = {
//    var date: LocalDate = 2.select("after")
//    println(date)
//  }
}
