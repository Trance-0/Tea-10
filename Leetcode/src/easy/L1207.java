package easy;

public class L1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] buckets=new int[2001];
        boolean[] ruler=new boolean[1001];
        for(int i:arr){
            buckets[i+1000]++;
        }
        for(int i:buckets){
            if(i==0){
                continue;
            }
            if(ruler[i]){
                return false;
            }
            ruler[i]=true;
        }
        return true;
    }
}
