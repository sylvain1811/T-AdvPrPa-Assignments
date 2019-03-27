
def patFoo(x: Any): Boolean = {
  x match {
    case a: Int if (a % 4 == 0) => true
    case b: Char if (b.isUpper) => true
    case c: Boolean => true
    case _ => false
  }
}

patFoo(8)
patFoo(7)
patFoo('C')
patFoo('c')
patFoo(true)
patFoo(3.4)

val nums = 1 :: 2 :: 3 :: 4 :: Nil

def insert(elem: Int, l: List[Int]): List[Int] = {
  if (l.isEmpty) elem :: Nil
  else if (elem < l.head) elem :: l
  else l.head :: insert(elem, l.tail)
}

def insertV2_patternMatching(elem: Int, l: List[Int]): List[Int] = {
  l match {
    case Nil => elem :: Nil
    case x :: y =>
      if (elem < x)
        elem :: l
      else x :: insertV2_patternMatching(elem, y)
    // x est le head de la liste, y est le reste de la liste
  }
}

def isort(xs: List[Int]): List[Int] = {
  if (xs.isEmpty) Nil
  else insert(xs.head, isort(xs.tail))
}

insert(3, Nil)
insert(3, 4 :: Nil)
insert(3, 2 :: Nil)
isort(List(7, 3, 9, 2))
