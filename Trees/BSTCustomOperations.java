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

    public int LevelOfNode(int val)
    {
        TreeNode p = root;
        return LevelOfNode(p, val, 1);
    }

    private int LevelOfNode(TreeNode root, int val, int level)
    {
        if(root == null)
            return 0;

        if(val == root.data)
            return level;

        int tLevel = LevelOfNode(root.left, val, level + 1);
        if(tLevel != 0)
            return tLevel;

        tLevel = LevelOfNode(root.right, val, level + 1);

        return tLevel;
    }

    public void LeftViewOfTree()
    {
        TreeNode p = root;
        LeftViewOfTree(p, 1);
        System.out.println();
    }

    static int max_lvl = 0;
    private void LeftViewOfTree(TreeNode curr, int lvl)
    {
        if(curr == null)
        {
            return;
        }

        if(max_lvl < lvl)
        {
            System.out.print(curr.data + ", ");
            max_lvl = lvl;
        }

        LeftViewOfTree(curr.left, lvl + 1);
        LeftViewOfTree(curr.right, lvl + 1);
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