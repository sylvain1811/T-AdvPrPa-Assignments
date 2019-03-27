// a
def lengthStrings(strings: List[String]): List[Int] = strings.map(_.length)
lengthStrings(List("How", "long", "are", "we?"))

// b
def dup[A](e: A, n: Int): List[A] = {
  List.range(0, n).map(_ => e)
}
dup("foo", 5)
dup(List(1, 2, 3), 2)

// c
def dot(ints1: List[Int], ints2: List[Int]): List[Int] = {
  ints1.zip(ints2).map(t => t._1 * t._2)
}
dot(List(1, 2, 3), List(2, 4, 3))
