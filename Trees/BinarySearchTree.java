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

    public void insert(int ele){
        root = insert(root, ele);
    }

    private Node insert(Node root, int ele){

        if(root == null){
          Node p = new Node(ele);
            root = p;
            return root;
        }
        else{

            if(ele > root.data)
                root.right = insert(root.right, ele);
            else if(ele < root.data)
                root.left = insert(root.left, ele);
        }

        return root;
    }

    // After deleting Node in tree, need to find inorder successor or predecessor if both left and right node exists
    public void delete(int ele){
        root = delete(root, ele);
    }

    private Node delete(Node root, int ele){

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

    private int getInorderSucc(Node root){
        if(root.left == null)
          return root.data;

        return getInorderSucc(root.left);
    }

    public void PrintInorder(){
        PrintInorder(root);
        System.out.println();
    }

    private void PrintInorder(Node root){
        if(root == null)
            return;
        PrintInorder(root.left);
        System.out.print(root.data + ", ");
        PrintInorder(root.right);

    }

    public void PrintPreorder(){
        PrintPreorder(root);
        System.out.println();
    }

    private void PrintPreorder(Node root){
        if(root == null)
            return;

        System.out.print(root.data+ ", ");
        PrintPreorder(root.left);
        PrintPreorder(root.right);
    }

    public void PrintPostOrder(){
        PrintPostOrder(root);
        System.out.println();
    }

    private void PrintPostOrder(Node root){
        if(root == null)
            return;

        PrintPostOrder(root.left);
        PrintPostOrder(root.right);
        System.out.print(root.data + ", ");
    }
}
