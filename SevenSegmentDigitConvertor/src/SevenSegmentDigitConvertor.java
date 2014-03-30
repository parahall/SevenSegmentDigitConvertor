import java.io.File;
import java.util.ArrayList;

public class SevenSegmentDigitConvertor {

	/**
	 * Main method of converter where args0 and args1 taken as input and outpit.
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 2) {

			String inputFile = args[0];
			String outputFile = args[1];

			FileReader fr = new FileReader(new File(inputFile));
			FileWriter fw = new FileWriter(new File(outputFile));

			// Create dictionary that later will be used to parse Digital Number
			// to Analog number
			DigitDictionary dictionary = new DigitDictionary();

			// while there is number - parse it
			// and output file
			while (fr.hasNext()) {


				ArrayList<String> rawDataNumber = fr.readNext();

				// Create Digital Splitter that will separate each digit from
				// whole number
				SingleDigitalSplitter splitter = new SingleDigitalSplitter(
						rawDataNumber);

				// Create new InvoiceNumber and passed splitter and dictionary
				// to use in order to parse whole number.
				InvoiceNumber invoiceNumber = new InvoiceNumber(splitter,
						dictionary);
				// Write invoice number in analog format to the file
				fw.writeNumber(invoiceNumber.toString());

			}

			// Close input and output streams
			fr.close();
			fw.close();
		} else {
			System.out
					.println("Usage: Wrong Number of Arguments. Please specify input file and output file");
		}
	}

}
