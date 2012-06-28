package two012.qualification

class SpeakingInTongues {

  private var dictionary = SpeakingInTongues.populateDictionary
  
  def translate(s: String): String = {
    var translation = new StringBuilder
    s.foreach { c => 
      translation.append(dictionary(c))
    }
    translation.toString
  }

  object SpeakingInTongues {
    private val input = "ejp mysljylc kd kxveddknmc re jsicpdrysi" + "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd" + "de kr kd eoya kw aej tysr re ujdr lkgc jv" + "qz"
    private val output = "our language is impossible to understand" + "there are twenty six factorial possibilities" + "so it is okay if you want to just give up" + "zq"

    def populateDictionary: Map[Char, Char] = {
      var myDictionary = Map[Char, Char]()
      (1 until input.size).foreach { i =>
        myDictionary += (input(i) -> output(i))
      }
      myDictionary
    }

  }
}
