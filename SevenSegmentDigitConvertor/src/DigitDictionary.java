import java.util.Hashtable;

/*
 * Class represent Dictionary used to convert from Binary summary of chars appears in 7 segment number to number
 */
public class DigitDictionary {

	private Hashtable<Integer, String> lookupTable;

	public DigitDictionary() {

		lookupTable = new Hashtable<Integer, String>();
		lookupTable.put(63, "0"); 
		lookupTable.put(6, "1");
		lookupTable.put(91, "2");
		lookupTable.put(79, "3");
		lookupTable.put(102, "4");
		lookupTable.put(109, "5");
		lookupTable.put(125, "6");
		lookupTable.put(7, "7");
		lookupTable.put(127, "8");
		lookupTable.put(111, "9");

	}

	public String getValue(Integer key) {

		return lookupTable.get(key);

	}

}
