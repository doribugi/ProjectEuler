package problem

import common.Fraction

/**
  * Created by greatstone on 2015. 11. 18..
  */
object Problem33 {
  def solve = {
    val fractions = Array.tabulate[Fraction](98, 98)((x, y) => Fraction(x + 1, y + 1, false))
    var set = Set[Fraction]()
    for (fractionCol <- fractions; fraction <- fractionCol
         if fraction.numer >= 10 && fraction.denom >= 10
         if fraction.numer % 10 != 0 && fraction.denom % 10 != 0
         if fraction.toDouble < 1) {
      val denom = fraction.denom.toString
      val numer = fraction.numer.toString
      if (numer(0) == denom(0) && denom(1).toString.toLong != 0
        && Fraction(numer(1).toString.toLong, denom(1).toString.toLong) == fraction)
        set += fraction
      else if (numer(1) == denom(0) && denom(1).toString.toLong != 0
        && Fraction(numer(0).toString.toLong, denom(1).toString.toLong) == fraction)
        set += fraction
      else if (numer(0) == denom(1) && denom(0).toString.toLong != 0
        && Fraction(numer(1).toString.toLong, denom(0).toString.toLong) == fraction)
        set += fraction
      else if (numer(1) == denom(1) && denom(0).toString.toLong != 0
        && Fraction(numer(0).toString.toLong, denom(0).toString.toLong) == fraction)
        set += fraction
    }
    set.reduce(_ * _)
  }
}
