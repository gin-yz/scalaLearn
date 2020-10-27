/*
* scala默认不遵循javabean规范，加上scala.beans.BeanProperty注解后就遵循了
* */

package com.cjs.scalaLearn.objectLearn

import scala.beans.BeanProperty //注意掉包

object JavaBeanWithScala {

  class Person(@BeanProperty val firstName: String, @BeanProperty val lastName: String) {
    private var age: Int = _ //age不遵循ｊａｖａｂｅａｎ规范

    def this(firstName: String, lastName: String, age: Int) {
      this(firstName, lastName)
      this.age = age
    }

    override def toString: String = s"$firstName,$lastName,$age"
  }

  def main(args: Array[String]): Unit = {
    val person = new Person("cjs","dsg")
    println(person)
  }

}
