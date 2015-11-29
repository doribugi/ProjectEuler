package problem

/**
  * Created by greatstone on 2015. 11. 17..
  */
object Problem112 {
  def isBouncyNumber(number: String) = {
    val n = number.map(_.toString.toInt)
    if(n.length == 1) false
    else if(n.reduceLeft((x, y) => if(x<=y) y else 10) != 10) false
    else if(n.reduceLeft((x, y) => if(y<=x) y else -1) != -1) false
    else true
  }
  def solve = {
    var percent = 0
    var count = 0
    var n = 0
    while(percent < 99) {
      n += 1
      if(isBouncyNumber(n.toString)) count += 1
      percent = count * 100 / n
    }
    n
  }
}
