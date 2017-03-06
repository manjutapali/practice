import java.util.*;
import java.lang.*;
import java.io.*;

class FindMinVal {
	public static void main (String[] args) {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		in.nextLine();

		for(int i = 0; i < T; i++)
		{
		    String str = in.next();
		    int k = in.nextInt();

		    System.out.println(MinValue(str, k));
		}

	}

	static int MinValue(String str, int k)
	{
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

	    for(int i = 0; i < str.length(); i++)
	    {
	        char c = str.charAt(i);

	        if(map.containsKey(c))
	        {
	            int val = map.get(c);
	            val++;
	            map.put(c, val);
	        }
	        else
	        {
	            map.put(c, 1);
	        }
	    }
			System.out.println(map);
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    Set<Character> key = map.keySet();

	    for(char c : key)
	    {
	        arr.add(map.get(c));
	    }

	    Collections.sort(arr, Collections.reverseOrder());
			System.out.println(arr);
	    if(arr.get(0) >= k )
	    {
	        int val = arr.get(0) - k;
	        arr.remove(0);
	        arr.add(0, val);
	    }
	    else
	    {
	        int idx = 0;
    	    while(k > 0 && idx < arr.size())
    	    {
    	        if(k >= arr.get(idx))
    	        {
    	            k = k - arr.get(idx);
    	            arr.remove(idx);

    	        }
    	        else
    	        {
    	            int temp = arr.get(idx) - k;
    	            arr.remove(idx);
    	            arr.add(idx, temp);
									break;
    	        }
    	    }
	    }

	    int res = 0;
			System.out.println(arr);
	    for(int i = 0; i < arr.size(); i++)
	    {
	        res += (arr.get(i) * arr.get(i));
	    }

	    return res;
	}
}
