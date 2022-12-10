package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L380 {
    private class RandomizedSet{
    private HashSet<Integer> hs;
    
    public RandomizedSet() {
        hs=new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(!hs.contains(val))
        {
            hs.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(hs.contains(val))
        {
            hs.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
       List<Integer> list = new ArrayList<Integer>(hs);
       // build set as list
       int r=(int)(Math.random()*hs.size());
       // randomize elements.
       return list.get(r);
    }
}
}
