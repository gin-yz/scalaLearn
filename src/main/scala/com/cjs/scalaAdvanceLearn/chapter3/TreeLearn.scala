package com.cjs.scalaAdvanceLearn.chapter3

object TreeLearn {

  sealed trait Tree[+A]

  case class Leaf[A](value: A) extends Tree[A]

  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  object Tree {
    def size[A](t: Tree[A]): Int = {
      t match {
        case Leaf(_) => 1
        case Branch(l, f) => size(l) + size(f) + 1
      }
    }

    def maximum(t: Tree[Int]): Int = {
      t match {
        case Leaf(x) => x
        case Branch(l, r) => Math.max(maximum(l), maximum(r))
      }
    }

    def depth[A](t: Tree[A]): Int = {
      t match {
        case Leaf(x) => 1
        case Branch(l, r) => Math.max(depth(l), depth(r)) + 1
      }
    }

    def map[A, B](t: Tree[A])(f: A => B): Tree[B] = {

      t match {
        case Leaf(x)=> Leaf[B](f(x))
        case Branch(l,r) => Branch(map(l)(f),map(r)(f))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val left1 = new Leaf[Int](1)

    val left2 = new Leaf[Int](3)
    val right3 = new Leaf[Int](4)
    val branch2 = new Branch[Int](left2,right3)

    val branch = new Branch[Int](left1,branch2)

    println(Tree.size(branch))

    println(Tree.maximum(branch))

    println(Tree.depth(branch))

    println(Tree.map(branch)(x=>x.toDouble))
  }
}
