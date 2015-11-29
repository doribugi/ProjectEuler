package common

/**
  * Created by greatstone on 2015. 11. 18..
  */
object Util {
  def gcd(x: Long, y: Long): Long = if(y == 0) x else gcd(y, x % y)
}
