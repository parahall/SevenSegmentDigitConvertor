import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Class represent numbers reader from File. Implements interface Reader.
 */
public class FileReader implements Reader {

	private Scanner scanner;
	private int NUMBER_LINES_TO_READ = 4;

	public FileReader(File file) {
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not exist. Please specify file with invoice numbers in digital format");

		}
	}

	@Override
	public boolean hasNext() {
		return scanner.hasNext();
	}

	@Override
	// Read 4 lines and store them in ArrayList
	public ArrayList<String> readNext() {

		ArrayList<String> rawDataNumber = new ArrayList<String>();

		for (int i = 0; i < NUMBER_LINES_TO_READ; i++) {
			//if there is no more rows at the middle of the number - throw exception
			if (!hasNext() && i<NUMBER_LINES_TO_READ-1)
				throw new InputMismatchException("Invalid invoice number representation. Each number should be represented by 4 rows");
			rawDataNumber.add(scanner.nextLine());
		}

		return rawDataNumber;
	}

	public void close() {

		if (scanner != null) {
			scanner.close();
		}
	}

}
