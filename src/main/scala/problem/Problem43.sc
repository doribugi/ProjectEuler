val panDigitals = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 0) permutations

val divisibility = for(p <- panDigitals
      if (p(1)*100 + p(2)*10 + p(3)) % 2 == 0
      if (p(2)*100 + p(3)*10 + p(4)) % 3 == 0
      if (p(3)*100 + p(4)*10 + p(5)) % 5 == 0
      if (p(4)*100 + p(5)*10 + p(6)) % 7 == 0
      if (p(5)*100 + p(6)*10 + p(7)) % 11 == 0
      if (p(6)*100 + p(7)*10 + p(8)) % 13 == 0
      if (p(7)*100 + p(8)*10 + p(9)) % 17 == 0) yield p.map(_.toLong)

val divisibilityNumber = for(d <- divisibility) yield d.reduceLeft(10 * _ + _)

divisibilityNumber.sum
