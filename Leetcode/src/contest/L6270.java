package contest;
public class L6270 {
    public int takeCharacters(String s, int k) {
        // this is window slide
        int i = k, j = s.length();
        while (i < j) {
            int mid = (i + j) / 2;
            if (testWindowSize(mid, s, k)) {
                j=mid;
            } else {
                i=mid+1;
            }
        }
        return testWindowSize(i, s, k)?i:-1;
    }
    private boolean testWindowSize(int mid, String s, int k) {
        int[] count = { k, k, k };
        // load first part
        for (int i = 0; i < mid; i++) {
            count[s.charAt(s.length()-mid+i) - 97]--;
        }
        for (int i = s.length()-mid; i < s.length(); i++) {
            if (count[0] < 1 && count[1] < 1 && count[2] < 1) {
                return true;
            }
            count[s.charAt(i) - 97]++;
            count[s.charAt((mid + i) % s.length()) - 97]--;
        }
        // count last case
        if (count[0] < 1 && count[1] < 1 && count[2] < 1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        L6270 a=new L6270();
        a.takeCharacters("cbbac", 1);
    }
}
