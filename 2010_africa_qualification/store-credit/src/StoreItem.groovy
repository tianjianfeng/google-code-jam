
 public class StoreItem {
	   def static getTwoItemsForCredit(Integer credit, List itemPrice) {
			for (int i = 0; i < itemPrice.size()+1; i++) {
				for (int j = i+1; j < itemPrice.size() ; j++) {
					if (credit == itemPrice[i].toInteger() + itemPrice[j].toInteger()) {
						println(itemPrice[i] + " + " + itemPrice[j]);
						println "${i+1}, ${j+1}"
						return [i+1, j+1]
					}
				}
			}
	 }
	 
	public static void processFile(String inputFileName) {
		def inputFile = new File(inputFileName)
		if (!inputFile.exists()) {
			println "input file does not exist"
			System.exit(1)
		}
		def lines = inputFile.readLines()
		int numberOfLines = lines.size()
		
		String outputFileName = inputFileName - '.in' + '.out'
		
		def outputFile = new File(outputFileName)
		if (outputFile.exists()) {
			outputFile.delete()
		}
		
		outputFile.createNewFile()
		
		int credit
		int itemNumber
		
		int lineNumber = 1;
		
		for (int c = 1; c < Integer.parseInt(lines.get(0)) + 1; lineNumber++) {
		outputFile << "Case #${c}: "
		credit = lines.get(lineNumber).toInteger()
		itemNumber = lines.get(++lineNumber).toInteger()
		String[] itemPriceString = lines.get(++lineNumber).split()
		List itemPrice = []
		itemPriceString.collect(itemPrice) {
		    it.toInteger()
		}
		def chosenItems = getTwoItemsForCredit(credit, (List)itemPrice)
		outputFile.append ("${chosenItems.get(0)} ${chosenItems.get(1)}")
		outputFile.append("\n")
		c++
		}
	}
	
	public static void main(String[] args) {
		if (args.length == 0) {
			println 'please provide the input file name'
			System.exit(1);
		}
		
		processFile(args[0])
	}

}
