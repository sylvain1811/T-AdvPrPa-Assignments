sealed abstract class Expr

case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr

case class Product(e1: Expr, e2: Expr) extends Expr

def eval(e: Expr): Int = e match {
  case Number(n) => n
  case Sum(e1, e2) => eval(e1) + eval(e2)
  case Product(e1, e2) => eval(e1) * eval(e2)
}

def show(e: Expr): String = e match {
  case Number(n) => n.toString
  case Sum(e1, e2) => show(e1) + "+" + show(e2)
  case Product(e1, e2) =>
    val s1: String = e1 match {
      case Sum(_, _) => "(" + show(e1) + ")"
      case _ => show(e1)
    }
    val s2: String = e2 match {
      case Sum(_, _) => "(" + show(e2) + ")"
      case _ => show(e2)
    }
    s1 + "*" + s2
}

val expr0 = Sum(Product(Number(2), Number(3)), Number(4))
println("Expr0: " + show(expr0))
assert(eval(expr0) == 10)

val expr1 = Product(Number(4), Number(12))
println("Expr1: " + show(expr1))
assert(eval(expr1) == 48)

val expr2 = Product(Sum(Number(2), Number(3)), Number(4))
println("Expr2: " + show(expr2))
assert(eval(expr2) == 20)

val expr3 = Product(Number(2), Sum(Number(3), Number(4)))
println("Expr3: " + show(expr3))
assert(eval(expr3) == 14)