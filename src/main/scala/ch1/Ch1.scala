package ch1

object Ch1 {

  /* Ex 1
   *
   * Try it out
   */

  /* Ex 2
   *
   * import scala.math._
   * sqrt(3)
   * res0 * res0
   * res1: Double = 2.9999999999999996
   */

  /* Ex 3
   *
   * val
   */

  /* Ex 4
   *
   * "crazy" * 3
   * String = crazycrazycrazy
   *
   * https://www.scala-lang.org/api/current/scala/collection/StringOps.html
   */

  /* Ex 5
   *
   * Gets the larger of the numbers
   * 
   * defined in each number class
   */

  /* Ex 6
   *
   * import scala.math._
   * BigInt(2).pow(1024)
   * scala.math.BigInt = 179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216
   */

   /* Ex 7
    *
    * scala.math.BigInt._
    * scala.util.Random
    */

    /* Ex 8
     */
    def getRandomFileName(): String = {
      import scala.math.BigInt._
      import scala.util.Random

      probablePrime(100, Random).toString(36)
    }

    /* Ex 9
     */
    def stringChars() {
      val s = "this is my string"
      val firstChar = s.head
      val lastChar = s.last
    }

    /* Ex 10
     */
    def stringFns() {
      val s = "this is my string"
      val take = s.take(3) // thi
      val drop = s.drop(3) // s is my string
      val takeRight = s.takeRight(3) // ing
      val dropRight = s.dropRight(3) // this is my str
    }
}
