package common

import org.scalatest.FunSuite

/**
  * Created by greatstone on 2015. 11. 18..
  */
class UtilSuite extends FunSuite {
  test("gcd") {
    assert(Util.gcd(10, 20) === 10)
    assert(Util.gcd(14, 21) === 7)
  }
}
