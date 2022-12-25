package medium;

public class L371 {
    public int getSum(int a, int b) {
        // first test if b is zero, if true return a (save time), if not get sum of a&b and carry of b.
       return b == 0 ? a : getSum(a^b, (a&b)<<1);
    }
}
