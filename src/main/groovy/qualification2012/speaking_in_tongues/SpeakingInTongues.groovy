package qualification2012.speaking_in_tongues

import java.util.Map;

class SpeakingInTongues {

	Map getDict() {
		String sampleInput = 'ejpmysljylckdkxveddknmcrejsicpdrysirbcpcypcrtcsradkhwyfrepkymveddknkmkrkcddekrkdeoyakwaejtysrreujdrlkgcjv'
		sampleInput += ' qz'
		
		String sampleOutput = 'ourlanguageisimpossibletounderstandtherearetwentysixfactorialpossibilitiessoitisokayifyouwanttojustgiveup'
		sampleOutput += ' zq'
		
		char[] inputArray = sampleInput.toCharArray()
		char[] outputArray = sampleOutput.toCharArray()

		Map dict = [:]
		
		for(int i = 0; i < inputArray.size(); i++) {
			dict.put(inputArray[i], outputArray[i])
		}
		return dict
		
	}
	
	String translate(File inputFile, File outputFile) {
		
		println dict
		int lineNumber = 1
		def lines = inputFile.readLines()
		
		for (int i = 1; i < lines.get(0).toInteger()+1; i++) {
			outputFile << "Case #${i}: "
			print "Case #${i}: "
			lines.get(i).toCharArray().each {it ->
				def replace = dict.get(it)
				print replace
				outputFile.append(replace)
			}
			print "\n"
			outputFile.append("\n")
		}
		 
	}
	public static void main(String[] args) {
		if (args.length == 0) {
			println 'please provide the input file name'
			System.exit(1);
		}
		String inputFileName = args[0]
		def inputFile = new File(inputFileName)
		if (!inputFile.exists()) {
			println "input file does not exist"
			System.exit(1)
		}
		
		String outputFileName = inputFileName - '.in' + '.out'
		def outputFile = new File(outputFileName)
		if (outputFile.exists()) {
			outputFile.delete()
		}
				
		outputFile.createNewFile()
		SpeakingInTongues speakingInTongues = new SpeakingInTongues()
		speakingInTongues.translate(inputFile, outputFile)
	}
}
