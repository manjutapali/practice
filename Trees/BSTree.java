class BSTree
{
    private int numberOfNodes;
    private int height;
    private TreeNode root = null;

    public void insert(int data)
    {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode root, int data)
    {

        if(root == null)
        {
            TreeNode node = new TreeNode(data);
            root = node;
            return root;
        }

        if(root.data > data)
        {
            root.left = insert(root.left, data);
        }
        else if(root.data < data)
        {
            root.right = insert(root.right, data);
        }

        return root;

    }

    // prints inorder of tree
    public void print()
    {
        System.out.print("Inorder of tree:- \n");
        print(root);
        System.out.print("\n\n");

    }

    private void print(TreeNode root)
    {
        if(root != null)
        {
            print(root.left);
            System.out.print(root.data  + ", ");
            print(root.right);
        }
    }

    //Height of the tree
    public int getHeight()
    {
        return getHeight(root);
    }

    private int getHeight(TreeNode root)
    {
        if(root == null)
            return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;    
    }

    // After deleting a node in tree, need to find inorder successor or predecessor;
    public boolean delete(int data)
    {
        root = delete(root, data);

        return (root != null);
    }

    private TreeNode delete(TreeNode root, int data)
    {
        if(root == null)
        {
            return root;
        }

        if(data < root.data)
        {
            root.left = delete(root.left, data);
        }
        else if(data > root.data)
        {
            root.right = delete(root.right, data);
        }
        else
        {
              if(root.left == null)
                  return root.right;

              else if(root.right == null)
                  return root.left;

              else
              {
                  root.data = getInorderSucc(root.right);
                  root.right = delete(root.right, root.data);
              }
        }

        return root;
    }

    private int getInorderSucc(TreeNode root)
    {
        if(root.left == null)
            return root.data;

        return getInorderSucc(root.left);
    }

    public void printSmallest()
    {
        printSmallest(root);
    }

    private void printSmallest(TreeNode root)
    {
          if(root.left == null)
          {
              System.out.println("Smallest element is : " + root.data);
              return;
          }

          printSmallest(root.left);
    }

    // Getting the kth smallest element of the tree
    public void printSmallest(int k)
    {
        printSmallest(root, k);
    }

    private int curr = 0;
    public void printSmallest(TreeNode root, int k)
    {
        if(root != null)
        {
            printSmallest(root.left, k);

            if(curr <= k)
            {
                curr++;
                if(curr == k)
                  System.out.println(k + "th smallest element is: " + root.data);
            }

            printSmallest(root.right, k);
        }

    }

}
