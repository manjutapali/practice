#include <iostream>

using namespace std;


class Maxheap {

public:
	Maxheap(int size);
	~Maxheap();
	
	int size;

	void insert(int ele);

	int extractMax();

	int peek();

	void display();

private:

	int *heap;

	int curr_size;

	bool hasLeftChild(int i);

	bool hasRightChild(int i);

	int getLeftChild(int par) { return 2*par + 1;};

	int getRightChild(int par) { return 2*par; };

	int getParent(int child) { return (child-1)/2; };

	void heapifyUp(int i);

	void heapifyDown(int i);

};