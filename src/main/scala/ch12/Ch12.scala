package ch12

object Ch12 {
 
  /* Ex 1
   */
  def values(fun: (Int) => Int, low: Int, high: Int) = {
    for(i <- low to high) yield low -> fun(high)
  }

  /* Ex 2
   */
  def reduceLeftLargest(elems: Array[Int]) = elems.reduceLeft(_ max _)

  /* Ex 3
   */
  def coolFac(n: Int) = if(n < 1) 0 else 1 to n reduceLeft(_ * _)

  /* Ex 4
   */
  def foldLeftFac(n: Int) = (1 to n).foldLeft(1)(_ * _)

  /* Ex 5
   */
  def largest(fun: (Int) => Int, inputs: Seq[Int]) = inputs.map(fun).max

  /* Ex 6
   */
  def largestAt(fun: (Int) => Int, inputs: Seq[Int]) =
    inputs.reduce((x, y) => if(fun(x) >= fun(y)) x else y )

  /* Ex 7
   */
  def adjustToPair(f: (Int, Int) => Int) = (t :(Int, Int)) => f(t._1, t._2)

  /* Ex 8
   */
  def strLenArrs(strs: Array[String], lens: Array[Int]): Boolean = {
    strs.corresponds(lens)(_.length == _)
  }
  
  /* Ex 9
   */
  def uncurriedCorresponds[T, V](a: Array[T], b: Array[V], f: (T, V) => Boolean): Boolean = {
    a.zip(b).foldLeft(true)((carry, t) => if(carry) f(t._1, t._2) else carry)
  }

  /* Ex 10
   */
  def unless(condition: => Boolean)(block: Unit) {
    if(condition) block
  }
}