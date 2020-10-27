package com.cjs.scalaLearn.testDemo

object SelfInterpolator {
  implicit class SelfTypeInterpolator(val context: StringContext){
    def mask(args:Any*):String={
      val process = context.parts
        .zip(args)
        .map(item=>{
          val (text, expression) = item
          if (text.endsWith("^"))
            s"${text.split('^')(0)}$expression"
          else
            s"$text...${expression.toString.takeRight(4)}"
        }).mkString
      new StringBuilder(process).append(process.last.toString).toString
    }
  }

}
