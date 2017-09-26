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
}
