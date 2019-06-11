val l = List(1, 2, 3, 4)

def length[A](x: List[A]): Int = {
  (x foldRight 0) ((a, i) => i + 1)
}

length(l)

def map[A, B](x: List[A], f: A => B): List[B] = {
  (x foldRight List.empty[B]) ((x, y) => f(x) :: y)
}

map[Int, Int](l, x => x * x)


val l2 = List("a", "b", "c")
def dup[A](l: List[A]): List[A] = {
  (l foldRight List.empty[A]) ((e: A, l: List[A]) => e :: e :: l)
}
dup(l2)


/*
1) recursion + pattern matching
2) foldRight, foldLeft
[3) mix 1 et 2]
4) for comprehension
 */
def filterPatternMatching(f: Int => Boolean, list: List[Int]): List[Int] = {
  list match {
    case Nil => Nil
    case e :: rest => {
      if (f(e)) e :: filterPatternMatching(f, rest) else filterPatternMatching(f, rest)
    }
  }
}
def filterFold(f: Int => Boolean, list: List[Int]): List[Int] = {
  // list.map((f(_), _)).
  list.foldRight(List.empty[Int])((e, acc) => if (f(e)) e :: acc else acc)
}

val b = (1 to 10).toList
filterFold(_ % 2 == 0, b)

def partition(f: Int => Boolean, list: List[Int]): (List[Int], List[Int]) = {
  (filterFold(f, list), filterFold(e => !f(e), list))
}

partition(_ % 2 == 0, b)
