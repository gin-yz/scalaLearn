package com.cjs.scalaLearn.testDemo

import java.io.PrintWriter

object FileWrite {

  object SelfWrite{
    def toWrite(fileName:String)(operate:PrintWriter=>Unit): Unit ={
      val output = new PrintWriter(fileName)
      try {
        operate(output)
      }finally {
        output.close()
      }
    }
  }

  def main(args: Array[String]): Unit = {
    SelfWrite.toWrite("./cjsdsg.txt"){op=>
      op write "cjsdsg/n"
      op write "heheh"
    }
  }

}
