/*
 * Interface represent Writer for future reuse. (maybe to DB? :)
 */
public interface Writer {

	void writeNumber(String number);
	public void close();
}
