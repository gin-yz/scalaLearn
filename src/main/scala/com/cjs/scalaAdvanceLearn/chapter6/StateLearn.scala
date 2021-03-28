package com.cjs.scalaAdvanceLearn.chapter6

import com.cjs.scalaAdvanceLearn.chapter6.StateLearn.RNG.{Simple, both, int, sequence, unit}

import scala.annotation.tailrec

object StateLearn {

  trait RNG {
    def nextInt: (Int, RNG)
  }

  object RNG {

    //每次返回状态和随机数
    case class Simple(seed: Long) extends RNG {
      def nextInt: (Int, RNG) = {
        val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL // `&` is bitwise AND. We use the current seed to generate a new seed.
        val nextRNG = Simple(newSeed) // The next state, which is an `RNG` instance created from the new seed.
        val n = (newSeed >>> 16).toInt // `>>>` is right binary shift with zero fill. The value `n` is our new pseudo-random integer.
        (n, nextRNG) // The return value is a tuple containing both a pseudo-random integer and the next `RNG` state.
      }
    }

    /**
     * 依据count和rng生成count个随机数，并使用List返回
     *
     * @param count 生成随机数个数
     * @param rng   状态
     * @return List和rng
     */
    def ints(count: Int)(rng: RNG): (List[Int], RNG) =
      if (count == 0) (List(), rng)
      else {
        val (n1, rng1) = rng.nextInt
        val (list, rng2) = ints(count - 1)(rng1)
        (n1 :: list, rng2)
      }

    def ints2(count: Int)(rng: RNG): (List[Int], RNG) = {
      @tailrec
      def go(count: Int, r: RNG, xs: List[Int]): (List[Int], RNG) =
        if (count == 0)
          (xs, r)
        else {
          val (x, r2) = r.nextInt
          go(count - 1, r2, x :: xs)
        }

      go(count, rng, List())
    }

    def nonNegativeInt(rng: RNG): (Int, RNG) = {
      val (i, r) = rng.nextInt
      (if (i < 0) -(i + 1) else i, r)
    }

    def double(rng: RNG): (Double, RNG) = {
      val (i, r) = nonNegativeInt(rng)
      (i / (Int.MaxValue.toDouble + 1), r)
    }

    def boolean(rng: RNG): (Boolean, RNG) =
      rng.nextInt match {
        case (i, rng2) => (i % 2 == 0, rng2)
      }

    def intDouble(rng: RNG): ((Int, Double), RNG) = {
      val (i, r1) = rng.nextInt
      val (d, r2) = double(r1)
      ((i, d), r2)
    }

    def doubleInt(rng: RNG): ((Double, Int), RNG) = {
      val ((i, d), r) = intDouble(rng)
      ((d, i), r)
    }

    def double3(rng: RNG): ((Double, Double, Double), RNG) = {
      val (d1, r1) = double(rng)
      val (d2, r2) = double(r1)
      val (d3, r3) = double(r2)
      ((d1, d2, d3), r3)
    }

    /**
     * 组合子，起了个别名，隐性的传递rng
     *
     * @tparam A
     */
    type Rand[+A] = RNG => (A, RNG)

    /**
     * 传入rng,输出下一个状态和值
     */
    val int: Rand[Int] = _.nextInt //rng=>rng.nextInt

    //将数值包装，不穿入rng状态
    def unit[A](a: A): Rand[A] =
      rng => (a, rng)

    def map[A, B](s: Rand[A])(f: A => B): Rand[B] =
      rng => {
        val (a, rng2) = s(rng)
        (f(a), rng2)
      }

    val doubleMap: Rand[Double] =
      map(nonNegativeInt)(_ / (Int.MaxValue.toDouble + 1))

    def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
      rng => {
        val (a, r1) = ra(rng)
        val (b, r2) = rb(r1)
        (f(a, b), r2)
      }

    def both[A, B](ra: Rand[A], rb: Rand[B]): Rand[(A, B)] =
      map2(ra, rb)((_, _))

    val randIntDouble: Rand[(Int, Double)] =
      both(int, double)

    val randDoubleInt: Rand[(Double, Int)] =
      both(double, int)

    def sequence[A](fs: List[Rand[A]]): Rand[List[A]] =
      fs.foldRight(unit(List[A]()))((f, acc) => map2(f, acc)(_ :: _))

    def _ints(count: Int): Rand[List[Int]] =
      sequence(List.fill(count)(int))

    def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] =
      rng => {
        val (a, r1) = f(rng)
        g(a)(r1) // We pass the new state along
      }

    def nonNegativeLessThan(n: Int): Rand[Int] = {
      flatMap(nonNegativeInt) { i =>
        val mod = i % n
        if (i + (n - 1) - mod >= 0) unit(mod) else nonNegativeLessThan(n)
      }
    }

  }


  def main(args: Array[String]): Unit = {
    val rng1 = new RNG.Simple(10)
    val (n1, rng2) = rng1.nextInt
    val (n2, rng3) = rng1.nextInt
    println(n1 == n2)
    println(rng2 == rng3)

    val value = RNG.doubleMap(rng1)
    println(value)

    println(RNG.doubleMap(Simple(428)))

    val list1 = List(unit(1), unit(2), unit(3))
    val list2 = List(Simple(1), Simple(2))
    sequence(list1)

  }

}
