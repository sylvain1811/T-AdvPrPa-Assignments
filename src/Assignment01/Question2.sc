def epsilon = 0.0001

def isGoodEnough(x: Double, y: Double) = math.abs(x - y) < epsilon
def improve(x: Double, a: Double) = a - (a * a - x) / (2 * a)
def compute(x: Double, a: Double): Double = if (isGoodEnough(a, improve(x, a))) improve(x, a) else compute(x, improve(x, a))
def sqrt(x: Double): Double = compute(x, 10)
sqrt(612)
