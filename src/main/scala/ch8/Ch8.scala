package ch8

object Ch8 extends App {
  val c = new CheckingAccount(100)
  println(c.deposit(10))
  println(c.withdraw(10))
  println(c.currentBalance)
}

/* Ex 1
 */
class BankAccount(initialBalance: Double) {

  private var balance = initialBalance

  def currentBalance = balance

  def deposit(amount: Double) = { balance += amount; balance }

  def withdraw(amount: Double) = { balance -= amount; balance }
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  override def deposit(amount: Double) = {
    super.withdraw(1)
    super.deposit(amount)
  }

  override def withdraw(amount: Double) = {
    super.withdraw(1)
    super.withdraw(amount)
  }
}

/* Ex 2
 */
class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  private var freeTransactions = 3

  def earnMonthlyInterest() = {
    freeTransactions = 3
    super.deposit(currentBalance * 0.025)
  }
  override def deposit(amount: Double) = {
    if(freeTransactions > 0) {
      freeTransactions -= 1
      super.deposit(amount)
    } else {
      super.withdraw(1)
      super.withdraw(amount)
    }
  }

  override def withdraw(amount: Double) = {
    if(freeTransactions > 0) {
      freeTransactions -= 1
      super.withdraw(amount)
    } else {
      super.withdraw(1)
      super.withdraw(amount)
    }
  }
}

/* Ex 3
 */
abstract class Vehicle {
  val wheels: Int
}

class Car(val wheels: Int) extends Vehicle

class RaceCar(wheels: Int, val horsepower: Int) extends Car(wheels)

/* Ex 4
 */
abstract class Item {
  def price: Double
  def description: String
}

class SimpleItem(val price: Double, val description: String) extends Item

class Bundle(val description: String) extends Item {

  import scala.collection.mutable.ArrayBuffer

  private var items = ArrayBuffer[Item]()

  def price = items.map(_.price).sum

  def addItem(item: Item) {
    items += item
  }
}

/* Ex 5
 */
class Point(val x: Double, val y: Double)

class LabeledPoint(label: String, x: Double, y: Double) extends Point(x, y)

/* Ex 6
 */
abstract class Shape {
  def centerPoint: Point
}

class Rectangle(val length: Double, val width: Double) extends Shape {
  def centerPoint = new Point(length / 2, width / 2)
}

class Circle(val radius: Double) extends Shape {
  def centerPoint = new Point(radius, radius)
}