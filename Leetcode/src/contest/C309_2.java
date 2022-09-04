package contest;

public class C309_2 {
    public int numberOfWays(int startPos, int endPos, int k) {
        if(startPos>endPos){
            return numberOfWays(endPos, startPos, k);
        }
        if((k-(endPos-startPos))%2!=0||k<(endPos-startPos)){
        return 0;
        }else{
            // this is distributable unit in every unit of path
            int unit=(k-(endPos-startPos))/2;

            return 
        }
    }
}
