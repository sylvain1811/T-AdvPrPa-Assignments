// d, e
12 + 56
def length = 3
length * 5
def sqr(x: Double) = x * x
sqr(3)
sqr(3 + 4)
sqr(sqr(3))
def sumOfSqrs(x: Double, y: Double) = sqr(x) + sqr(y)
sumOfSqrs(2, 3)

// f
def power4(x: Double) = sqr(x) * sqr(x)
power4(3)

// g
def bar(x: Int, y: Double) = "Hello"
