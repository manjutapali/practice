def Partition(n):
    out = ""
    PartitionUtil(n, n, out)

def PartitionUtil(n, max_val, out_str):
    
    if n == 0:
        print(out_str)
        return;
    
    for i in range(min(max_val, n), 0, -1):
        PartitionUtil(n - i, i, out_str + "," +str(i))

Partition(7)