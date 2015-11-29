package problem

import common.Fraction

/**
  * Created by greatstone on 2015. 11. 15..
  */
object Problem71 {
  def solve = {
    val arr = for (n <- 1 to 1000000 if Fraction(n * 3 / 7, n) != Fraction(3, 7) if Fraction(n * 3 / 7, n).denom <= 1000000) yield Fraction(n * 3 / 7, n)
    arr.sortWith(_ > _)(0)
  }
}
