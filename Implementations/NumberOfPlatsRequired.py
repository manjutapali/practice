#code
# http://practice.geeksforgeeks.org/problems/minimum-platforms/0

def NumPlatRequired(arr, dep):
    dep.sort();
    arr.sort();
    plat_need = 1;
    plat_max = 1;
    i = 1; j = 0;
    n = len(arr)
    
    while (i < n) and (j < n):
        
        if(arr[i] < dep[j]):
            plat_need += 1
            i += 1;
            if(plat_max < plat_need):
                plat_max = plat_need;
                
        else:
            plat_need -= 1
            j += 1;
    
    return plat_max;

T = int(input())

for i in range(0, T):
    n = int(input())
    arr = list(map(int, input().split()))
    dep = list(map(int, input().split()))
    platforms = NumPlatRequired(arr, dep)
    print(platforms)
            
    