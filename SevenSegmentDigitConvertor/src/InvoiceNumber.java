import java.util.ArrayList;

/*
 * Class represent for invoice number. Use splitter to separate each digit by digit.
 */
public class InvoiceNumber {

	ArrayList<Digit> invoiceNumberParsed;

	private String EOL = System.getProperty("line.separator");

	private String ILLEGALOREOF = " ILLEGAL" + EOL;

	public InvoiceNumber(SingleDigitalSplitter splitter, DigitDictionary dictionary) {
		invoiceNumberParsed = new ArrayList<Digit>();
		while (splitter.hasNext()) {
			ArrayList<String> rawDataDigit = splitter.readNext();
			Digit parsedNumber = new Digit(rawDataDigit, dictionary);
			invoiceNumberParsed.add(parsedNumber);
		}

	}

	// Concatenate each digit to one string and check if the number is valid.
	// If not add ILLEGAL at the end of number
	public String toString() {
		StringBuilder sb = new StringBuilder();
		boolean isNumberValid = true;
		for (Digit number : invoiceNumberParsed) {
			isNumberValid &= number.isLegalNumber();
			sb.append(number.toString());
		}
		if(!isNumberValid)
			sb.append(ILLEGALOREOF);
		else
			sb.append(EOL);

		return sb.toString();
	}

}
