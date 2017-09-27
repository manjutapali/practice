import java.util.Scanner;

public class RotationStrings {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		String str1 = in.nextLine();
		String str2 = in.nextLine();

		System.out.println(IsRoation(str1, str2) ? "YES" : "NO");
	}

	private static boolean IsRoation(String str1, String str2) {

		if(str1.length() > 0 && str1.length() != str2.length())
			return false;

		return IsSubstring(str1 + str1, str2);
	}

	private static boolean IsSubstring(String str1, String str2) {

		int i = 0, j = 0;
		int len = str2.length();
		int k = 0;
		boolean flag = false;

		while(j < str1.length() - 1 ) {

			if(str1.charAt(j) == str2.charAt(k)) {
				j++;
				k++;
			}
			else 
			{
				i++;
				j = i;
				k = 0;
			}

			if((j - i) == len){
				flag = true;
				break;
			} 
		}

		return flag;
	}
}