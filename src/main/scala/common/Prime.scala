package common

import scala.collection.mutable

/**
  * Created by greatstone on 2015. 11. 19..
  */
class Prime(number: Int) {
  val primes = mutable.BitSet(2 to number: _*)
  for (p <- 2 to Math.sqrt(number).toInt if primes(p)) {
    primes --= p * p to number by p
  }
  override def toString = primes.toString
  def contains(elem: Int) = primes.contains(elem)
  def slice(from: Int, to: Int) = primes.slice(from, to)
  def foreach[B](f: (Int) => B) = primes.foreach[B](f)
  def size = primes.size
}

object Prime {
  def apply(number: Int) = new Prime(number)
}
