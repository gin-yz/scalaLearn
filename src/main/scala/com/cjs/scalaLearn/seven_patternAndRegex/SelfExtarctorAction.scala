package com.cjs.scalaLearn.seven_patternAndRegex

object SelfExtarctorAction {

  object JudgeString {
    def process(input: String): Unit = {
      input match {
        case JudgeOne() => println(s"judgeOne activate and input is $input")
        //subInput1和subInput2是返回的结果，通过Option包装，subInput1返回后还需要通过JudgeOne的验证
        case JudgeTwo(subInput1@JudgeOne(), subInput2) => println(s"judgeOne activate and subinput is ${subInput1} and ${subInput2}") //注意@
        case _ => println(s"no judge,and input is $input")
      }
    }
  }
  //提取器需重写unapply方法
  object JudgeOne {
    def unapply(input: String): Boolean = {
      input == "cjs" || input == "dsg"
    }
  }

  object JudgeTwo {
    def unapply(input: String): Option[(String, Double)] = { //注意()
      try {
        if (input.contains(":")) {
          val splitInput = input.split(":")
          Some(splitInput(0), splitInput(1).toDouble)
        } else None
      } catch {
        case _: Exception => None
      }

    }
  }

  def main(args: Array[String]): Unit = {
    JudgeString.process("cjs")
    JudgeString.process("cjs:100")
    JudgeString.process("cjs:dsg")
    JudgeString.process("err:100")
  }

}
