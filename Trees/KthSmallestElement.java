public class KthSmallestElement extends BSTree
{
	public static void main(String[] args)
	{
		BSTree bst = new KthSmallestElement();
		
		bst.insert(10);
        bst.insert(30);
        bst.insert(13);
        bst.insert(27);
        bst.insert(64);
        bst.insert(4);
        bst.insert(8);

       	bst.print();

       	((KthSmallestElement) bst).SmallestElement(bst.root, 3, new Wrapper());

	}

	public void SmallestElement(TreeNode root, int k, Wrapper w)
	{
		if(root != null && w.i != k)
		{
			SmallestElement(root.left, k, w);
			w.i++;
			if(k == w.i)
			{
				System.out.println(root.data);
			}
			SmallestElement(root.right, k, w);
		}


	}
}

class Wrapper
{
	int i;
}