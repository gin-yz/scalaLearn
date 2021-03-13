package com.cjs.scalaLearn.six_collectionsLearn


object ListLearn {
  def main(args: Array[String]): Unit = {
    val list = List("cjs", "cjs1", "cjs2")
    val list2 = List("cjs3", "cjs4", "cjs5")

    try {
      val newList = list.updated(list.size, "cjs3") //这样不行，如果往最后一个插会越界
    } catch {
      case _: IndexOutOfBoundsException => println("out of bound")
    }

    //所有的合并都是生成一个新的Ｌｉｓｔ
    println("cjsInit" :: list) //前插一个元素
    //    println(list::"cjs") //无法后插
    println(list::List("cjshou")) //这样会将第一个list当作一个整体，得到List(List(cjs, cjs1, cjs2), cjshou)
    println(list ::: List("cjshou")) //后插转换成队列
    println(list ::: list2) //两个list合并
    println()
    println(list filter (_ contains ("cjs"))) //List(cjs, cjs1, cjs2)
    println(list forall (_ contains ("cjs"))) //true,是否都包含ｃｊｓ
    println(list exists (_ contains ("cjs"))) //true,是否含有cjs

    println(list.map(_.length).mkString(", ")) //每个元素的长度
    println(list.foldLeft(0) { (sum, arg) => sum + arg.length }) //统计总元素的长度,"/:"替代
    println(list.foldRight(0){(arg,sum)=>sum+arg.length}) //使用foldRight统计，和foldLeft差不多，";\"替代
    println((0/:list){(sum,arg)=>sum+arg.length})
    println((list:\0){(arg,sum)=>sum+arg.length})
    println(list.foldLeft(0){_+_.length})
    println((0/:list){_+_.length})
  }

}
