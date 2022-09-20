from cmath import acos
import math

def plus_vector(a,b)->list:
    result=list()
    for i in range(len(a)):
        result.append(a[i]+b[i])
    return result

def subtract_vector(a,b)->list:
    result=list()
    for i in range(len(a)):
        result.append(a[i]-b[i])
    return result

def distance_between_vectors(a,b)->list:
    result=0
    for i in range(len(a)):
        result+=(a[i]-b[i])**2
    return math.sqrt(result)

def multiply_vector(a,multiplier)-> list:
    for i in range(len(a)):
        a[i]*=multiplier
    return a

def length_of_vector(a)->list:
    return distance_between_vectors(a,[0,0,0])

def dot_product(a,b)->float:
    result=0
    for i in range(len(a)):
        result+=(a[i]*b[i])
    return result

def get_angle_between_two_vector(a,b)->float:
    length_of_a=length_of_vector(a)
    length_of_b=length_of_vector(b)
    dot_product_result=dot_product(a,b)
    print('length of vector {} is {}, vector {} is {}, dot product {}'.format(a,length_of_a,b,length_of_b,dot_product_result))
    print('result before acos{}',dot_product_result/(length_of_a*length_of_b))
    return math.acos(dot_product_result/(length_of_a*length_of_b))

def comp_a_of_b(a,b)->float:
    return (dot_product(a,b))/length_of_vector(a)

def proj_a_of_b(a,b)->list:
    factor=comp_a_of_b(a,b)/length_of_vector(a)
    for i in range(len(a)):
        a[i]*=factor
    return a

def orthog_a_of_b(a,b)->list:
    proj=proj_a_of_b(a,b)
    for i in range(len(b)):
        b[i]-=proj[i]
    return b

def get_unit_vector(a)->list:
    factor=length_of_vector(a)
    for i in range(len(a)):
        a[i]/=factor
    return a

def cross_product(a,b)->list:
    return [a[1]*b[2]-a[2]*b[1],a[2]*b[0]-a[0]*b[2],a[0]*b[1]-a[1]*b[0]]

d=[1,1,1]
e=[1,-1,2]
f=[-2,2,4]

p=[1,1,1]
q=[1,0,0]
r=[0,2,1]
# print(get_angle_between_two_vector(subtract_vector(p,q),subtract_vector(p,r)))
# print(get_angle_between_two_vector(subtract_vector(q,p),subtract_vector(q,r)))
# print(get_angle_between_two_vector(subtract_vector(r,p),subtract_vector(r,q)))
a=[-2,-2,-1]
b=[-5,0,2]
c=[0.64997789688276,10.028834864209,0.64997789688276]
d=[2,2,9]
print(get_unit_vector(cross_product([1,3,5],[1,0,5])))
# print(get_unit_vector(cross_product([3,3,3],[0,0,2])))
# print(distance_between_vectors(c,d))
# print(length_of_vector(cross_product(subtract_vector(d,c),subtract_vector(d,b))))
# print(proj_a_of_b(a,b))
# print(orthog_a_of_b(a,b))
