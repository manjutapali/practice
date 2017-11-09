/*
	print root to leaf paths of a tree.
*/

public class PrintRootToLeafPaths extends BSTree
{
	public static void main(String[] args)
	{
		BSTree bst = new PrintRootToLeafPaths();

		bst.insert(10);
        bst.insert(30);
        bst.insert(13);
        bst.insert(27);
        bst.insert(64);
        bst.insert(4);
        bst.insert(8);

        bst.print();

        ((PrintRootToLeafPaths) bst).PrintPaths(bst);

	}

	public void PrintPaths(BSTree tree)
	{
		int height = tree.getHeight();

		PrintPaths(tree.root, new int[height], 0);
	}

	private void PrintPaths(TreeNode root, int path[], int pathLen)
	{
		if(root == null)
			return;

		path[pathLen++] = root.data;

		if(root.left == null && root.right == null)
		{	
			String str = "";
			for(int i = 0; i <= pathLen - 2; i++)
			{
				str += (path[i] + ",");
			}

			str += path[pathLen - 1];
			System.out.println(str);
		}

			PrintPaths(root.left, path, pathLen);
			PrintPaths(root.right, path, pathLen);
	}
}