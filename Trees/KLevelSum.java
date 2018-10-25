public class KLevelSum extends BSTree
{
	public static void main(String[] args)
	{
			
		BSTree bst = new KLevelSum();

		bst.insert(10);
        bst.insert(30);
        bst.insert(13);
        bst.insert(27);
        bst.insert(64);
        bst.insert(4);
        bst.insert(8);

        bst.print();

        ((KLevelSum) bst).LevelSum(2);
	}

	public void LevelSum(int level)
	{
		Wrapper w = new Wrapper();
		int curr_level = 0;

		LevelSum(this.root, level, w, curr_level);

		System.out.println("Sum of " + level + "th level = " + w.sum);
	}

	private void LevelSum(TreeNode root, int level, Wrapper w, int curr_level)
	{
		if(root == null)
			return;

		if(level == curr_level)
		{
			w.sum += root.data;
		}

		LevelSum(root.left, level, w, curr_level + 1);
		LevelSum(root.right, level, w, curr_level + 1);
	}
}

class Wrapper
{
	int sum;
}