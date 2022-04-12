package medium;

public class L6_1 {
    /*
    type math, build Z shape for strings.
    r=1:
        return origin
    r=2:
        shape:
        0 2 4 6 8
        1 3 5 7 9
        return [0,2,4,6,8,1,3,5,7,9]
    r=3:
        shape:
        0   4   8
        1 3 5 7 9
        2   6
        return [0,4,8,1,3,5,7,9,2,6]
    r=4:
        shape:
        0     6     12
        1   5 7   11
        2 4   8 10
        3     9
        return [0,6,1,5,7,2,4,8,3,9]
    r=5:
        shape:
        0       8
        1     7 9
        2   6
        3 5 
        4
        return [0,8,1,7,9,2,6,3,5]
    r=n: where i is row num, j is col num.
        shape:
        0                             2n-2                    
        1                        2n-3 2n-1                           jn-j
        .                    ...      ....                    ...... jn-j +i
        i           2(n-2)-i        2(n-1)+i          4(n-2)-i       
        .       ...                   ....       ....
        n-2 n                         3n-4 3n -3
        n-1                           3n-3
        shrink shape: where i={0,r}, j={}
        0                    2(n-1)+i 
        0(n-1) +i 2(n-1)-i   2(n-1)+i
        0(n-1) +i 2(n-1)-i   2(n-1)+i
        i                    3(n-1)
        return [jn-j]
    */
    public String convert(String s, int numRows) {
        StringBuilder sb=new StringBuilder();
        if(numRows<=1){
            return s;
        }
        for(int k=0;k<;i+=2){
            sb.append(s.charAt(i);
            int j=0;
            while (j(numRows-1)+i){

            }
        }
    }
}
