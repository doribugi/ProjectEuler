package common

/**
  * Created by greatstone on 2015. 11. 18..
  */
class Fraction(numerator: Long, denominator: Long, reduction: Boolean) {
  require(denominator!=0)
  private val g = Util.gcd(numerator.abs, denominator.abs)
  val numer = if(reduction==true) numerator / g else numerator
  val denom = if(reduction==true) denominator / g else denominator
  def toDouble = numer.toDouble / denom.toDouble
  override def toString = numer + "/" + denom
  def <(that: Fraction) = this.numer * that.denom < that.numer * this.denom
  def >(that: Fraction) = this.numer * that.denom > that.numer * this.denom
  def !=(that: Fraction) = (this.numer != that.numer) || (this.denom != that.denom)
  def ==(that: Fraction) = (this.toDouble == that.toDouble)
  def *(that: Fraction) = Fraction(this.numer * that.numer, this.denom * that.denom)
  def reduct = Fraction(numer / g, denom / g)
}

object Fraction {
  def apply(numerator: Long, denominator: Long) = new Fraction(numerator, denominator, true)
  def apply(numerator: Long, denominator: Long, reduction: Boolean) = new Fraction(numerator, denominator, reduction)
}