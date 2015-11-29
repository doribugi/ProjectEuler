import scala.io.Source
import scala.collection.mutable

val width = 80
val height = 80
val resource = getClass.getResource("/Problem83.txt")
val path = Array.ofDim[Int](width, height)
var i = 0
var sum = 0
for(line <- Source.fromURL(resource).getLines()) {
  path(i) = line.split(",").map(_.toInt)
  sum += path(i).sum
  i += 1
}

val accumulatePath = Array.fill[Int](width, height)(sum)
accumulatePath(0)(0) = path(0)(0)
val queue = mutable.SortedSet((path(0)(0), 0, 0))

while(queue.nonEmpty) {
  val p = queue.head
  queue -= p

  if (p._2 != 0 && accumulatePath(p._2 - 1)(p._3) > accumulatePath(p._2)(p._3) + path(p._2 - 1)(p._3)) {
    accumulatePath(p._2 - 1)(p._3) = accumulatePath(p._2)(p._3) + path(p._2 - 1)(p._3)
    queue += ((accumulatePath(p._2 - 1)(p._3), p._2 - 1, p._3))
    }
  if (p._3 != 0 && accumulatePath(p._2)(p._3 - 1) > accumulatePath(p._2)(p._3) + path(p._2)(p._3 - 1)) {
    accumulatePath(p._2)(p._3 - 1) = accumulatePath(p._2)(p._3) + path(p._2)(p._3 - 1)
    queue += ((accumulatePath(p._2)(p._3 - 1), p._2, p._3 - 1))
  }
  if (p._2 != width - 1 && accumulatePath(p._2 + 1)(p._3) > accumulatePath(p._2)(p._3) + path(p._2 + 1)(p._3)) {
    accumulatePath(p._2 + 1)(p._3) = accumulatePath(p._2)(p._3) + path(p._2 + 1)(p._3)
    queue += ((accumulatePath(p._2 + 1)(p._3), p._2 + 1, p._3))
  }
  if (p._3 != height - 1 && accumulatePath(p._2)(p._3 + 1) > accumulatePath(p._2)(p._3) + path(p._2)(p._3 + 1)) {
    accumulatePath(p._2)(p._3 + 1) = accumulatePath(p._2)(p._3) + path(p._2)(p._3 + 1)
    queue += ((accumulatePath(p._2)(p._3 + 1), p._2, p._3 + 1))
  }
}

accumulatePath(height-1)(width-1)