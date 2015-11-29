import common.Prime

val threshold = 50000000
val primes = Prime(math.sqrt(threshold).toInt).primes.toArray

var numbers = scala.collection.mutable.HashSet[Int]()
for(first <- primes) {
  var idx2 = 0
  val number1 = first * first
  var number2 = primes(idx2) * primes(idx2) * primes(idx2)
  var number = number1 + number2
  while(number < threshold) {
    var idx3 = 0
    var number3 = primes(idx3) * primes(idx3) * primes(idx3) * primes(idx3)
    number = number1 + number2 + number3
    while(number < threshold) {
      if(number < threshold) numbers += number
      idx3 += 1
      number3 = primes(idx3) * primes(idx3) * primes(idx3) * primes(idx3)
      number = number1 + number2 + number3
    }
    idx2 += 1
    number2 = primes(idx2) * primes(idx2) * primes(idx2)
    number = number1 + number2
  }
}
numbers
numbers.size