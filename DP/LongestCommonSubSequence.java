/*
	Given two string, find the longest common subsequence
	str1 - abcdefg
	str2 - acdgh
	ans - 4 (acdg)
*/

import java.util.Scanner;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();

		// System.out.println(LCARec(s1, s2, 0, 0));
		System.out.println(LCADynamic(s1, s2));
	}

	// Dumb recursion
	public static int LCARec(String s1, String s2, int c1, int c2) {

		if(s1.length() == c1 || s2.length() == c2)
			return 0;

		if(s1.charAt(c1) == s2.charAt(c2))
			return 1 + LCARec(s1, s2, c1 + 1, c2 + 1);
		else
			return Math.max(LCARec(s1, s2, c1 + 1, c2), LCARec(s1, s2, c1, c2 + 1));
	}

	public static int LCADynamic(String s1, String s2) {

		int temp[][] = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;

		for(int i = 1; i < temp.length; i++) {
			for(int j = 1; j < temp[i].length; j++) {

				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					temp[i][j] = 1 + temp[i - 1][j - 1];
				}
				else {
					temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
				}

				if(temp[i][j] > max){
					max = temp[i][j];
				}
			}
		}

		return max;
	}

}