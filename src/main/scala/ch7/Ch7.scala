package ch5

object Ch7 extends App {
  Ex9.ex9()
}

/* Ex 1
 *
 * See ex1a.scala and ex1b.scala
 */
package com {
  package eric {
    
    object ThingProvider {
      val thing = "thing"
    }

  }
}

/* Ex 4
 *
 * https://stackoverflow.com/a/43030212
 */

/* Ex 5
 *
 * giveRaise is package private to com. A package besides com would be better
 * but it is useful to limit the use of giveRaise
 */

/* Ex 6, 7
 */
package transfers {
  object MapChanger {
    
    import java.util.{HashMap => JavaHashMap}
    import scala.collection.mutable.{Map => ScalaMap}

    def transferMap[T, V](source: ScalaMap[T, V]): JavaHashMap[T, V] = {
      var javaMap = new JavaHashMap[T, V]()
      for((k, v) <- source) {
        javaMap.put(k, v)
      }
      javaMap
    }
  }
}

/* Ex 9
 */
object Ex9 {

  import java.lang.System

  def ex9() {
    val username = System.getProperty("user.name")
    var pw = ""
    
    var next = System.in.read().toChar
    while( next != '\n')  {
      pw += next
      next = System.in.read().toChar
    }
    if( pw == "secret" )
      System.out.println("Correct pw")
    else
      System.err.println("wrong")
  }
}