package twentyten.qualification

import scala.io.Source._
import org.specs2.io.FromSource
import java.io.FileWriter

object ReverseWords extends App {

  val input = fromFile("reversewords.in")
  val lines = input.getLines

  val output = new FileWriter("reversewords.out")

  val noOfCases = lines.next.toInt

  for (i <- 1 to noOfCases) {
    output.write("Case #" + i + ": " + lines.next.split(" ").toList.reverse.mkString(" ") + "\n")
  }
  input.close
  output.close
}