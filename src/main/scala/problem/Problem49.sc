import common.Prime

val primes = Prime(10000).primes.toArray
val subPrimes = for(p <- primes if 1000 <= p && p < 10000) yield  p
val subPrimeSet = subPrimes.toSet
var i = 0
while(i < subPrimes.length - 1) {
  val firstPrime = subPrimes(i)
  var j = i + 1
  while(j < subPrimes.length - 1) {
    val secondPrime = subPrimes(j)
    val diff = secondPrime - firstPrime
    val thirdPrime = secondPrime + diff
    if (subPrimeSet(thirdPrime)) {
      val permutations = firstPrime.toString.permutations.toArray

      if(permutations.contains(secondPrime.toString)
        && permutations.contains(thirdPrime.toString)) {
        println(firstPrime.toString + secondPrime + thirdPrime)
      }
    }
    j += 1
  }
  i += 1
}