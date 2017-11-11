# http://practice.geeksforgeeks.org/problems/pythagorean-triplet/0

def BinarySearch(arr, l, h, key):
	# print(arr, key, "l = ", l, "h = ", h)
	if l <= h:

		m = int(l + (h - l) / 2)

		if m >= n:
			return False
		if key == arr[m]:
			return True;
		elif key < arr[m]:
			return BinarySearch(arr, l, m - 1, key)
		else:
			return BinarySearch(arr, m + 1, h, key)

	return False;


def CheckTriplate(arr):

	n = len(arr)
	arr.sort()
	for i in range(0, n - 2):
		num1 = arr[i] ** 2
		for j in range(i + 1, n - 1):
			tot = 0;

			num2 = arr[j] ** 2

			tot = num1 + num2;
			tot = tot ** (1/2)
			# print(arr[i] , " ", arr[j])
			if BinarySearch(arr, j, n, tot):
				return "Yes"

	return "No"

T = int(input())

for i in range(0, T):
	n = int(input())
	l = list(map(int, input().split()))

	print(CheckTriplate(l))





