import scala.annotation.tailrec

def sum(f: Double => Double, a: Int, b: Int) = {
  @tailrec
  def iter(a: Int, acc: Double): Double = {
    if (a > b) acc
    else iter(a + 1, acc + f(a))
  }

  iter(a, 0)
}

sum(x => x, 3, 5)
sum(x => 1.0, 3, 5)
sum(x => x * x * x, 3, 5)