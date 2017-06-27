import java.util.*;

public class TreeDriver
{
    public static void main(String[] args)
    {
        BSTree bst = new BSTree();

        bst.insert(10);
        bst.insert(30);
        bst.insert(13);
        bst.insert(27);
        bst.insert(64);
        bst.insert(4);
        bst.insert(8);

        System.out.println("Tree contents : ");
        bst.print();
    }
}
