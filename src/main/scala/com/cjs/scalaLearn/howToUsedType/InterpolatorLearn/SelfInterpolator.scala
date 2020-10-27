/*
* 传统方法实现
* */

package com.cjs.scalaLearn.howToUsedType.InterpolatorLearn

object SelfInterpolator {
  implicit class SelfTypeInterpolator(val context: StringContext){
    def mask(args:Any*):String={
      val process = context.parts
      val tempStrings = new Array[String](process.size)
      for (i<-0 until args.size){
        if(process(i).endsWith("^")){
          tempStrings(i) =  s"${process(i).split('^')(0)}${args(i).toString}"
        }else{
          tempStrings(i) = s"${process(i)}...${args(i).toString.takeRight(4)}"
        }
      }

      tempStrings(process.size-1) = process.last
      return new String(tempStrings.mkString)
    }
  }

}
