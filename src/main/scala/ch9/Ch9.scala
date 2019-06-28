package ch9

object Ch9 extends App {

  /* Ex 1
   */
  def reverseFile() {
    val in = "src/main/resources/ch9/ex1in.txt"
    val out = "src/main/resources/ch9/ex1out.txt"

    val f = scala.io.Source.fromFile(in).getLines.toArray

    val writer = new java.io.PrintWriter(out)
    for(l <- f.reverse) writer.println(l)
    writer.close
  }

  /* Ex 2
   */
  def tabsToSpaces() {
    val in = "src/main/resources/ch9/ex2in.txt"
    val out = "src/main/resources/ch9/ex2out.txt"

    val tabMatcher = """\t""".r

    val lines = scala.io.Source.fromFile(in).getLines

    val writer = new java.io.PrintWriter(out)
    for(l <- lines) writer.println(tabMatcher.replaceAllIn(l, " "))
    writer.close()
  }

  /* Ex 3
   */
  def printLongWords() {
    import scala.io.Source._

    val fileName = "src/main/resources/ch9/ex3.txt"

    for(w <- fromFile(fileName).mkString.split("\\s+") if w.length >= 12) println(w)
  }

  /* Ex 4
   */
  def floatingPointNums() {
    import scala.io.Source._

    val fileName = "src/main/resources/ch9/ex4.txt"
  
    val numbers = fromFile(fileName).mkString.split("\\s+").map(_.toDouble)

    println("Sum: " + numbers.sum)
    println("Avg: " + (numbers.sum / numbers.length))
    println("Max: " + numbers.max)
    println("Min: " + numbers.min)
  }

  /* Ex 5
   */
  def powersOfTwo() {
    val writer = new java.io.PrintWriter("src/main/resources/ch9/ex5.txt")
    for(e <- 0 to 20) {
      val ex = Math.pow(2, e).toInt
      val recip = Math.pow(2, -e)
      writer.println(f"$ex%-10d$recip")
    }
    writer.close()
  }

  powersOfTwo()
}

