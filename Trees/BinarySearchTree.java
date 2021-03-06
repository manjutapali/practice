import java.util.*;
public class BinarySearchTree{

    public static void main(String[] args) {
        BST b = new BST();
        b.insert(25);
        b.insert(20);
        b.insert(35);
        b.insert(67);
        b.insert(15);
        b.insert(23);
        b.insert(42);
        b.PrintInorder();
        b.delete(35);
        b.PrintInorder();
        b.PrintPreorder();
        b.PrintPostOrder();
        b.PrintHeight();
        b.PrintTreeDiameter();
        b.leftViewOftree();
        b.PrintPaths();
        System.out.println(b.ClosestNeighbour(68));
    }
}

class Node{

    int data;
    Node left;
    Node right;

    public Node(int ele){
        data = ele;
        left = null;
        right = null;
    }
}

class BST{

    private Node root = null;

    public void insert(int ele)
    {
        root = insert(root, ele);
    }

    private Node insert(Node root, int ele)
    {
        if(root == null)
        {
            Node p = new Node(ele);
            root = p;
            return root;
        }
        else
        {
            if(ele > root.data)
                root.right = insert(root.right, ele);
            else if(ele < root.data)
                root.left = insert(root.left, ele);
        }

        return root;
    }

    // After deleting Node in tree, need to find inorder successor or predecessor if both left and right node exists
    public void delete(int ele)
    {
        root = delete(root, ele);
    }

    private Node delete(Node root, int ele)
    {
        if(root == null)
          return root;

        if(ele > root.data)
            root.right = delete(root.right, ele);
        else if(ele < root.data)
            root.left = delete(root.left, ele);
        else{

            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                  root.data = getInorderSucc(root.right);
                  root.right = delete(root.right, root.data);
            }
        }
        return root;
    }

    private int getInorderSucc(Node root)
    {
        if(root.left == null)
            return root.data;
        return getInorderSucc(root.left);
    }

    public void PrintInorder()
    {
        System.out.print("Inorder:");
        PrintInorder(root);
        System.out.println();
    }

    private void PrintInorder(Node root)
    {
        if(root == null)
            return;
        PrintInorder(root.left);
        System.out.print(root.data + ", ");
        PrintInorder(root.right);
    }

    public void PrintPreorder()
    {
        System.out.print("Pre order:");
        PrintPreorder(root);
        System.out.println();
    }

    private void PrintPreorder(Node root)
    {
        if(root == null)
            return;

        System.out.print(root.data+ ", ");
        PrintPreorder(root.left);
        PrintPreorder(root.right);
    }

    public void PrintPostOrder()
    {
        System.out.print("Post order:");
        PrintPostOrder(root);
        System.out.println();
    }

    private void PrintPostOrder(Node root)
    {
        if(root == null)
            return;

        PrintPostOrder(root.left);
        PrintPostOrder(root.right);
        System.out.print(root.data + ", ");
    }

    public void PrintTreeDiameter(){
        System.out.println("Diameter of tree = " + TreeDiameter(root));
    }

    private int TreeDiameter(Node root)
    {

        if(root == null)
            return 0;

        int lheight = getHeight(root.left);
        int rheight = getHeight(root.right);

        int ldiameter = TreeDiameter(root.left);
        int rdiameter = TreeDiameter(root.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
    }

    public void PrintHeight()
    {
        System.out.println("Height of tree = " + getHeight(root));
    }

    private int getHeight(Node root)
    {
        if(root == null)
            return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public void leftViewOftree()
    {
        System.out.println("Left view of tree");
        leftViewOftree(root, 1);
    }
    static int max_lvl = 0;
    private void leftViewOftree(Node root, int level)
    {
        if(root == null)
        {
            return;
        }

        if(max_lvl < level)
        {
            System.out.println(root.data);
            max_lvl = level;
        }

        leftViewOftree(root.left, level+1);
        leftViewOftree(root.right, level+1);
    }

    public void PrintPaths()
    {
        System.out.println("root to leaf paths");
        int path[] = new int[20];
        PrintPaths(root, path, 0);
    }

    private void PrintPaths(Node root,int path[], int pathLen)
    {
        if(root == null)
        {
            return;
        }

        path[pathLen] = root.data;
        pathLen++;
        if(root.left == null  && root.right == null)
        {
            for(int i = 0; i < 20; i++)
            {
                if(path[i] != 0)
                {
                    System.out.print(path[i] + ", ");
                }
            }
            System.out.println();

        }
        else
        {
            PrintPaths(root.left, path, pathLen);
            PrintPaths(root.right, path, pathLen);
        }
    }

    public void kthSmallElement(int k)
    {
        System.out.println(k + "th small element is:");
        printKthSmallElement(root,k);
    }

    private int curr = 0;
    private void printKthSmallElement(Node root,int k)
    {
        if(root != null)
        {

            printKthSmallElement(root.left, k);
            if(curr <= k)
            {   curr++;
                if(curr == k)
                System.out.println(root.data + " " );
            }
            printKthSmallElement(root.right, k);
        }
    }

    public int ClosestNeighbour(int n) {
        return ClosestNeighbour(root, n);
    }

    private int ClosestNeighbour(Node root, int n) {
        
        if (root == null)
            return -1;

        if (root.data == n) {
            return root.data;
        }

        if (root.data > n) {
            return ClosestNeighbour(root.left, n);
        }
        else{
            
            int t = ClosestNeighbour(root.right, n);
            
            if(t == -1)
                return root.data;
            else
                return t;
        }
    }
}
