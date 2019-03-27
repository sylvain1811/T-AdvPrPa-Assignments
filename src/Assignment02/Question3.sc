import scala.annotation.tailrec

def prod(f: Double => Double)(a: Int)(b: Int) = {
  @tailrec
  def iter(x: Int, acc: Double): Double = {
    if (x > b) acc
    else iter(x + 1, acc * f(x))

  }

  iter(a, 1)
}

prod(x => x)(2)(5)

def factorial(x: Int): Double = {
  prod(x => x)(1)(x)
}

factorial(3)

def generalized(g: Double => Double => Double)(acc: Int)(f: Double => Double)(a: Int)(b: Int) = {
  @tailrec
  def iter(x: Int, acc: Double): Double = {
    if (x > b) acc
    else iter(x + 1, g(acc)(f(x)))

  }

  iter(a, 0)
}

generalized(x => y => x + y)(0)(x => x)(1)(4)