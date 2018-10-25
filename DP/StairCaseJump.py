def NumWays(n, l):

	if(n < 0):
		return 0
	elif n == 0:
		return 1
	elif l[n] > -1 :
		return l[n]
	else:
		l[n] = NumWays(n - 1, l) + NumWays(n - 2, l) + NumWays(n - 3, l)

		return l[n]

n = int(input())

l = [ -1 for i in range(0, n)]

print(NumWays(n - 1, l))


