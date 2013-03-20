package src.main.scala.twentyten.qualification

import scala.io.Source._
import java.io.FileWriter

object StoreCredit extends App {

  val input = fromFile("A-large-practice.in")
  val lines = input.getLines

  val output = new FileWriter("storecredit.out")

  val noOfCases = lines.next.toInt

  for (i <- 1 to noOfCases) {
    val credit = lines.next.toInt
    val itemNo = lines.next.toInt
    val itemPrices = lines.next.split(" ").map(_.toInt).toList
    output.append("Case #" + i + ": " + processCase(0) + "\n")

    def processCase(j: Int): String = {
      val indexOfFoundItem = itemPrices.indexWhere((_ == (credit - itemPrices(j))), j + 1)
      if (itemPrices.contains(credit - itemPrices(j)) && (indexOfFoundItem != -1))
        (j + 1).toString + " " + (indexOfFoundItem + 1).toString
      else processCase(j + 1)
    }
  }
  input.close
  output.close
}