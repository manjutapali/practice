#code
# http://practice.geeksforgeeks.org/problems/equilibrium-point/0

def GetIndex(l):
    PrevSum = 0;
    k = -1;
    #print(l)
    for i in range(0, len(l)):
        NextSum = 0;
        for j in range( i + 1, len(l)):
            NextSum += l[j];
        #print(PrevSum , " dsddsds " , NextSum , " " , k) 
        
        if(k >= 0):
            PrevSum += l[k]
        k = k + 1;
        
        if(PrevSum == NextSum):
            return i+1;
    
    return -1;

T = int(input())

for i in range(0, T):
    n = int(input())
    l = list(map(int,input().split()))
    idx = GetIndex(l)
    print(idx)
    