package random {

  object RandomTester {
    def printIt() { println(nextInt()) }
  }
}

package object random {
  private var seed: Int = 0
  private var next: Int = 0
  private var previous: Int = 0

  def nextInt(): Int = {
    next = (previous * 1664525 + 1013904223) % Math.pow(2, 32).toInt
    next
  }

  def nextDouble(): Double = {
    val d = (previous * 1664525 + 1013904223).toDouble % Math.pow(2, 32)
    next = d.toInt
    d
  }

  def setSeed(newSeed: Int) {
    seed = newSeed
  }
}