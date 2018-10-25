/*
	Given sorted sequence, find it exist in array.

	http://www.geeksforgeeks.org/check-if-given-sorted-sub-sequence-exists-in-binary-search-tree/
*/

public class SortedSequenceInTree extends BSTree
{
	public static void main(String[] args)
	{
		BSTree bst = new SortedSequenceInTree();

		bst.insert(10);
        bst.insert(30);
        bst.insert(13);
        bst.insert(27);
        bst.insert(64);
        bst.insert(4);
        bst.insert(8);

        bst.print();
        Wrapper w = new Wrapper();
        ((SortedSequenceInTree) bst).CheckIfSortedSequenceInTree(bst.root, new int[]{8, 10, 4}, 3, w);

        System.out.println(w.idx == 3 ? "YES" : "NO");
	}

	public void CheckIfSortedSequenceInTree(TreeNode root, int arr[], int n, Wrapper w)
	{
		if(root != null && n != w.idx)
		{
			CheckIfSortedSequenceInTree(root.left, arr, n, w);
			if(w.idx < n && root.data == arr[w.idx])
			{
				w.idx++;
			}
			CheckIfSortedSequenceInTree(root.right, arr, n, w);
		}

	}
}

class Wrapper
{
	int idx;
}
