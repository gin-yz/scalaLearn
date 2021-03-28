package com.cjs.scalaAdvanceLearn.chapter3

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object ListLearn {

  //Nothing是所有类的子类，因为Nil为什么都没为List[Nothing]，所以是A+而不是A
  sealed trait List[+A]

  case object Nil extends List[Nothing]

  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {
    //因为构造的时候是Cons(a,Cons(b,Cons(c,Nil)))这样的，所以可以模式匹配
    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0 //最后一个元素
      case Cons(x, xs) => x + sum(xs)
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0 //最后一个元素
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] =
      if (as.isEmpty) Nil
      else {
        println(as)
        Cons(as.head, apply(as.tail: _*))
      }

    def tail[A](l: List[A]): List[A] = l match {
      case Nil => sys.error("tail of empty list")
      case Cons(_, t) => t
    }

    def setHead[A](l: List[A], h: A): List[A] = l match {
      case Nil => sys.error("setHead on empty list")
      case Cons(_, t) => Cons(h, t)
    }

    @tailrec
    def drop[A](l: List[A], n: Int): List[A] =
      if (n <= 0) l
      else l match {
        case Nil => Nil
        case Cons(_, t) => drop(t, n - 1)
      }

    @tailrec
    def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
      case Cons(h, t) if f(h) => dropWhile(t, f)
      case _ => l
    }

    //    List.dropWhileNoType(value2)(x=>x<=2)
    def dropWhileNoType[A](l: List[A])(f: A => Boolean): List[A] = l match {
      case Cons(h, t) if f(h) => dropWhile(t, f)
      case _ => l
    }

    def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
      case Nil => a2
      case Cons(h, t) => Cons(h, append(t, a2))
    }

    def init[A](l: List[A]): List[A] =
      l match {
        case Nil => Nil
        case Cons(_, Nil) => Nil
        case Cons(x, xy) => Cons(x, init(xy))
      }

    /**
     * List.foldRight(List(1, 2, 3, 4), Nil: List[Int])(Cons(_, _))
     *
     * @param as 操作列表
     * @param z  初始累加值
     * @param f  操作函数
     */
    def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
      as match {
        case Nil => z
        case Cons(x, xy) => f(x, foldRight(xy, z)(f))
      }
    }

    @annotation.tailrec
    def foldLeft[A, B](l: List[A], z: B)(f: (B, A) => B): B = l match {
      case Nil => z
      case Cons(h, t) => foldLeft(t, f(z, h))(f)
    }

    def sum2(ns: List[Int]): Int =
      foldRight(ns, 0)((x, y) => x + y)

    def product2(ns: List[Double]): Double =
      foldRight(ns, 1.0)(_ * _)

    def length[A](as: List[A]): Int = {
      foldRight(as, 0)((_, y) => y + 1)
    }

    //我写的，下面是官方更加简单的
    def reverseList[A](as: List[A]): List[A] = {
      as match {
        case Cons(x, Nil) => as
        case Cons(x, xy) => List.append(reverseList(xy), List[A](x))
      }
    }

    def reverse[A](l: List[A]): List[A] =
      foldLeft(l, List[A]())((acc, h) => Cons(h, acc))

    //    def appendUseFold[A](a1: List[A], a2: List[A]): List[A]={
    //      foldLeft(a1, a2)(Cons(_,_))
    //    }

    def appendViaFoldRight[A](l: List[A], r: List[A]): List[A] =
      foldRight(l, r)(Cons(_, _))

    def concat[A](l: List[List[A]]): List[A] =
      foldRight(l, Nil: List[A])(append)

    def add1(l: List[Int]): List[Int] = {
      foldRight(l, Nil: List[Int])((x, y) => Cons(x + 1, y))
    }

    def doubleToString(l: List[Double]): List[String] = {
      foldRight(l, Nil: List[String])((x, y) => Cons(x.toString, y))
    }

    def map[A, B](as: List[A])(f: A => B): List[B] = {
      foldRight(as, Nil: List[B])((x, y) => Cons(f(x), y))
    }

    def map_2[A, B](l: List[A])(f: A => B): List[B] = {
      val buf = new collection.mutable.ListBuffer[B]

      @tailrec
      def go(l: List[A]): Unit = l match {
        case Nil => ()
        case Cons(h, t) => buf += f(h); go(t)
      }

      go(l)
      List(buf.toList: _*) // converting from the standard Scala list to the list we've defined here
    }

    def filter[A](l: List[A])(f: A => Boolean): List[A] = {
      foldRight(l, Nil: List[A])((x, y) => {
        if (f(x)) Cons(x, y)
        else y
      })
    }

    def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = {
      concat(map(l)(f))
    }

    def filterUseFlatMap[A](l: List[A])(f: A => Boolean): List[A] = {
      flatMap(l)(a => if (f(a)) List(a) else Nil)
    }

    def addPairwise(a: List[Int], b: List[Int]): List[Int] = {
      (a, b) match {
        case (_, Nil) => Nil
        case (Nil, _) => Nil
        case (Cons(x1,xy1),Cons(x2,xy2)) => Cons(x1+x2,addPairwise(xy1,xy2))
      }
    }

    def zipWith[A,B,C](a: List[A], b: List[B])(f: (A,B) => C): List[C] = (a,b) match {
      case (Nil, _) => Nil
      case (_, Nil) => Nil
      case (Cons(h1,t1), Cons(h2,t2)) => Cons(f(h1,h2), zipWith(t1,t2)(f))
    }

    @annotation.tailrec
    def startsWith[A](l: List[A], prefix: List[A]): Boolean = (l,prefix) match {
      case (_,Nil) => true
      case (Cons(h,t),Cons(h2,t2)) if h == h2 => startsWith(t, t2)
      case _ => false
    }

    @annotation.tailrec
    def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = sup match {
      case Nil => sub == Nil
      case _ if startsWith(sup, sub) => true
      case Cons(h,t) => hasSubsequence(t, sub)
    }


  }

  def main(args: Array[String]): Unit = {
    val value = List[String]("a", "b", "c")

    val value2 = List[Int](1, 2, 3, 4)

    println(value)

    //    println(List.length(value2))
    //
    //    println(List.reverseList(value))

    //    println(List.doubleToString(List[Double](1,2,3,4,5)))
    //    println(List.filter(value2)(_<3))

  }
}
