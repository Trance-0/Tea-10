package contest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;
import javax.management.ValueExp;
import javax.xml.validation.Validator;

public class B95_2 {
    class DataStream {
        private Queue<Integer> match;
        private int mismatch;
        private int check;
        private int range;
        public DataStream(int value, int k) {
            match=new LinkedList<Integer>();
            check=value;
            range=k;
        }
        
        public boolean consec(int num) {
            match.add(num);
            if(num!=check){
                mismatch++;
            }
            if(match.size()>range){
                if(match.poll()!=check){
                    mismatch--;
                }
            }
            if(mismatch==0&&match.size()==range){
                return true;
            }
           return false;
        }
    }
    
    /**
     * Your DataStream object will be instantiated and called as such:
     * DataStream obj = new DataStream(value, k);
     * boolean param_1 = obj.consec(num);
     */
}
