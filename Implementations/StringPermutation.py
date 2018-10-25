# String permutation

def Permute(s, l, r):

	if(l == r):
		print(s)

	else:
		for i in range(l, r+1):
			s = swap(s, l, i)
			Permute(s, l + 1, r)
			s = swap(s, l, i)


def swap(s, i, j):
	s = list(s)
	t = s[i]
	s[i] = s[j]
	s[j] = t

	return "".join(s)


s = "ABC"
Permute(s, 0, len(s) - 1) 