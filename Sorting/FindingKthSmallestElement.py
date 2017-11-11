#code
from random import randint

def QuickSelect(l, low, high, k):
    
    if low < high:
        pivot = l[high]
        pi = Partition(l, low, high, pivot)
        #print(l, pi)
        if pi == k:
            return l[k]
        elif k < pi:
            return QuickSelect(l, low, pi - 1, k)
        else:
            return QuickSelect(l, pi + 1, high, k)
    return l[k]

def Partition(l, low, high, pivot):
    i = low - 1;
    
    for j in range(low, high):
        
        if l[j] < pivot:
            i += 1
            temp = l[i]
            l[i] = l[j]
            l[j] = temp
            
    temp = l[i+1]
    l[i+1] = l[high]
    l[high] = temp
    #print("i+1 = ",i+1)
    return (i + 1);

T = int(input())

for i in range(0, T):
    n = int(input())
    l = list(map(int, input().split()))
    k = int(input())

    ele = QuickSelect(l, 0, len(l) - 1, k - 1)
    print(ele)