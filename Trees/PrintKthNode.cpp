/*
    Given binary tree and K, print all nodes distant at K from the root

    recursively traverse the tree, when Node is at K distant print data
*/

#include <iostream>

using namespace std;

struct Node
{
    int data;
    Node *left;
    Node *right;
};

struct Node *newNode(int ele)
{
    struct Node *node = new Node();
    node->data = ele;
    node->left = NULL;
    node->right = NULL;

    return node;
}

void PrintKDistantNode(Node *root, int k)
{
    if(root == NULL)
        return;

    if(k == 0)
    {
        cout << root->data<<endl;
        return;
    }

    PrintKDistantNode(root->left, k-1);
    PrintKDistantNode(root->right, k-1);
}

int main()
{
    struct Node *root = newNode(1);
    root->left        = newNode(2);
    root->right       = newNode(3);
    root->left->left  = newNode(4);
    root->left->right = newNode(5);
    root->right->left = newNode(8);

    PrintKDistantNode(root, 1);

    return 0;
}
