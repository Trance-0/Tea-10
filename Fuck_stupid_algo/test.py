from itertools import count


count=0

def tick():
    global count
    count+=1

n=6

for j in range(1,n):
    for k in range(1,j+3):
        tick()

print(count)