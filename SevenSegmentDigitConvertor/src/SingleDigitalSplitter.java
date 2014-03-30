import java.util.ArrayList;
import java.util.InputMismatchException;

/*
 * Class represent splitter. Main splitter job is separate digit by digit from whole invoice number.Implements Splitter interface.
 */
public class SingleDigitalSplitter implements Splitter {

	private ArrayList<String> rawInvoiceNumber;

	private int NUMBER_OF_LINES = 3;
	private int NUMBER_OF_COLUMNS = 3;
	private int mLastStartPosition = 0;
	private int mLastEndPosition = NUMBER_OF_COLUMNS;

	public SingleDigitalSplitter(ArrayList<String> rawInvoiceNumber) {
		// check if all rows have same number of characters otherwise throw
		// exception
		if (rawInvoiceNumber.get(0).length() != rawInvoiceNumber.get(1).length()
				&& rawInvoiceNumber.get(0).length() != rawInvoiceNumber.get(2).length())
			throw new InputMismatchException("Wrong number of characters in invoice number. Number of characters in each row should be equal");

		this.rawInvoiceNumber = rawInvoiceNumber;
	}

	@Override
	public boolean hasNext() {

		// consider extract this condition to variable with meanful name like
		// readPointerIndesLessThanRowLength (or find better one :) )
		boolean isPointerReachEndOfRow = mLastStartPosition < rowLength();
		return isPointerReachEndOfRow;
	}

	private int rowLength() {
		return rawInvoiceNumber.get(0).length();
	}

	@Override
	public ArrayList<String> readNext() {

		ArrayList<String> rawSingleNumber = new ArrayList<String>();
		getSingleColumn(rawSingleNumber);
		mLastStartPosition = mLastEndPosition;
		mLastEndPosition += NUMBER_OF_COLUMNS;
		return rawSingleNumber;

	}

	private void getSingleColumn(ArrayList<String> rawSingleNumber) {
		for (int i = 0; i < NUMBER_OF_LINES; i++) {

			String partOfDigitsAtSingleRow = rawInvoiceNumber.get(i).substring(mLastStartPosition, mLastEndPosition);
			rawSingleNumber.add(partOfDigitsAtSingleRow);
		}
	}

}
