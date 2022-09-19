package medium;

import java.util.Arrays;

public class L853_1{
    public int carFleet(int target, int[] position, int[] speed) {
        int groupCount=0;
        double currentSlowest=0;
        double [][]data =new double[position.length][2];
        for(int i=0;i<position.length;i++){
            data[i][0]=position[i];
            data[i][1]=(double)(target-position[i])/speed[i];
        }
        Arrays.sort(data,(a,b)->Double.compare(a[0],b[0]));
        for(int i=position.length-1;i>=0;i--){
            if(data[i][1]>currentSlowest){
                currentSlowest=data[i][1];
                groupCount++;
            }
            }
        return groupCount;
    }
}