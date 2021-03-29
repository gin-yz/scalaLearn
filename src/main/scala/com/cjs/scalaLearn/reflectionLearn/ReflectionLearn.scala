package com.cjs.scalaLearn.reflectionLearn

import java.lang.reflect.Constructor
import scala.reflect.runtime.universe
import scala.reflect.runtime.universe._
object ReflectionLearn {

  case class Fruits(id:Int,name:String){
    def func():Unit={
      println("func invoke")
    }
  }

  def main(args: Array[String]): Unit = {
    //Classloader入口
    val mirror: universe.Mirror = runtimeMirror((getClass.getClassLoader))

    val fruits: Fruits = Fruits(2,"banana")


    //生成invoker类型
    val instanceMirror: universe.InstanceMirror = mirror.reflect(fruits)

    //通过反射获取实例的方法和属性
    //属性
    val field: universe.TermSymbol = typeOf[Fruits].declaration(newTermName("name")).asTerm
    val fieldMirror: universe.FieldMirror = instanceMirror.reflectField(field)
    println(fieldMirror.get)

    fieldMirror.set("apple")
    println(fieldMirror.get)
    //方法
    val method: universe.MethodSymbol = typeOf[Fruits].declaration(newTermName("func")).asMethod
    val methodMirror: universe.MethodMirror = instanceMirror.reflectMethod(method)
    methodMirror() //调用

    //通过反射获取构造函数
    val clazz: universe.ClassSymbol = typeOf[Fruits].typeSymbol.asClass
    val classMirror: universe.ClassMirror = mirror.reflectClass(clazz)
//    val constructMethod: universe.MethodSymbol = typeOf[Fruits].declaration().asMethod
    //可以查看各种的属性和方法
//    val list: List[universe.Symbol] = clazz.typeSignature.members.toList
//    classMirror.reflectConstructor()

//    val constructMirror: universe.MethodMirror = classMirror.reflectConstructor(constructMethod)
//    val value: Any = constructMirror(2, "cjsdsg")
//    println(value)

    val constructors: Array[Constructor[_]] = classOf[Fruits].getConstructors
    val value: Any = constructors.last.newInstance(1, "cjsdsg")
    println(value)

    //error
    val value1: Constructor[_ <: Fruits.type] = Fruits.getClass.getConstructor(classOf[Int],classOf[String])
    val fruits1: Fruits.type = value1.newInstance(12, "cjsdsg2")
    println(fruits1)


    //单例对象
//    object KK{val x = 2}
//    val module: universe.ModuleSymbol = typeOf[KK.type].termSymbol.asModule
//    val moduleMirror: universe.ModuleMirror = mirror.reflectModule(module)
//    val instance: Any = moduleMirror.instance
//
//    println(instance.asInstanceOf[KK.type].x)
  }

}
