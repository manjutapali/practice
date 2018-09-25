#include<iostream>

using namespace std;


struct Node {
	int data;
	Node *left, *right;
};

class BST {

private:

	Node *root;

	Node* newNode(int ele);

	Node* insertRec(Node *root, int ele);

	int getHeightRec(Node *root);

public:

	void insert(int ele);

	int getHeight();
};

Node* BST::newNode(int ele) {
	Node *t = new Node;

	t->data = ele;
	t->left = t->right = NULL;

	return t;
}

void BST::insert(int ele) {
	root = insertRec(root, ele);
}

Node* BST::insertRec(Node *root, int ele) {

	if(root == NULL){
		root = newNode(ele);
		//cout << "Inserting... " << ele << endl;
		return root;
	}

	if( ele <= root->data) {
		root->left = insertRec(root->left, ele);
	}
	else {
		root->right = insertRec(root->right, ele);
	}

	return root;
}

int BST::getHeight() {

	//cout << root->data << endl;
	return getHeightRec(root);
}

int BST::getHeightRec(Node *root) {

	if(root == NULL)
		return 0;

	return 1 + max(getHeightRec(root->left), getHeightRec(root->right));
}


int main(int argc, char const *argv[])
{
	
	int n;
	cin >> n;

	BST *bst = new BST;

	for(int i = 0; i < n; i++) {
		int t;
		cin >> t;
		bst->insert(t);
	}

	cout << bst->getHeight() << endl;
	return 0;
}

