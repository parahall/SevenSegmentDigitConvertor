import java.util.ArrayList;

/*
 * Interface for Invoice Reader
 */
public interface Reader {

	public boolean hasNext();
	public ArrayList<String> readNext();
	public void close();
}
