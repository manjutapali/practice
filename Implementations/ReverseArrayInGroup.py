#code

def ReverseInGroups(l, k):
    
    
    i = 0; j = 0;
    n = len(l);
    '''while(i < (n - k + 1)):
        temp = []
        j = i;
        while j < k and j:
            temp[j] = l[i + j]
            j += 1
        
        for a in range(0, k):
            l[i + a] = temp[k - a - 1]
        
        i += k'''
    for i in range(0, n, k):
        temp = []
        for j in range(0, k):
            if (i + j) < n:
                temp.append(l[i + j])
        #print("temp = ", temp)
        m = len(temp)
        for j in range(0, m):
            if (i + j) < n:
                l[i + j] = temp[m - j - 1]
        
    return l;

T = int(input())

for i in range(0 , T):
    n = int(input())
    l = list(map(int, input().split()))
    k = int(input())
    l = ReverseInGroups(l, k)
    [print(x, end=" ") for x in l]
    print()
    