package test.string;

/**
 * Tintri phone interview input "asdflkasdhglakhgrljkeaherv"
 * def splitX(input):
 * 
 * #return "asd flk asd ..."
 */
public class AddSpaceEveryThreeChar {

	public static String addSpace3Char(String str) {
		char[] array = str.toCharArray();
		StringBuilder temp = new StringBuilder();
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (counter == 3) {
				temp.append(" ");
				counter = 0;
			}
			temp.append(array[i]);
			counter++;
		}
		return temp.toString();
	}
	
	public static void main (String [] arg) {
		String str = "asdflkasdhglakhgrljkeaherv";
		System.out.println(addSpace3Char(str));
	}
}
