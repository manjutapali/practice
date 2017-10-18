/*
	* http://www.geeksforgeeks.org/transform-bst-sum-tree/
*/

public class GreaterSumTree extends BSTree
{
	public static void main(String[] args)
	{
		BSTree bst = new GreaterSumTree();

		bst.insert(10);
        bst.insert(30);
        bst.insert(13);
        bst.insert(27);
        bst.insert(64);
        bst.insert(4);
        bst.insert(8);

        bst.print();
        ((GreaterSumTree)bst).TransformTree();
        bst.print();

	}

	public void TransformTree()
	{
		this.root = TransformTree(this.root);
	}
	static int curr_sum = 0;
	public TreeNode TransformTree(TreeNode root)
	{
		if(root == null)
			return root;

		TransformTree(root.right);
		curr_sum += root.data;
		root.data = curr_sum - root.data;
		TransformTree(root.left);

		return root;
	}
}
