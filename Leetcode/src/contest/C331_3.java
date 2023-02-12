package contest;

public class C331_3 {
    public int minCapability(int[] A, int k) {
        int left = 1, right = (int)1e9, n = A.length;
        while (left < right) {
            int mid = (left + right) / 2, take = 0;
            for (int i = 0; i < n; ++i)
                if (A[i] <= mid) {
                    take += 1;
                    // this is used to remove adjacent house
                    i++;
                }
            if (take >= k)
                right = mid;
            else
                left = mid + 1;
        }
        return left; //left == right
    }
        public static void main(String[] args) {
            C331_3 a=new C331_3();
            a.minCapability(new int[]{2,7,9,3,1}, 2);
        }
}
