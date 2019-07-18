package ch13
import scala.collection.mutable
import scala.collection.immutable.SortedMap

object Ch13 extends App {
  
  /* Ex 1
   */
  def charIndexes(input: String): mutable.SortedMap[Char, Set[Int]] = {
    val m = mutable.SortedMap[Char, Set[Int]]()
    for((c, i) <- input.zipWithIndex) m(c) = m.getOrElse(c, Set()) + i
    m
  }

  /* Ex 2
   */
  def immutableCharIndexes(input: String): SortedMap[Char, Set[Int]] = {
    input.zipWithIndex.foldLeft(
      SortedMap[Char, Set[Int]]()
    )(
      (m, t) => m + (t._1 -> (m.getOrElse(t._1, Set[Int]()) + t._2))
    )
  }

  /* Ex 3
   */
  def removeOddListBuffer[T](l: mutable.ListBuffer[T]): mutable.ListBuffer[T] = {
    for(i <- l.length to 0 by -1 if i % 2 == 1) l.remove(i)
    l
  }

  /* Ex 4
   */
  def inMap(vals: Array[String], m: Map[String, Int]): Array[Int] = {
    vals.flatMap(s => m.get(s))
  }

  /* Ex 5
   */
  def foldLeftMkString[T](c: Iterable[T], sep: String = ""): String = {
    c.tail.foldLeft(c.head.toString)((s, v) => s + sep + v.toString())
  }

  def go() {
    val vs = Array[Option[String]](Some("One"), None, Some("Two"))
    println( (0 to 2).flatMap(i => vs(i)) )
  }
}