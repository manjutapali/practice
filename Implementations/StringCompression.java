/*
	Compress the string
	if it's aaabbbdd - a3b3d2

	if compressed string has more length than original, return the original string.
*/

import java.util.Scanner;

public class StringCompression {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();

		System.out.println(GetCompressedString(str)); 
	}

	static String GetCompressedString(String str) {

		char c1 = str.charAt(0);
		int count = 1;
		String final_str = "";

		for(int i = 1; i < str.length(); i++) {
			if(c1 == str.charAt(i)) {
				count++;
				continue;
			}
			else {
				final_str += c1 + "" + count; //String cancat operation is o(n2). use StrigBuffer;
				c1 = str.charAt(i);
				count = 1; 
			}
		}
		// last iteration of string doesn't go to else part.
		final_str += c1 + "" + count;

		if(str.length() < final_str.length())
			final_str = str;

		return final_str;
	}
}