sealed abstract class BinaryTree

case class Leaf(value: Int) extends BinaryTree

case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

def sumLeaves(root: BinaryTree): Int = {
  root match {
    case Leaf(value) => value
    case Node(left, right) => sumLeaves(left) + sumLeaves(right)
  }
}

def smallestElem(root: BinaryTree): Int = {
  root match {
    case Leaf(value) => value
    case Node(left, right) => Math.min(smallestElem(left), smallestElem(right))
  }
}

val root = Node(Node(Leaf(6), Leaf(2)), Node(Leaf(5), Node(Leaf(3), Leaf(4))))

sumLeaves(root)
smallestElem(root)