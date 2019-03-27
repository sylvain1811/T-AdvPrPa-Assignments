// a
def areTrue(booleans: List[Boolean]): Boolean = {
  booleans.foldRight(true)((b1: Boolean, b2: Boolean) => b1 & b2)
}
areTrue(List(true, true, false))
areTrue(List(true, true, true))

// b
def lString(strings: List[String]): Int = {
  strings.foldRight(0)((s, acc) => acc + s.length)
}
lString(List("Folding", "is", "fun"))

// c
def longest(strings: List[String]): (Int, String) = {
  strings.foldRight((0, ""))((s, t) => if (s.length > t._1) (s.length, s) else t)
}
longest(List("What", "is", "the", "longest?"))

// d
def isPresent[A](ints: List[A], value: A): Boolean = {
  ints.foldRight(false)((a: A, b: Boolean) => (a == value) | b)
}
isPresent(List(1, 2, 3, 4), 5) // false
isPresent(List(1, 2, 3, 4), 3) // true

// e
def flattenList(list: List[Any]): List[Any] = {
  list.foldRight(List.empty[Any])((a: Any, b: List[Any]) => a match {
    case l: List[Any] => flattenList(l) ++ b
    case e => e :: b
  })
}
flattenList(List(List(1, 1), 2, List(3, List(5, 8)))) // List(1, 1, 2, 3, 5, 8)