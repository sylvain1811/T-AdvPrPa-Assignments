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

def concat(b: String, a: Int) = b + "-" + a

l.foldLeft("")(concat)

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
    def check(c: Char): Int = {
        c match {
            case '(' => 1
            case ')' => -1
            case _ => 0
        }
    }

    @tailrec
    def rec(cpt: Int, rest: List[Char]): Int = {
        rest match {
            case Nil => cpt
            case e :: Nil => cpt + check(e)
            case e :: r => rec(cpt + check(e), r)
        }
    }

    rec(0, chars) == 0
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

    val items=for (c <- customers;
        item <- c.orders)
        yield item

    items.foldLeft(List[Int]())((l:List[Int], o:Item)=>{

    })
}

println(getItems(List(c1, c2, c3)))