package ch10
import java.awt.Point

object Ch10 extends App {
  
}

/* Ex 1
 */
trait RectangleLike {

  var x: Double
  var y: Double
  var width: Double
  var height: Double
  
  def translate(dx: Double, dy: Double) {
    x += dx
    y += dy
  }

  def grow(dw: Double, dh: Double) {
    width += dw
    height += dh
  }
}

/* Ex 2
 */
class OrderedPoint extends java.awt.Point with scala.math.Ordered[java.awt.Point] {
  def compare(that: Point): Int = {
    if(that.getX() > getX())
      1
    else if(that.getX() < getX())
      -1
    else
      0
  }
}

/* Ex 4
 */
trait Logger {
  def log(msg: String)
}

trait CryptoLogger extends Logger {
  val key = 3
  abstract override def log(msg: String) {
    super.log(for(c <- msg) yield (if(c + key > 'z') 'a' + (c + key - 'z' - 1) else (c + key) ).toChar )
  } 
}
