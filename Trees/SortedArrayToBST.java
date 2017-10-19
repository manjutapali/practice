public class SortedArrayToBST
{
	public static void main(String[] args)
	{
		SortedArrayToBST t = new SortedArrayToBST();

		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		BSTree bst = t.ArrayToBST(arr);

		bst.print();
	}

	public BSTree ArrayToBST(int arr[])
	{
		BSTree bst = new BSTree();

		bst.root = ArrayToBST(arr, 0, arr.length - 1);

		return bst;
	}

	private TreeNode ArrayToBST(int arr[], int st, int end)
	{
		if(st > end)
			return null;

		int mid = (st + end) / 2;

		TreeNode root = new TreeNode(arr[mid]);

		root.left = ArrayToBST(arr, st, mid - 1);

		root.right = ArrayToBST(arr, mid + 1, end);

		return root;
	}
}