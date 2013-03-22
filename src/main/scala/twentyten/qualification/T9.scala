package twentyten.qualification

import scala.io.Source._
import java.io.FileWriter

object T9 extends App {

  val keyboard = Map(
    "a" -> 2,
    "b" -> 22,
    "c" -> 222,
    "d" -> 3,
    "e" -> 33,
    "f" -> 333,
    "g" -> 4,
    "h" -> 44,
    "i" -> 444,
    "j" -> 5,
    "k" -> 55,
    "l" -> 555,
    "m" -> 6,
    "n" -> 66,
    "o" -> 666,
    "p" -> 7,
    "q" -> 77,
    "r" -> 777,
    "s" -> 7777,
    "t" -> 8,
    "u" -> 88,
    "v" -> 888,
    "w" -> 9,
    "x" -> 99,
    "y" -> 999,
    "z" -> 9999,
    " " -> 0)

  val input = fromFile("T9.in")
  val lines = input.getLines
  val output = new FileWriter("T9.out")

  val noOfCases = lines.next.toInt

  for (i <- 1 to noOfCases) {
    val words = lines.next.toList

    output.write ("Case #" + i + ": " + decode(0, "") + "\n")

    def decode(j: Int, result: String): String = {
      if (j < words.size) {
        val number = getNumber(words(j))
        if (result != "" && result.last == number.last) decode (j+1, result + " " + number)
        else decode(j+1, result +  number)
      } else result
    }
  }
  
  input.close
  output.close

  def getNumber(c: Char): String = keyboard.get(c.toString).get.toString
}