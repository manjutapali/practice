/*
	Convert Binary tree to binary search tree, without changing it's structure.

	http://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/
*/
import java.util.Arrays;

public class BTreeToBST
{
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);

		BTreeToBST tree = new BTreeToBST();

		tree.ToBST(root);

		tree.print(root);
	}

	public void print(TreeNode root)
	{
		InorderPrint(root);
	}

	public void InorderPrint(TreeNode root)
	{
		if(root != null)
		{
			InorderPrint(root.left);
			System.out.println(root.data);
			InorderPrint(root.right);
		}
	}

	public TreeNode ToBST(TreeNode root)
	{
		// store the traversal of Btree in array.
		int n = CountNodes(root);
		Wrapper w = new Wrapper(n);
		Inorder(root, w);
		//System.out.println(Arrays.toString(w.arr));

		// sort the array
		Arrays.sort(w.arr);

		// Traverse inorder, to replace the elements from sorted array.
		w.idx = 0;
		ArrayToBST(root, w); 

		return root;
	}

	public int CountNodes(TreeNode root)
	{
		if(root == null)
			return 0;

		return CountNodes(root.left) + CountNodes(root.right) + 1;
	}

	public void Inorder(TreeNode root, Wrapper w)
	{
		if(root != null)
		{
			Inorder(root.left, w);
			//System.out.println(root.data);
			w.arr[w.idx++] = root.data;
			Inorder(root.right, w);
		}
	}

	public void ArrayToBST(TreeNode root, Wrapper w)
	{
		if(root != null)
		{
			ArrayToBST(root.left, w);
			root.data = w.arr[w.idx++];
			ArrayToBST(root.right, w);
		}
	}
}

class Wrapper
{
	int arr[];
	int idx;
	public Wrapper(int n)
	{
		arr = new int[n];
		idx = 0;
	}
}