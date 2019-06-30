package ch9
import scala.collection.mutable

object Ch9 {

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

  /* Ex 6
   */
  def quotedStrings() {
    val lines = io.Source.fromFile("src/main/scala/ch4/Ch4.scala").getLines()

    for(line <- lines) {
      val ms = "\".*\"".r.findAllMatchIn(line)
      for (m <- ms) println(m)
    }
  }

  /* Ex 7
   */
  def nonFloatingPoints() {
    val fileName = "src/main/resources/ch9/ex7.txt"
    val tokens = scala.io.Source.fromFile(fileName).mkString.split("\\s+")
    for(t <- tokens if !t.matches("""[0-9].+\.[0-9].+""")) println(t)
  }

  /* Ex 8
   */
  def imgSrc() {
    val url = "https://www.spacejam.com/archive/spacejam/movie/jam.htm"

    val srcRegex = """src="(.*?)"""".r

    for(l <- io.Source.fromURL(url).getLines()) {
      for(m <- srcRegex.findAllMatchIn(l)) println(m.group(1))
    }
  }

  /* Ex 9
   */
  def classCounter() {
    val dir = "target"
    val entries = java.nio.file.Files.walk(java.nio.file.Paths.get(dir))
    try {
      println(entries.filter( _.toString.endsWith(".class")).count() + " .class files")
    } finally {
      entries.close()
    }
  }

  class Person(val name: String) extends Serializable {
    private val _friends = new mutable.ArrayBuffer[Person]()

    def friends = _friends

    def addFriend(friend: Person) {
      _friends += friend
    }

    override def toString(): String = s"name: $name, friends: " + friends.toString()
  }

  /* Ex 10
   */
  def saveAndGetPeople() {
    import java.io._

    val fileName = "src/main/resources/ch9/people.txt"

    val joe = new Person("joe")
    val bob = new Person("bob")
    joe.addFriend(bob)
    val frank = new Person("frank")
    joe.addFriend(frank)

    val out = new ObjectOutputStream(new FileOutputStream(fileName))
    out.writeObject(joe)
    out.close()

    val in = new ObjectInputStream(new FileInputStream(fileName))
    val savedJoe = in.readObject().asInstanceOf[Person]

    val f = new File(fileName)
    f.delete()

    println(savedJoe)
  }
}

