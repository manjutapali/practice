import java.util.*;
class BSTCustomOperation extends BSTree
{
    public void PrintRootToLeafPaths()
    {
        if(root == null)
            return;

        ArrayList<Integer> path = new ArrayList<Integer>();
        int pathLen = 0;
        TreeNode runnr = root;
        PrintRootToLeafPaths(runnr, path, pathLen);
    }

    private void PrintRootToLeafPaths(TreeNode root, ArrayList<Integer> path, int pathLen)
    {
        if(root == null)
            return;

        path.add(root.data);

        if(root.left == null && root.right == null)
        {
            System.out.println(path);
        }

        PrintRootToLeafPaths(root.left, path, pathLen);
        PrintRootToLeafPaths(root.right, path, pathLen);
    }

    public boolean isCousin(int val1, int val2)
    {
        Content c1 = new Content();
        Content c2 = new Content();

        boolean found1 = SearchNode(c1, root, null, val1, c1.level);
        boolean found2 = SearchNode(c2, root, null, val2, c2.level);
        //System.out.println(found1 + "   " + c1.level + "  " + c1.parent.data);
        //System.out.println(found2 + "   " + c2.level + "  " + c2.parent.data);

        if(found1 && found2 && (c1.level == c2.level) && (c1.parent.data != c2.parent.data))
        {
            return true;
        }
        return false;

    }

    public boolean SearchNode(Content c, TreeNode root, TreeNode prev, int val, int level)
    {
        if(root == null)
            return false;

        else if(root.data == val)
        {
            c.parent = prev;
            c.level = level;
            return true;
        }
        return SearchNode(c, root.left, root, val, level + 1) || SearchNode(c, root.right, root, val,  level + 1);
    }
}

class Content
{
    TreeNode parent;
    int level;

    public Content()
    {
        this.level = 1;
        parent = null;
    }
}