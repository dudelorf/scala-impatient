package ch3
import scala.util.Random
import scala.collection.mutable._

object Ch3 {
  
  /* Ex 1
   */
  def getRandomArr(n: Int): Array[Int] = {
    new Array[Int](n).map(_ => Random.nextInt(n))
  }

  /* Ex 2
   */
  def swapAdjacent(arr: Array[Int]): Array[Int] = {
    val toSwap = for(i <- arr.indices if i % 2 == 1) yield i
    for(i <- toSwap) {
      val tmp = arr(i)
      arr(i) = arr(i - 1)
      arr(i - 1) = tmp
    }
    arr
  }

  /* Ex 3
   */
  def swapAdjacentYield(arr: Array[Int]): Array[Int] = {
    // TODO
    arr
  }

  /* Ex 4
   */
  def positivesFirst(arr: Array[Int]): Array[Int] = {
    val pos = for(el <- arr.toBuffer if el > 0) yield el
    val others = for(el <- arr.toBuffer if el <= 0) yield el
    (pos ++= others).toArray
  }

  /* Ex 5
   */
  def arrAvg(arr: Array[Double]): Double = {
    arr.sum / arr.length
  }

  /* Ex 6a
   */
  def revSortArr(arr: Array[Int]): Array[Int] = {
    arr.sortWith(_ > _)
    // arr.sorted.reverse
  }

  /* Ex 6b
   */
  def revSortArrBuffer(arr: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    arr.sortWith(_ > _)
    // arr.sorted.reverse
  }

  /* EX 7
   */
  def removeDups[T](arr: Array[T]): Array[T] = {
    arr.distinct
  }

  /* Ex 8
   */
  def firstNegativeOnly(arr: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val negatives = for(i <- arr.indices if arr(i) < 0) yield i
    for(i <- negatives.tail.reverse) arr.remove(i)
    arr
  }

  /* Ex 9
   */
  def firstNegativesOnlyImproved(arr: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    // TODO
    arr
  }

  /* Ex 10
   */
  def getAmericanTimezones(): Array[String] = {
    java.util.TimeZone.getAvailableIDs()
      .filter(_.startsWith("America/"))
      .map(_.replace("America/", ""))
  }

  /* Ex 11
   */
  def javaInterop(): Buffer[String] = {
    import java.awt.datatransfer._
    import scala.collection.JavaConversions.asScalaBuffer

    val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]

    flavors.getNativesForFlavor(DataFlavor.imageFlavor)
  }
}