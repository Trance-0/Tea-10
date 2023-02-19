package contest;

import java.util.LinkedList;

public class C333_2 {
    public int minOperations(int n) {
        int oneCount = 0, curGroupSize = 0, fillGap = 0, minFlip = 0, curOneCount = 0;

        LinkedList<Boolean> bits = new LinkedList<Boolean>();
        while (n > 0) {
            if (n % 2 == 1) {
                oneCount++;
            }
            bits.add(n % 2 == 1);
            n >>= 1;
        }
        // Decide whether to fill 1 or zero, two extra operations for filling zeros
        minFlip = Math.min(oneCount, bits.size() - oneCount + 2);
        boolean lastBit = false;
        for (int i = 0; i < bits.size(); i++) {
            if (bits.get(i)) {
                lastBit = true;
                curGroupSize++;
                curOneCount++;
            } else {
                // whhen bit changes
                if (lastBit) {
                    // test if refill the next with zero would be cheaper
                    minFlip = Math.min(minFlip, oneCount - curOneCount + 2 + fillGap);

                    // if we did not reach the last bit and next bit would change to one again
                    if (i < bits.size() - 1 && bits.get(i + 1)) {
                        fillGap++;
                        bits.set(i, true);
                        curGroupSize = 1;
                    } else {
                        // test if there is only one left
                        fillGap += Math.min(2, curOneCount);
                        lastBit = false;
                        curGroupSize = 0;
                    }
                }
            }
        }
        // test if we need to fill extra gaps
        if(lastBit){
            fillGap+=2;
        }
        return Math.min(minFlip, fillGap);
    }

    public static void main(String[] args) {
        C333_2 a = new C333_2();
        System.out.println(a.minOperations(27));
    }
}
