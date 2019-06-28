package ch6

/* Ex 1
 */
object Conversions {

  def inchesToCentimeters(inches: Double): Double = {
    inches * 2.54
  }

  def gallonsToLiters(gallons: Double): Double = {
    gallons * 3.785
  }

  def milesToKilometers(miles: Double): Double = {
    miles * 1.609
  }
}

/* Ex 2
 */
abstract class UnitConversions {
  def convert(value: Double): Double
}

class InchesToCentimeters extends UnitConversions {
  def convert(value: Double): Double = {
    value * 2.54
  }
}

class GallonsToLiters extends UnitConversions {
  def convert(value: Double): Double = {
    value * 3.785
  }
}

class MilesToKilometers extends UnitConversions {
  def convert(value: Double): Double = {
    value * 1.609
  }
}

/* Ex 3
 *
 * Point has lots of mutator methods. As an object Origin is a singleton
 * and should not be able to change from 0,0
 */

/* Ex 4
 */
class Point private(var x: Int, var y: Int) {

}

object Point {
  def apply(x: Int, y: Int): Point = {
    new Point(x, y)
  }
}

/* Ex 5
 */
// object Application extends App {
//   println(args.reverse.mkString(" "))
// }

/* Ex 6
 */
object Suit extends Enumeration {
  type Suit = Value
  val Hearts = Value("♥")
  val Clubs = Value("♣")
  val Spades = Value("♠")
  val Diamonds = Value("♦")
}

/* Ex 7
 */
object SuitChecker {
  def isRedSuit(suit: Suit.Suit): Boolean = suit match {
    case Suit.Hearts => true
    case Suit.Diamonds => true
    case _ => false
  }
}

/* Ex 8
 */
object RGBCorner extends Enumeration {
  type RGBCorner = Value
  val Red = Value(0xff0000)
  // ... for other corners
}