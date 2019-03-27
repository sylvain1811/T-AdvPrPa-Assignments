// SUM WITH HIGHER ORDER FUNCTIONS

def sum(f: Int => Double, a: Int, b: Int): Double = {
  if (a > b) 0 else f(a) + sum(f, a + 1, b)
}

def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)

def sumRec(a: Int, b: Int) = sum(x => 1 / x, a, b)

def sumInts(a: Int, b: Int) = sum(x => x, a, b)