#include <iostream>
#include <map>
#include <vector>

using namespace std;

struct Node
{
    int data;
    Node *left;
    Node *right;
};

struct Node* newNode(int ele)
{
    struct Node *node = new Node;
    node->data = ele;
    node->left = NULL;
    node->right = NULL;

    return node;
}

void verticalOrder(Node *root, map<int, vector<int>> &m, int hd)
{
    if(root == NULL
      return;

    m[hd].push_back(root->data);

    verticalOrder(root->left, m, hd-1);
    verticalOrder(root-right, m, hd+1);
}

void PrintVertOrder(Node *root)
{
    map<int, vector<int>> m;

    verticalOrder(root, m, hd);

    map<int, vector<int>> :: iterator itr;

    for (itr=m.begin(); itr!=m.end(); itr++)
    {
        for (int i=0; i<itr->second.size(); ++i)
            cout << itr->second[i] << ", ";
        cout << endl;
    }
}

int main(int argc, char const *argv[]) {

  Node *root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
    root->right->left = newNode(6);
    root->right->right = newNode(7);
    root->right->left->right = newNode(8);
    root->right->right->right = newNode(9);
    cout << "Vertical order traversal is \n";
    PrintVertOrder(root);
    return 0;
  return 0;
}
