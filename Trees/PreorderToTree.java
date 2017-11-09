/*
	* Given a preorder, construct the tree. 
*/

public class PreorderToTree
{
	public static void main(String[] args)
	{

		int pre[] = {10, 5, 1, 7, 40, 50};

		BSTree bst = new BSTree();

		PreorderToTree p = new PreorderToTree();

		bst.root = p.GetTree(pre, new Index(), 0, pre.length - 1, pre.length);	

		bst.print();
	}

	public TreeNode GetTree(int pre[], Index preIndex, int low, int high, int size)
	{
		if(preIndex.idx >= size || low > high)
			return null;

		TreeNode root = new TreeNode(pre[preIndex.idx]);
		(preIndex.idx)++;

		if(low == high)
			return root;

		int i;
		for(i = low; i <= high; i++)
		{
			if(pre[i] > root.data)
				break;
		}

		root.left = GetTree(pre, preIndex, preIndex.idx, i - 1, size);
		root.right = GetTree(pre, preIndex, i, high, size);

		return root;
	}
}

class Index
{
	int idx;
}