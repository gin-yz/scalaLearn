/*
* 方法定义
* */

package com.cjs.scalaLearn.one_fromJavaToScala

object ComplexLearn {

  class Complex(val real:Int,val imaginary:Int){
    def +(opearand:Complex): Complex ={
      new Complex(this.real+opearand.real,this.imaginary+opearand.imaginary)
    }

    override def toString: String = {
      val sign = if(imaginary<0) "" else "-"
      s"$real$sign$imaginary"
    }
  }

  def main(args: Array[String]): Unit = {
    val c1 = new Complex(1,2)
    val c2 = new Complex(2,-12)
    println(c1+c2)

  }

}
