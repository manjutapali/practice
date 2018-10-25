 public class SumOfKSmallNodes extends BSTree
 {

 	public static void main(String[] args)
 	{
 		BSTree bst = new SumOfKSmallNodes();

		bst.insert(10);
        bst.insert(30);
        bst.insert(13);
        bst.insert(27);
        bst.insert(64);
        bst.insert(4);
        bst.insert(8);

        bst.print();

        int sum = ((SumOfKSmallNodes) bst).GetSum(3);

        System.out.println(sum);
 	}
 	static int m;
 	public int GetSum(int k)
 	{
 		m = k;
 		return GetSum(this.root);
 	}

 	static int sum = 0;

 	public int GetSum(TreeNode root)
 	{
 		if(m != 0 && root != null)
 		{	
 			m--;
 			
 			GetSum(root.left);
 			sum += root.data;
 			GetSum(root.right);
 		}

 		return sum;
 	}
 }