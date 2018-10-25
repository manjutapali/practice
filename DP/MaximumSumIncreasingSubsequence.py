#http://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0

def GetMaxSum(l):
    
    res = [];
    
    for i in l:
        res.append(i)
    
    for i in range(1, len(l)):
        for j in range(0, i):
            
            if(l[i] > l[j]):
                res[i] = max(res[i], res[j] + l[i])
    
    return max(res)

T = int(input())

for i in range(0, T):
    n = int(input())
    l = list(map(int,input().split()))
    max_sum = GetMaxSum(l)
    print(max_sum)