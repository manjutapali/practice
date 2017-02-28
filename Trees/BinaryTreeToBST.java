import java.util.*;
public class BinaryTreeToBST
{
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);

        Tree t = new Tree();
        t.printInorder(root);
        Node res = t.ToBST(root);
        t.printInorder(res);
    }
}

class Node
{
    int data;
    Node left;
    Node right;

    public Node(int ele)
    {
        data = ele;
        left = null;
        right = null;
    }
}

class Tree
{
    public void printInorder(Node root)
    {
        if(root != null)
        {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }
    int curr = 0;
    public void Inorder(Node root, int arr[])
    {
        if(root != null)
        {
            Inorder(root.left, arr);
            arr[curr] = root.data;
            curr++;
            Inorder(root.right, arr);
        }
    }

    public int countNodes(Node root)
    {
        if(root == null)
            return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public Node ToBST(Node root)
    {
        int n = countNodes(root);
        int arr[] = new int[n];

        Inorder(root, arr);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        curr = 0;
        root = ToBSTUtil(root, arr);
        return root;
    }

    public Node ToBSTUtil(Node root, int arr[])
    {
        if(root == null)
            return root;

        root.left = ToBSTUtil(root.left, arr);
        root.data = arr[curr];
        curr++;
        root.right = ToBSTUtil(root.right, arr);

        return root;
    }
}
