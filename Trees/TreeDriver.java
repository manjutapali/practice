import java.util.*;

public class TreeDriver
{
    public static void main(String[] args)
    {
        // BSTree bst = new BSTree();

        BSTCustomOperation bst = new BSTCustomOperation();
        bst.insert(10);
        bst.insert(30);
        bst.insert(13);
        bst.insert(27);
        bst.insert(64);
        bst.insert(4);
        bst.insert(8);

        System.out.println("Tree contents : ");
        bst.print();

        boolean status = bst.delete(64);
        //System.out.println(status);

        System.out.println("Tree contents : ");
        bst.print();

        //bst.printSmallest();
        //bst.printSmallest(3);

        System.out.println("Height of tree : " + bst.getHeight());

        //Printing all the root to leaf paths
        System.out.println("Root to leaf paths are:" );
        bst.PrintRootToLeafPaths();

       boolean isCousin =  bst.isCousin(13, 8);

       System.out.println(isCousin ? "YES!!, They are cousins" : "No:(, not cousins");
    }
}
