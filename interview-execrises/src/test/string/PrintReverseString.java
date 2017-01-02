package test.string;

public class PrintReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "hello world";
		printReverse(s);
	}
	
	public static void printReverse(String s){
		for (int i = s.length()-1; i >= 0; i--)
			System.out.print(s.charAt(i));
	}

}
