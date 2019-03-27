abstract class IntSet() {
  def add(x: Int): IntSet

  def contains(x: Int): Boolean

  def foreach(f: Int => Unit): Unit
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def add(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left add x, right)
    else if (x > elem) new NonEmpty(elem, left, right add x)
    else this
  }

  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }

  override def toString: String = "(" + left.toString + "|" + elem + "|" + right.toString + ")"

  def foreach(f: Int => Unit): Unit = {
    f(elem)
    left.foreach(f)
    right.foreach(f)
  }
}

object Empty extends IntSet() {
  def contains(x: Int): Boolean = false

  def add(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  override def toString: String = "-"

  def foreach(f: Int => Unit): Unit = Unit
}

println(Empty)
println(Empty.add(3))
println(Empty.add(3).add(2))

Empty.add(3).add(2).foreach(println)
Empty.add(3).add(2).add(6).add(1) foreach (x => print(x + 1 + ", "))

// Because it is a prefix walkthrough.