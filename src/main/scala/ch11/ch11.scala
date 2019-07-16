package ch11
import scala.runtime.RichInt
import scala.collection.mutable

/* Ex 1
 *
 * (3+4)->5
 * (3->4)+5
 */

/* Ex 2
 *
 * ** and ^ operators wouldn't have the appropriate precedence level
 */

/* Ex 3
 */
class Fraction(n: Int, d: Int) {
  require(d != 0)

  val num: Int = n / gcd(n, d)
  val den: Int = d / gcd(n, d)

  def gcd(a: Int, b: Int): Int = if (b == 0) math.abs(a) else gcd(b, a % b)

  override def toString(): String = s"$num/$den"

  def +(other: Fraction) = ???

  def -(other: Fraction) = ???
  
  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)

  def /(other: Fraction) = ???
}

/* Ex 4
 */
object Money {
  def apply(dollars: Int, cents: Int) = new Money(dollars, cents)
}

class Money private (val dollars: Int, val cents: Int) {

  override def toString(): String = f"$$$dollars.$cents%02d"

  def +(other: Money) = Money(
    dollars + other.dollars + (cents + other.cents) / 100,
    (cents + other.cents) % 100
  )

}
