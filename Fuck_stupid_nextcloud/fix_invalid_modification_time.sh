# echo "Please Enter the directory that you want to fix";
# read directory
directory=''
InvalidTime=1000
for FILE in *
    do 
    echo $FILE
    # modification_time= `stat -c '%y' $FILE`
    # echo modification_time
#if [do stat $FILE>$InvalidTime];
#then 
#do touch -t 1669935186 $FILE
#fi
done