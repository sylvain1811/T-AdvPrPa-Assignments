class Rational(n: Int, d: Int) {
  require(d != 0)
  private def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
  private val g = gcd(n, d)

  val num = n

  val denom = d

  def neg(): Rational = {
    new Rational(-num, denom)
  }

  def less(that: Rational): Boolean = {
    num * that.denom < that.num * denom
  }

  def max(that: Rational): Rational = {
    if (less(that)) that else this
  }

  override def toString: String = num + "/" + denom
}

val r1 = new Rational(1, 4)
val r2 = new Rational(1, 3)

r1.less(r2)
r1.max(r2)