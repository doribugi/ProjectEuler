package problem

/**
  * Created by greatstone on 2015. 11. 16..
  */
object Problem72 {
  def gcd(x: Long, y: Long): Long = if(y == 0) x else gcd(y, x % y)

  def solve: Unit = {
    var checkMap = Array.fill[Boolean](1000001)(false)
    var checkIdx = 1
    val denominator = 1000000
    while(checkIdx <= 1000000) {
      var numerator = checkIdx
      if(!checkMap(checkIdx)) {

      }
      checkIdx += 1
    }
  }
}
