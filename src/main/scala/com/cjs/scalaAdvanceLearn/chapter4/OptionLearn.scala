package com.cjs.scalaAdvanceLearn.chapter4

object OptionLearn {

  import scala.{Option => _, Either => _, _}

  sealed trait Option[+A] {
    def map[B](f: A => B): Option[B] = this match {
      case None => None
      case Some(a) => Some(f(a))
    }

    def getOrElse[B >: A](default: => B): B = this match {
      case None => default
      case Some(a) => a
    }

    def flatMap[B](f: A => Option[B]): Option[B] =
      map(f) getOrElse None

    def flatMap_1[B](f: A => Option[B]): Option[B] = this match {
      case None => None
      case Some(a) => f(a)
    }

    //若为None，则返回None，不然依旧返回Some()之前的
    def orElse[B >: A](ob: => Option[B]): Option[B] =
      this map (Some(_)) getOrElse ob

    def orElse_1[B >: A](ob: => Option[B]): Option[B] = this match {
      case None => ob
      case _ => this
    }

    def filter(f: A => Boolean): Option[A] = this match {
      case Some(a) if f(a) => this
      case _ => None
    }

    def filter_1(f: A => Boolean): Option[A] =
      flatMap(a => if (f(a)) Some(a) else None)
  }

  case class Some[+A](get: A) extends Option[A]

  case object None extends Option[Nothing]

  object Option {
    def mean(xs: Seq[Double]): Option[Double] =
      if (xs.isEmpty) None
      else Some(xs.sum / xs.length)

    def variance(xs: Seq[Double]): Option[Double] =
      mean(xs) flatMap (m => mean(xs.map(x => math.pow(x - m, 2))))

    //将所有的函数包装成option模式
    //比如val abs0: Option[Double] => Option[Double] = Option.lift(Math.abs)
    //option对象.map(a=> f(a))
    def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f

    //将异常处理成Option模式,例Option.Try("hello".toInt)
    def Try[A](a: => A): Option[A] = {
      try Some(a)
      catch {
        case e: Exception => None
      }
    }

    def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
      a.flatMap(ax => b.map(bx => f(ax, bx)))

    //for推导版map2
    def map2_1[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
      for{
        ax <- a
        bx <- b
      } yield f(ax,bx)

    def sequence[A](a: List[Option[A]]): Option[List[A]] =
      a match {
        case Nil => Some(Nil)
        case h :: t => h flatMap (hh => sequence(t) map (hh :: _))
      }

    def sequence_1[A](a: List[Option[A]]): Option[List[A]] =
      a.foldRight[Option[List[A]]](Some(Nil))((x,y) => map2(x,y)(_ :: _))

    def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] =
      a match {
        case Nil => Some(Nil)
        case h :: t => map2(f(h), traverse(t)(f))(_ :: _)
      }

    def traverse_1[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] =
      a.foldRight[Option[List[B]]](Some(Nil))((h,t) => map2(f(h),t)(_ :: _))

    def sequenceViaTraverse[A](a: List[Option[A]]): Option[List[A]] =
      traverse(a)(x => x)
  }

  def main(args: Array[String]): Unit = {
    val arr1 = Seq(1, 2, 3)

    val value = List(1, 2, 3)

    println(value)


  }
}
