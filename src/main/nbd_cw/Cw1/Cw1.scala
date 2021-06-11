package Cw1

import scala.annotation.tailrec

object Cw1 {
  def main(args: Array[String]): Unit = {

    //1
    var dni_tygodnia = List("Poniedziałek", "Wtorek", "Sroda", "Czwartek", "Piątek", "Sobota", "Niedziala")
    println("1a")
    for (dzien <- dni_tygodnia) println(dzien)
    println("1b")
    for (dzien <- dni_tygodnia if dzien.startsWith("P")) println(dzien)
    println("1c")
    var n = 0
    val d = dni_tygodnia.length

    while (n < d) {
      println(dni_tygodnia(n))
      n += 1
    }

    //2
    println("2a")

    @tailrec
    def printList(list: List[String], result: String = ""): Unit = {
      if (list.nonEmpty) {
        printList(list.tail, result.concat(list.head + ","))
      }
      else {
        println(result.init)
      }
    }

    printList(dni_tygodnia)

    println("2b")

    def printListReverse(list: List[String], result: String = ""): Unit = {
      if (list.nonEmpty) {
        printList(list.init, result.concat(list.last + ","))
      }
      else {
        println(result.init)
      }
    }

    printListReverse(dni_tygodnia)

    //3
    println(3)

    @tailrec
    def printTailRec(list: List[String], result: String = ""): String = {
      if (list.isEmpty) return result
      printTailRec(list.tail, result.concat(list.head + ","))
    }

    println(printTailRec(dni_tygodnia))

    //4
    println("4a")
    val res1 = dni_tygodnia.fold("") {
      (list, elem) => list + elem + ","
    }
    println(res1)

    println("4b")
    val res2 = dni_tygodnia.foldRight("") {
      (elem, list) => list + elem + ","
    }
    println(res2)
    println("4c")
    val res3 = dni_tygodnia.foldLeft("") {
      (list, elem) => if (elem.startsWith("P")) list + elem + "," else list
    }
    println(res3)

    //5
    println(5)

    var CenaMap = Map(
      "a" -> 2.0,
      "b" -> 3.0,
      "c" -> 4.0,
    )
    println(CenaMap.map({ case (a, b) => a -> b * 0.9 }))

    //6
    println(6)

    def printTuple(t: (String, Int, Double)): Unit = {
      println(s"${t._1} ${t._2} ${t._3}")
    }

    printTuple(("a", 1, 1.0))

    //7
    println(7)

    val cena: Option[Double] = CenaMap.get("b")
    if (cena.isDefined) println("defined")

    //8
    println(8)

    var numList = List(1, 2, 0, 0, 3, 0, 5)

    def removeNullRec(list: List[Int]): List[Int] = list match {
      case Nil => Nil
      case head :: tail =>
        if (head == 0)
          removeNullRec(tail)
        else
          head :: removeNullRec(tail)
    }

    println(removeNullRec(numList))

    //9
    println(9)

    def increaseNumbers(list: List[Int]) : List[Int] = {
      list.map(a => a+1)
    }
    println(increaseNumbers(numList))

    //10
    println(10)

    def CustomFilter(list: List[Int]) : List[Int] = {
      list.filter( a => a > -5 && a < 12 ).map( a => math.abs(a))
    }

    println(CustomFilter(List(-6,-5,-3,4,5,11,13)))

  }
}

