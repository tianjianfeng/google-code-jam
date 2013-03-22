package twentytwelve

import java.io.FileWriter
import java.util.HashMap

import scala.io.Source.fromFile

object SpeakingInTongues extends App {

  val input = fromFile("speaking.in")
  val lines = input.getLines

  val output = new FileWriter("speaking.out")

  val noOfCases = lines.next.toInt

  val entries = ("ejp mysljylc kd kxveddknmc re jsicpdrysi" + "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd" + "de kr kd eoya kw aej tysr re ujdr lkgc jv" ).toList
  val results = ("our language is impossible to understand" + "there are twenty six factorial possibilities" + "so it is okay if you want to just give up" ).toList

  val dictionary = new HashMap[Char, Char]

  for (i <- 0 to entries.size - 1) {
    dictionary.put(entries(i), results(i))
  }

  // q z are missing after print out a-z
  for (i <- 'a' to 'z') {
    println(i + " => " + dictionary.get(i))
  }
  dictionary.put('z', 'q')
  dictionary.put('q', 'z')

  for (i <- 1 to noOfCases) {
    val r = for (letter <- lines.next) yield {
      dictionary.get(letter)
    }
    output.write("Case #" + i + ": " + r + "\n")
  }
  input.close
  output.close

}