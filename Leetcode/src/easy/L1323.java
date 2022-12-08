package easy;
public class L1323 {
    public int maximum69Number (int num) {
        int digits = (int)(Math.log10((double)num));
        int place = (int)(Math.pow(10, digits));
        
        while(place > 0) {
            if ((num / place) % 10 == 6) {
                return num + (3*place);
            }
            place/=10;   
        }
        return num;
    }
}
