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