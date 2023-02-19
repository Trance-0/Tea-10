package contest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class B98_1 {
    int minMaxDifference(int num) {
        ArrayList<Integer> numarr=new ArrayList<Integer>();
        while (num>9){
            numarr.add(0,num%10);
            num/=10;
        }
        numarr.add(0,num);
        int target=0,maxdigit=0,mindigit=0,power=1;
        for(int i=0;i<numarr.size();i++){
            if (numarr.get(i)!=9){
                target=numarr.get(i);
            }
        }
        ArrayList<Integer>maxnum=new ArrayList<Integer>(numarr);
        for(int i=0;i<numarr.size();i++){
            if (numarr.get(i)==target){
                maxnum.set(i,9);
            }
        }
        for(int i=numarr.size()-1;i>=0;i--){
            maxdigit+=maxnum.get(i)*power;
            power*=10;
        }
        ArrayList<Integer>minnum=new ArrayList<Integer>(numarr);
        power=1;
        for(int i=numarr.size()-1;i>=0;i--){
            if (numarr.get(i)==target){
                minnum.set(i,0);
            }
        }
        for(int i=numarr.size()-1;i>=0;i--){
            mindigit+=minnum.get(i)*power;
            power*=10;
        }
        return maxdigit-mindigit;
    }
     public static void main(String[] args) {
        B98_1 a=new B98_1();
        System.out.println(a.minMaxDifference(90));
     }
}
