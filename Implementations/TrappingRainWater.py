# http://practice.geeksforgeeks.org/problems/trapping-rain-water/0/?ref=self

def RainWaterContent(l):

	# Max from leftside
	left = []
	# Max from rightside
	right = []
	max = -1;
	for i in range(0, len(l)):
		if max < l[i]:
			max = l[i]

		left.append(max)

	max = -1;
	for i in range(len(l) - 1, -1, -1):
		if max < l[i]:
			max = l[i]

		right.append(max)

	right.reverse()
	total = 0;
	for i in range(0, len(l)):
		total = total + min(left[i], right[i]) - l[i];


	return total;


T = int(input())

for i in range(0, T):
	n = int(input())
	l = list(map(int, input().split()))
	total_water = RainWaterContent(l)
	print(total_water)

