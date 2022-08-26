package medium;
class L331_1{
    public boolean isValidSerialization(String preorder) {
        // ths counts for indegree and out degree
        // for root we got 2 out
        // for other node we got 1 in and 2 out
        // for leaf we got i in
        int outDegreeDiff=1;
        String[] nodes=preorder.split(",");
        for(String i :nodes){
            outDegreeDiff--;
            if (outDegreeDiff<0){return false;
            }
            if(!i.equals("#")){
                outDegreeDiff+=2;
            }
        }
        return outDegreeDiff==0;
    }
}