package problem

import common.Prime

/**
  * Created by greatstone on 2015. 11. 19..
  */
object Problem50 {
  def solve = {
    val primeArray = Prime(1000000).primes.toArray
    val primeSet = primeArray.toSet
    println(primeArray.length)

    var res = 0
    var resLength = 0
    var i = 0
    while(i < primeArray.length) {
      var sum = 0
      var length = 0
      var j = i
      while(sum < primeArray.last) {
        sum += primeArray(j)
        length += 1
        if(resLength < length && primeSet(sum)) {
          res = sum
          resLength = length
        }
        j += 1
      }
      i += 1
    }
    (resLength, res)
  }
}
