/**
 * Recursion methods
 * @author Melisa Tanrikulu
 * @version 26.07.2021 * 
 */
import java.util.ArrayList;
import java.io.File;

public class main {

	public static void main(String[] args) {
		// QUESTION 1
		System.out.println(stringLength("CS102 is the best"));
		
		// QUESTION 2
		System.out.println(nonVowelLength("CS102 is a good course"));

		System.out.println();
		
		// QUESTION 3
		for ( String binary : binaryString(3) )
			System.out.println(binary);
		
		System.out.println();
		
		for ( String binary : binaryString(4) )
			System.out.println(binary);
		
		System.out.println();
		
		for ( String binary : binaryString(5) )
			System.out.println(binary);
		
		System.out.println();
		
		// QUESTION 4
		System.out.println(numberOfFiles("C:/users/HP/desktop/Github"));
		System.out.println(numberOfFiles("C:/users/HP/desktop/Email Sender"));

	}

	/*
	 * Question 1
	 */
	public static int stringLength(String str) {
		int length = 0;
		
		// Base Case
		if (str.equals(""))
			return 0;
		else if (str.length() == 1) 
			return 1;
		
		// General Case
		else
			length += 1 + stringLength( str.substring(1) );
		
		return length;
	}
	
	/*
	 * Question 2
	 */
	public static int nonVowelLength(String str) {
		String nonVowels = "bcdfghjklmnpqrstvwxyz";
		int length = 0;
		
		// Base Case
		if (str.length() == 0)
			return 0;
		else if (str.length() == 1) {
			if ( nonVowels.indexOf(str.toLowerCase()) >= 0 )
				return 1;		
		}
		
		// General Case
		else {
			length += nonVowelLength(str.substring(0, 1)) + nonVowelLength(str.substring(1));
		}
		
		return length;
	}
	
	/*
	 * Question 3
	 */
	public static ArrayList<String> binaryString(int length) {
		ArrayList<String> list = new ArrayList<String>();
		
		// Base Case
		if ( length == 0 ) 
			return list;
		else if ( length == 1 ) {
			list.add("0");
			list.add("1");
		}
		
		// General Case
		else if ( length > 1 ) {
			for ( String binary : binaryString(length - 1) ) {
				String str = "0" + binary;
				list.add(str);
			}
			for ( String binary : binaryString(length - 1) ) {
				if ( binary.charAt(0) != '1') {
					String str = "1" + binary;
					list.add(str);
				}
			}
		}
		
		return list;
	}
	
	/*
	 * Question 4
	 */
	public static int numberOfFiles(String directory) {
		File file = new File(directory);
		int numberOfFiles = 0;
		
		if ( file != null ) {
			File[] files = file.listFiles();
			
			// Base Case
			if ( files.length == 0 )
				return 0;
			
			// General Case
			else {
				for ( File obj : files ) {
					if ( obj.isFile() )
						numberOfFiles++;
					else if ( obj.isDirectory() ) {
						numberOfFiles += numberOfFiles(obj.toString());
					}
				}
			}
		}
		
		return numberOfFiles;
	}
}
