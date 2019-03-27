import scala.annotation.tailrec

// a
def fact(x: Int): Int = {
  @tailrec
  def factTail(x: Int, a: Int): Int = if (x == 0) a else factTail(x - 1, a * x)

  factTail(x, 1)
}

fact(4)

// b
def fiboV1(x: Int): Int = {
  if (x == 0) 0 else if (x == 1) 1 else fiboV1(x - 1) + fiboV1(x - 2)
}

fiboV1(7)

def fiboV2(x: Int): Int = {
  @tailrec
  def fiboTail(x: Int, y: Int, acc: Int): Int = {
    if (x == 0) acc else fiboTail(x - 1, x - 2, acc + x + y)
  }

  fiboTail(x - 1, x - 2, 0)
}

fiboV2(7)
