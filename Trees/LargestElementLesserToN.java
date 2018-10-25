/*
	Given N, find the largest element lesser or equal to N.

	http://www.geeksforgeeks.org/largest-number-bst-less-equal-n/
*/

public class LargestElementLesserToN extends BSTree
{
	public static void main(String[] args)
	{
		BSTree bst = new LargestElementLesserToN();

		bst.insert(10);
        bst.insert(30);
        bst.insert(13);
        bst.insert(27);
        bst.insert(64);
        bst.insert(4);
        bst.insert(8);

        int val = ((LargestElementLesserToN) bst).GetElement(bst.root, 31);

        System.out.println("Value is " + val);
	}

	public int GetElement(TreeNode root, int key)
	{
		if(root.left == null && root.right == null && root.data > key)
			return -1;

		if((root.data <= key && root.right == null) || (root.data <= key && (root.right.data > key)))
			return root.data;

		if(root.data >= key)
			return GetElement(root.left, key);
		else
			return GetElement(root.right, key);
	}
}

