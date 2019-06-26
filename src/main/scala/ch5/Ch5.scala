package ch5

/* Ex 1
 */
class Counter {
  private var value = Int.MaxValue
  def increment() {
    if(value < Int.MaxValue)
      value += 1
  }
  def current = value
}

/* Ex 2
 */
class BankAccount {
  private[this] var current_balance = 0

  def deposit(amount: Int) { current_balance += amount }

  def withdraw(amount: Int): Int = {
    val absAmount = Math.abs(amount)
    if( current_balance >= absAmount ) {
      current_balance -= absAmount
      absAmount
    } else {
      val prev_bal = current_balance
      current_balance = 0
      prev_bal
    }
  }

  def balance = current_balance
}

/* Ex 3
 */
class Time(hrs: Int, min: Int) {

  if(hrs < 0 || hrs > 23)
    throw new Exception("No!")
  else if(min < 0 || min > 59)
    throw new Exception("No!")

  def hours = hrs
  def minutes = min

  def before(other: Time): Boolean = {
    (hours * 60 + minutes) < (other.hours * 60 + other.minutes)
  }
}

/* Ex 4
 */
class Time2(hrs: Int, min: Int) {
 
  if(hrs < 0 || hrs > 23)
    throw new Exception("No!")
  else if(min < 0 || min > 59)
    throw new Exception("No!")

  private val time = (hrs * 60) + min

  def hours = time / 60

  def minutes = time % 60

  def before(other: Time2): Boolean = {
    time < (other.hours * 60 + other.minutes)
  }
}

import scala.beans.BeanProperty

/* Ex 5
 */
class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {
  // public java.lang.String name();
  // public void name_$eq(java.lang.String);
  // public long id();
  // public void id_$eq(long);
  // public long getId();
  // public java.lang.String getName();
  // public void setId(long);
  // public void setName(java.lang.String);
  // public ch5.Student(java.lang.String, long);
}

/* Ex 6
 */
class Person() {
  private var privateAge: Int = 0

  def age = privateAge
  def age_=(newAge: Int) {
    privateAge = 
      if(newAge > privateAge)
        newAge
      else if(newAge < 0)
        0 
      else
        privateAge
  }
}

/* Ex 7
 */
class NamedPerson(name: String) {

  val firstName = name.split(" ")(0)
  val lastName = name.split(" ")(1)

}

/* Ex 8
 */
class Car(val manufacturer: String, val modelName: String) {

  private var _licensePlate: String = ""
  private var _year: Int = -1

  def this(manufacturer: String, modelName: String, year: Int) {
    this(manufacturer, modelName)
    _year = year
  }

  def this(manufacturer: String, modelName: String, licensePlate: String) {
    this(manufacturer, modelName)
    _licensePlate = licensePlate
  }

  def this(manufacturer: String, modelName: String, year: Int, licensePlate: String) {
    this(manufacturer, modelName)
    _year = year
    _licensePlate = licensePlate
  }

  def licensePlate = _licensePlate
  def year = _year
}

/* Ex 9
 *
 * A fair bit shorter. See ch5/Car.java
 */

/* Ex 10
 */
class Employee(empName: String = "John Q. Public", empSalary: Double = 0.0) {
  val name = empName
  val salary = empSalary
}