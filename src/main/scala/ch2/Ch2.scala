package ch2
import java.time.LocalDate

object Ch2 {

  /* Ex 1
   */
  def sigNum(n: Int): Int = {
    if( n > 0 )
      1
    else if( n < 0 )
      -1
    else
      0
  }

  /* Ex 2
   *
   * Unit
   */

  /* Ex 3
   *
   * Valid when x has type Unit (val x: Unit)
   */

  /* Ex 4
   */
  def scalaReverseForLoop() {
    for( i <- 10 to 1 by -1) println(i)
  }

  /* Ex 5
   */
  def countdown(x: Int) {
    for( i <- x to 0 by -1) println(i)
  }


  /* Ex 6
   */
  def unicodeSumLoop(s: String): Long = {
    var sum = 1L
    for( c <- s ) sum *= c.toLong
    sum
  }

  /* Ex 7
   */
  def unicodeSumOneLine(s: String): Long = {
    s.map(_.toLong).product
  }

  /* Ex 8
   * 
   * See above
   */

  /* Ex 9
   */
  def unicodeSumRec(s: String): Long = s match {
    case "" => 1
    case _ => s.head.toLong * unicodeSumRec(s.tail)
  }

  /* Ex 10
   */
  def recPower(x: Double, n: Double): Double = { 
    import scala.math.pow
    n match {
      case 0 => 1
      case n if n > 1 && n % 2 == 0 => pow(x, n / 2) * pow(x, n / 2)
      case n if n > 1 && n % 2 == 1 => x * pow(x, n -1)
      case n if n < 0 => 1 / pow(x, -n)
    }
  }

  /* Ex 11
   */
  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      if(!sc.parts.forall(s => s == "-"))
        throw new Exception("Invalid Separator")
      else if(args.length != 3)
        throw new Exception("Need 3 values")

      LocalDate.of(
        args(0).toString.toInt,
        args(1).toString.toInt,
        args(2).toString.toInt
      )
    }
  }
}