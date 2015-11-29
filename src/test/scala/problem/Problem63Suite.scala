package problem

import org.scalatest.FunSuite

/**
  * Created by greatstone on 2015. 11. 15..
  */
class Problem63Suite extends FunSuite {
  test("imperative solve") {
    println(Problem63.imperativeSolve)
  }

  test("functional solve") {
    println(Problem63.functionalSolve)
    println(Problem63.functionalSolve.length)
  }
}
