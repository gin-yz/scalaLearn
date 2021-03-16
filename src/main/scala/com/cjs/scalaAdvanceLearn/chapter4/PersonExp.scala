package com.cjs.scalaAdvanceLearn.chapter4

object PersonExp {

  case class Person(name: Name,age: Age)
  sealed class Name(val value:String)
  sealed class Age(val value:Int)

  def MkName(name:String):Either[String,Name]={
    if(name==""||name==null) Left("Name is empty")
    else Right(new Name("cjs"))
  }

  def MkAge(age: Int):Either[String,Age]={
    if(age<0) Left("age is out of range")
    else Right(new Age(22))
  }

  def MkPerson(name:String,age:Int):Either[String,Person]={
    MkName(name).flatMap(name=> MkAge(age).map(age=>new Person(name,age)))
  }

  def main(args: Array[String]): Unit = {
    val cjs = MkPerson("", -1)
    println(cjs)
  }
}
