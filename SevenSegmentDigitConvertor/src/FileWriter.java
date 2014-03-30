import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Class represent Writer to file. Implements interface Writer.
 */
public class FileWriter implements Writer {

	private PrintWriter writer;

	public FileWriter(File file) {
		try {

			// Check if file exists and also if not create all folders in path.
			if (!file.exists())
				file.getParentFile().mkdirs();
			writer = new PrintWriter(file);
		} catch (IOException e) {
			System.out.println("Unable to open file " + file.getAbsolutePath());
			e.printStackTrace();
		}
	}

	@Override
	public void writeNumber(String number) {
		writer.print(number);

	}

	public void close() {
		if (writer != null) {
			writer.close();
		}
	}

}
