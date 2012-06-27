package two012.qualification

import org.specs2.mutable._

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
}

