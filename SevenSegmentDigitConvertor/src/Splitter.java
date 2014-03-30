import java.util.ArrayList;

/*
 * Interface represent Splitter for future reuse.
 */
public interface Splitter {
	
	public boolean hasNext();
	public ArrayList<String> readNext();

}
