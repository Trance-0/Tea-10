package medium;
import java.util.Arrays;
import java.util.Comparator;

public class L1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        /*
         * for value like [1,1],[1,2],[2,2],[2,1]
         * you need to sort them to [2,1],[2,2],[1,1],[1,2]
         * then iterate through each element while recording the greatest i[1], since i[0] with greater value already put in front,
         * there is no way to fight against previous element
         */
        int result=0;
        Arrays.sort(properties,new Comparator<int[]>() {
            @Override
            public int compare(int[]a,int[]b){
                if (a[0]==b[0]) return a[1]<b[1]?-1:1;
                return a[0]>b[0]?-1:1;
                }
        });
        int maxValue=0;// record the max value in same curren
        for(int[] i :properties){
            if(i[1]<maxValue){
                result++;
            }
            maxValue=Math.max(maxValue, i[1]);
        }
        return result;
    }
}
