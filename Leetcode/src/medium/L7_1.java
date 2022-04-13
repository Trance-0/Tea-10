package medium;

public class L7_1 {
    public int reverse(int x) {
        int result=0;
        while (x!=0){
            // prevent overflow
            if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10){
                return 0;
            }
            // oct bit operation, get octbit in x and transfer them to result
            result=result*10+x%10;
            x=x/10;
        }
        return result;
    }
    // 100 56
}
