#include "Maxheap.h"

Maxheap::Maxheap(int s) {
	size = s;
	curr_size = 0;
}

Maxheap::~Maxheap() {
	heap = nullptr;
}

bool Maxheap::hasLeftChild(int idx) {

	return ((2*idx+1) < curr_size);
}

bool Maxheap::hasRightChild(int idx) {
	return ((2*idx) < curr_size);
}

void Maxheap::heapifyUp(int i) {

	if(i > 0) {

		int par = getParent(i);

		if(heap[par] < heap[i]) {
			swap(heap[par], heap[i]);
			heapifyUp(par);
		}
	}
}

void Maxheap::heapifyDown(int i) {

	if(!hasLeftChild(i))
		return;

	int largestIdx = getLeftChild(i);

	if(hasRightChild(i) && heap[largestIdx] < heap[getRightChild(i)]) {
		largestIdx = getRightChild(i);
	}

	if(heap[i] < heap[largestIdx]) {

		swap(heap[i], heap[largestIdx]);
		heapifyDown(largestIdx);
	}
}

void Maxheap::insert(int ele) {

	if(heap == nullptr) {

		heap = new int[size];

		heap[curr_size] = ele;
		curr_size++;
	}
	else if(curr_size != size) {

		heap[curr_size] = ele;
		curr_size++;

		heapifyUp(curr_size-1);
	}
	else {

		cerr << "Heap is full" << endl;
	}

}

int main()
{
	
	return 0;
}