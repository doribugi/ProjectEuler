package problem

/**
  * Created by greatstone on 2015. 11. 15..
  */
object Problem63 {
  def imperativeSolve = {
    var count = 0
    var nSquare = BigInt(1)
    for (n : BigInt <- BigInt(1) to BigInt(9); square <- 1 to 100) {
      nSquare *= n
      if (nSquare.toString().length == square) {
        count += 1
      }
      if (square == 100) nSquare = 1
    }
    count
  }

  def functionalSolve = {
    val arr = Array.tabulate[BigInt](9, 100)((x, y) => x + 1)
    for(i <- arr.indices; j <- arr(i).indices if j != 0) arr(i)(j) *= arr(i)(j-1)
    for(i <- arr.indices; j <- arr(i).indices if arr(i)(j).toString.length == j + 1) yield arr(i)(j)
  }
}
