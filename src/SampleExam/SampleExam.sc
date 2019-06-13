import scala.annotation.tailrec

def foo(x: Int) = {
    println("Foo!")
    x + 1
}

def bar(x: => Int) = {
    println("x1=" + x)
    println("x2=" + x)
}

bar(foo(3))

val xs = List(1, 2, 3, 4, 5, 6)
val ys = List(2, 4, 6, 8, 10)
for ((x, i) <- xs zip xs.indices;
     y <- ys;
     if x == y)
    yield i

val l = List(1, 2, 3, 4)

def concat(b: Any, a: Int) = b + "-" + a

l.reduceLeft(concat)

def toUpper(s: String): String = {
    @tailrec
    def rec(res: String, rest: List[Char]): String = {
        rest match {
            case Nil => res
            case e :: Nil => res + e.toUpper
            case e :: r => rec(res + e.toUpper, r)
        }
    }

    rec("", s.toList)
}

toUpper("test")

def balanceMatch(chars: List[Char]): Boolean = {

    def rec(chars: List[Char], cpt: Int): Boolean = chars match {
        case Nil => cpt == 0
        case ')' :: rest => if (cpt > 0) rec(rest, cpt - 1) else false
        case '(' :: rest => rec(rest, cpt + 1)
        case _ :: rest => rec(rest, cpt)
    }

    rec(chars, 0)
}

balanceMatch("(())".toList)
balanceMatch(")(".toList)

val boolList = List(true, true, false, true)
boolList.foldLeft(0)((cpt: Int, b: Boolean) => if (b) cpt + 1 else cpt)

case class Item(name: String, qty: Int, price: Int)

case class Customer(name: String, id: Int, orders: List[Item])


val o1 = Item("Milk", 1, 1)
val o2 = Item("Pizza", 2, 5)
val o3 = Item("Coke", 1, 3)
val o4 = Item("Beer", 6, 3)

val c1 = Customer("John Doe", 123, List(o1, o2))
val c2 = Customer("Homer Simpson", 124, List(o1, o3, o4))
val c3 = Customer("Marge Simpson", 125, List(o4, o4))

def check(c: Customer): Int = {
    c.orders.foldLeft(0)((tot: Int, i: Item) => tot + i.qty * i.price)
}
check(c1)
check(c2)


def getItems(customers: List[Customer]) = {
    customers.flatMap(c => c.orders)
        .groupBy(_.name)
        .map(t => (t._1, t._2.length))
}

println(getItems(List(c1, c2, c3)))

// Streams
val primes: Stream[Int] = List(2, 3, 5, 7).toStream

def factors(n: Int): Stream[Int] = {

    def rec(in: Stream[Int], out: Stream[Int], n: Int): Stream[Int] = in match {
        case _ if n == 1 => out
        case e #:: rest => if (n % e == 0) rec(in, e #:: out, n / e) else rec(rest, out, n)
    }

    rec(primes, Stream(), n)
}
factors(90).print

val s: Stream[Int] = Stream(1, 2, 3, 4, 5, 6, 7, 8, 9)
println(s.par.map((e: Int) => e * e).seq)

List(1, 2, 3, 4).par.foreach(e => println(e))