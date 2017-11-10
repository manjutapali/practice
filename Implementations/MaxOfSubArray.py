#code
#http://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0/?ref=self

def MaxOfSubarray(l, size):
    res = []
    for i in range(0, len(l) - size + 1):
        a = []
        for j in range(0, size):
            a.append(l[i+j])
        
        res.append(max(a))
    
    return res;


T = int(input())

for i in range(0, T):
    n,k = input().split()
    n = int(n); k = int(k)
    l = list(map(int,input().split()))
    res = MaxOfSubarray(l, k)
    #print(leaders);
    for i in range(0, len(res)):
        print(res[i], end =" ")

    print()
        