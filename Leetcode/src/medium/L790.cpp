class Solution {
public:
    // this is Domino and Tromino Tilling you discussed with Author 12.23 night.
    int numTilings(int n) {
        // a is f(n-3), b is f(n-2) c is f(n-1), start from n, then couting back.
        // the recurssive function is f(n)=f(n-1)*2+f(n-3)
        int a=0,b=1,c=1,c2,mod=1e9+7;
        while(--n){
            c2 =(c*2%mod+a)%mod;
            a=b;
            b=c;
            c=c2;
        }
        return c;
    }
};