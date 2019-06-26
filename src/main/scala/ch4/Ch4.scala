package ch4

object Ch4 {

  /* Ex 1
   */
  def gizmos() {
    val fullPrice = Map(
      "Keyboard" -> 20.0,
      "Mouse" -> 5.50
    )

    val tenOff = for((name, price) <- fullPrice) yield (name, price * .9)

    println(tenOff)
  }

  /* Ex 2
   */
  def wordsFromFile() {
    val in  = new java.util.Scanner(new java.io.File("src/main/resources/ch4/words.txt"))
    val m = scala.collection.mutable.Map[String, Int]()
    while(in.hasNext()){
      var w = in.next()
      m(w) = m.getOrElse(w, 0) + 1
    }
    for((w, c) <- m) println(w + ": " + c.toString)
  }

  /* Ex 3
   */
  def wordsFromFileImmutable() {
    val in  = new java.util.Scanner(new java.io.File("src/main/resources/ch4/words.txt"))
    var m = (Map[String, Int]()).withDefaultValue(0)
    while (in.hasNext()) {
      var w = in.next()
      m += (w -> (m(w) + 1))
    }
    for((w, c) <- m) println(w + ": " + c.toString)
  }

  /* Ex 4
   */
  def wordsFromFileSorted() {
    val in  = new java.util.Scanner(new java.io.File("src/main/resources/ch4/words.txt"))
    val m = scala.collection.mutable.SortedMap[String, Int]()
    while(in.hasNext()){
      var w = in.next()
      m(w) = m.getOrElse(w, 0) + 1
    }
    for((w, c) <- m) println(w + ": " + c.toString)
  }

  /* Ex 5
   */
  def wordsFromFileJavaMap() {
    import scala.collection.JavaConversions.mapAsScalaMap
    val in  = new java.util.Scanner(new java.io.File("src/main/resources/ch4/words.txt"))
    val m: scala.collection.mutable.Map[String, Int] = 
      new java.util.TreeMap[String, Int]
    while(in.hasNext()){
      var w = in.next()
      m(w) = m.getOrElse(w, 0) + 1
    }
    for((w, c) <- m) println(w + ": " + c.toString)
  }

  /* Ex 6
   */
  def daysOfWeek() {
    val m = scala.collection.mutable.LinkedHashMap[String, Int](
      "Sunday" -> java.util.Calendar.SUNDAY,
      "Monday" -> java.util.Calendar.MONDAY,
      "Tuesday" -> java.util.Calendar.TUESDAY,
      "Wednesday" -> java.util.Calendar.WEDNESDAY,
      "Thursday" -> java.util.Calendar.THURSDAY,
      "Friday" -> java.util.Calendar.FRIDAY,
      "Saturday" -> java.util.Calendar.SATURDAY,
    )
    for((k, v) <- m) println(k + ": " + v.toString)
  }

  /* Ex 7
   */
  def javaProps() {
    import scala.collection.JavaConversions.propertiesAsScalaMap

    val props: scala.collection.Map[String, String] =
      System.getProperties()

    val maxL = props.keySet.map(_.length).max

    for((k, v) <- props) println(printf("%-" + maxL + "s | %s", k, v))
  }
 
  /* Ex 8
   */
  def minmax(values: Array[Int]): (Int, Int) = {
    values.min -> values.max
  }

  /* Ex 9
   */
  def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) = {
    (
      values.filter(_ < v).length,
      values.filter(_ == v).length,
      values.filter(_ > v).length
    )
  }

  /* Ex 10
   *
   * Vector((H,W), (e,o), (l,r), (l,l), (o,d))
   */
}