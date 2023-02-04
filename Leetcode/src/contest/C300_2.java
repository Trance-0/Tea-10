package contest;

public class C300_2 {
    long power(int x, int y, long p)
    {
        long res = 1; // Initialize result
 
        while (y > 0) {
 
            // If y is odd, multiply x with result
            if ((y & 1) != 0){
                res = res * x;
            }
            // y must be even now
            y = y >> 1; // y = y/2
            x = x * x; // Change x to x^2
        }
        return (int)(res % p);
    }

    public int monkeyMove(int n) {
        long M =100000007;
        long store=power(2,n,M);
        if(store<2){
            store+=(M-2);
        } 
        else{
            store-=2;
        }
        return (int)store;
    }
}
