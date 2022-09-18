package hard;

public class L42_1{
    // this problem use dual pointer    
    public int trap(int[] height) {
        int result=0;
        int left=0,right=height.length-1;
        int maxLeft=0,maxRight=0;
        while (left<=right){
            if(maxLeft<=maxRight){
                maxLeft=Math.max(height[left], maxLeft);
                result+=maxLeft-height[left];
                left++;
            }
            else{
                maxRight=Math.max(height[right], maxRight);
                result+=maxRight-height[right];
                right--;
            }
        }
        return result;
    }
}