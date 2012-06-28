package two012.qualification

import org.specs2.mutable._
import java.io._
import scala.io.Source._
import sys.process._
import java.io.BufferedWriter

class SpeakingInTonguesSpec extends Specification {
  "translate 1" in {
    val translator = new SpeakingInTongues
    val translation = translator.translate("ejp mysljylc kd kxveddknmc re jsicpdrysi")
    translation must equalTo("our language is impossible to understand")
  }
  "translate 2" in {
    val translator = new SpeakingInTongues
    val translation = translator.translate ("rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd")
    translation must equalTo("there are twenty six factorial possibilities")
  }
  "translate 3" in {
    val translator = new SpeakingInTongues
    val translation = translator.translate ("de kr kd eoya kw aej tysr re ujdr lkgc jv")
    translation must equalTo("so it is okay if you want to just give up")
  }
  "full test" in {
    val translator = new SpeakingInTongues
    val lines = fromFile(new File("A-small-practice.in")).getLines
    val casesNumber = lines.next.toInt
    val oFile = new PrintWriter("A-small-practice.out")
    (1 to casesNumber).foreach { i =>
      oFile.println("Case " + i + ": " +  translator.translate(lines.next))
    }
    oFile.close
  }
}

