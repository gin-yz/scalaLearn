//使用trait实现一个装饰器模式
package com.cjs.scalaLearn.five_traitLearn

object Decorator extends App {
  // #snip_1
  abstract class Check {
    def check: String = "Checked Application Details..."
  }
  // #snip_1

  // #snip_2
  trait CreditCheck extends Check {
    override def check: String = s"Checked Credit... ${super.check}"
  }

  trait EmploymentCheck extends Check {
    override def check: String = s"Checked Employment...${super.check}"
  }

  trait CriminalRecordCheck extends Check {
    override def check: String = s"Check Criminal Records...${super.check}"
  }
  // #snip_2

  //调用多个trait，形成一条链条，每个ｃｈｅｃｋ方法使用super.check调用上一个check方法
  val apartmentApplication =
    new Check with CreditCheck with CriminalRecordCheck

  println(apartmentApplication.check)
  // #snip_3

  // #snip_4
  val employmentApplication =
    new Check with CriminalRecordCheck with EmploymentCheck

  println(employmentApplication.check)
  // #snip_4

}
