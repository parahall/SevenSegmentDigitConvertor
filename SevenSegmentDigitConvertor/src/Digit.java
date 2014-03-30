import java.util.ArrayList;

/*
 * Class represent single digit. Containing main parse method.
 */
public class Digit {

	private String parsedNumber = "";
	private DigitDictionary dictionary;
	private String NOT_NUMBER = "?";

	public Digit(ArrayList<String> rawDataNumber, DigitDictionary dictionary) {

		this.dictionary = dictionary;

		parsedNumber = parse(rawDataNumber);

	}

	public boolean isLegalNumber() {
		return (parsedNumber != null && parsedNumber != NOT_NUMBER);
	}

	// If there is valid character at the position count 2 in power of order
	// number.
	//
	//    _a_
	// f |_g_|b
	// e |_d_|c
	//
	// where a - 0, b - 1, c - 2, d - 3, e - 4,f - 5 , g - 6
	// and summaries it to use it as a key in a dictionary
	private String parse(ArrayList<String> rawDataNumber) {
		int summaryIndex = 0;
		if (rawDataNumber.get(0).charAt(1) == '_')
			summaryIndex += Math.pow(2, 0);
		if (rawDataNumber.get(1).charAt(2) == '|')
			summaryIndex += Math.pow(2, 1);
		if (rawDataNumber.get(2).charAt(2) == '|')
			summaryIndex += Math.pow(2, 2);
		if (rawDataNumber.get(2).charAt(1) == '_')
			summaryIndex += Math.pow(2, 3);
		if (rawDataNumber.get(2).charAt(0) == '|')
			summaryIndex += Math.pow(2, 4);
		if (rawDataNumber.get(1).charAt(0) == '|')
			summaryIndex += Math.pow(2, 5);
		if (rawDataNumber.get(1).charAt(1) == '_')
			summaryIndex += Math.pow(2, 6);

		String value = dictionary.getValue(summaryIndex);
		if (value == null || value.isEmpty())
			return NOT_NUMBER;
		else
			return value;
	}

	public String toString() {
		return parsedNumber;
	}

}
