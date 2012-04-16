package qualification2012.googler_dance

import java.util.Arrays;

class GoogleDance {

	int getMax(File inputFile, File outputFile) {
		def lines = inputFile.readLines()
		int numberOfTestCases = Integer.parseInt(lines.get(0))
		println numberOfTestCases
		for (int j = 1; j < numberOfTestCases+1; j++) {
//		(1..numberOfTestCases).each { j ->
			
			outputFile << "Case #${j}: "
			print "Case #${j}: "
			def inputInt = lines.get(j).split().collect { it as int } as int[]
			int numberOfTests = inputInt[0]
			int supprise = inputInt[1]
			int bestResult = inputInt[2]
					
			int[] scores = Arrays.copyOfRange(inputInt, 3, 3+numberOfTests)
			println scores
					
			int maxNumber = 0
			for (int i = 0; i < scores.length; i++ ) {
				int subScore = scores[i] - bestResult
				if (subScore < 0) {
					continue
				}
				int divide = subScore / 2
				int remain = subScore % 2
				if (bestResult - divide <= 2) {
					maxNumber++
					continue
				}
				if (supprise > 0 && subScore > bestResult) {
					maxNumber++
					supprise--
					continue
				}
			}
			println maxNumber
			outputFile.append(maxNumber)
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
		GoogleDance googleDance = new GoogleDance()
		googleDance.getMax(inputFile, outputFile)
	}	
}
