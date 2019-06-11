import scala.annotation.tailrec


// a
def removePermutationsPatternMatching(l: List[(Int, Int)]): List[(Int, Int)] = {
  @tailrec
  def rec(toFilter: List[(Int, Int)], acc: List[(Int, Int)]): List[(Int, Int)] = {
    toFilter match {
      case Nil => acc
      case e :: rest => if (acc.contains((e._2, e._1))) rec(rest, acc) else rec(rest, e :: acc)
    }
  }

  rec(l, Nil).reverse
}

// b
def removePermutationsFold(l: List[(Int, Int)]): List[(Int, Int)] = {
  l.foldLeft(List.empty[(Int, Int)])((acc, e) => if (acc.contains((e._2, e._1))) acc else e :: acc).reverse
}


val l = List((1, 2), (1, 4), (2, 1), (2, 3), (2, 5), (3, 2), (3, 4), (4, 1), (4, 3), (5, 2))

removePermutationsPatternMatching(l)
removePermutationsFold(l)