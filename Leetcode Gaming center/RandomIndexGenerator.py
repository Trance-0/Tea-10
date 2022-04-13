import random

str='0123456789abcdef'
result=''
for i in range (16):
    result+=str[random.randrange(0,16)]

print(result)