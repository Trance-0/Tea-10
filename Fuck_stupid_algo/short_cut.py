def double_hashing(value,key1,key2,size):
    result=[]
    for i in range(size):
        result.append((value%key1+i*(key2-value%key2))%size)
    print(result)

def quadratic_hashing(value,key1,key2,size):
    result=[]
    for i in range(size):
        result.append((value%size+key1*i+key2*i*i)%size)
    print(result)

# double_hashing(69,11,7,11)
quadratic_hashing(16,1,1,11)