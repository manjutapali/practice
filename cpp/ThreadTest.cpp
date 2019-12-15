#include<iostream>
#include<thread>

static bool isFinished = false;

void Print() {

	while(!isFinished) {
		std::cout << "Hello world!" << std::endl;
		std::this_thread::sleep_for(std::chrono::seconds(1));
	}
}

int main() {

	std::thread worker(Print);
	std::cin.get();
	isFinished = true;

	worker.join();
	std::cout << "Done.." << std::endl;
}