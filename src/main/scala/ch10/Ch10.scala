package ch10
import java.awt.Point
import java.beans.PropertyChangeListener
import scala.collection.mutable
import java.beans.PropertyChangeEvent
import java.io.InputStream

object Ch10 extends App {
  new LoggingExample()
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
  abstract override def log(msg: String) {
    super.log("an encrypted message!")
  }
}

trait ConsoleLogger extends Logger {
  def log(msg: String) = println(msg)
}

trait BananaLogger extends Logger {
  abstract override def log(msg: String) = super.log("banana " + msg)
}

class LoggingExample extends ConsoleLogger with CryptoLogger with BananaLogger {
  log("the message")
}

/* Ex 5
 */
trait PropertyChangeSupport {
  private val listeners = new mutable.ArrayBuffer[PropertyChangeListener]

  def addPropertyChangeListener(listener: PropertyChangeListener) = listeners += listener

  def removePropertyChangeListener(listener: PropertyChangeListener) = listeners -= listener

  def getPropertyChangeListerners() = listeners

  def firePropertyChange(propertyName: String, oldValue: Any, newValue: Any) {
    val e = new PropertyChangeEvent(this, propertyName, oldValue, newValue)
    listeners.foreach(l => l.propertyChange(e))
  }
}

class NotifyingPoint extends java.awt.Point with PropertyChangeSupport {
  override def setLocation(p: Point): Unit = {
    firePropertyChange("x", getX(), p.getX())
    firePropertyChange("y", getY(), p.getY())
    super.setLocation(p)
  }
}

/* Ex 6
 *
 * If JComponent doesn't extend container there would be no container capabilities
 * in any JComponents, ie. JContainer wouldn't be possible
 * 
 * Make Component and Container traits
 * JComponent extends Component 
 * JContainer extends Container with Component
 */

/* Ex 7
 *
 * New field will not be available until SavingsAccount is recompiled
 */

 /* Ex 8
  *
  * See CryptoLogger abovve
  */

/* Ex 9
 */
trait BufferedStream extends InputStream {
  override def read(): Int = ???
}

object Ex9 {
  val in = new java.io.FileInputStream("src/resources/...") with BufferedStream
}

/* Ex 11
 */
class IterableInputStream extends java.io.InputStream with Iterable[Byte] {
  override def read(): Int = ???

  override def iterator: Iterator[Byte] = ???
}
