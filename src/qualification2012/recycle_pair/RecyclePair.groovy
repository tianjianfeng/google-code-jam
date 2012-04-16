package qualification2012.recycle_pair

class RecyclePair {

	int getRecyclePair(String input) {
		String[] startEnd = input.split()
		int start = startEnd[0].toInteger()
		int end = startEnd[1].toInteger()
		int numberOfPair
		
		def range = start..end
		def rangeString = []
		range.collect(rangeString) {
			it.toString()
		}
		int len = rangeString.get(0).size()
		
//		println rangeString
		int swap = 0
		rangeString.each {it ->
		for (int i = 0; i < len-1; i++) {
//				String sub = it.substring(i+1)
//				String supersub = it.substring(0, i+1)
				swap = (it.substring(i+1) + it.substring(0, i+1)).toInteger()
//				println swap
				
			if (swap>= start && swap<= end && it.toInteger() < swap) {	
//			if(range.contains(swap)) {
//				println it + ' ' + swap
				numberOfPair++
//			}
			 
		}
		}
		}
		return numberOfPair 
	}
	
	public  void processFile(File inputFile, File outputFile) {
		def lines = inputFile.readLines()
		int numberOfLines = lines.size()
		for (int i = 1; i < Integer.parseInt(lines.get(0)) + 1; i++) {
			outputFile << "Case #${i}: "
			print "Case #${i}: "
			outputFile.append(getRecyclePair(lines.get(i)))
			print getRecyclePair(lines.get(i))
			print "\n"
			outputFile.append("\n")
		}
	}
	public static void main(String[] args) {
		def begin = System.currentTimeMillis()
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
		RecyclePair recyclePair = new RecyclePair()
		recyclePair.processFile(inputFile, outputFile)
		def end = System.currentTimeMillis()
		println 'total time: ' + (end-begin)
	}
}
