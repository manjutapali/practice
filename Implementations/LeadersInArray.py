#code
# http://practice.geeksforgeeks.org/problems/leaders-in-an-array/0

def PrintLeaders(l):
    max = -9999999;
    res = [];
    
    for i in range(len(l) - 1, -1, -1):
        if(max < l[i]):
            res.append(l[i])
            max = l[i];
    return res
    
T = int(input())

for i in range(0, T):
    n = int(input())
    l = list(map(int,input().split()))
    leaders = PrintLeaders(l)
    #print(leaders);
    for i in range(len(leaders) - 1, -1 , -1):
        print(leaders[i], end =" ")

    print()