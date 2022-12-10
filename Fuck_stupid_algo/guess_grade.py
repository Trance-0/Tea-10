esimtate=92
Lab=[61,96,83,97,esimtate,esimtate]
Lab_sum=0
for i in Lab:
    Lab_sum+=i/100*7
Studio=17
Exams=[74,75,esimtate]
Exams_sum=0
for i in Exams:
    Exams_sum+=i/10
Exercise=10*1
Course_eval=1
Extra=5*0.931
Grade=Lab_sum+Studio+Exams_sum+Exercise+Course_eval+Extra
print(Grade)
# A is 93