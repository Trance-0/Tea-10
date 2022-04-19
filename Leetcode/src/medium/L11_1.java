package medium;

class L11_1{
    //dual pointer
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int result=0;
        while (i<j){
            if(height[i]>height[j]){
                result=Math.max(result, height[j]*(j-i));
j--;
            }else{
                result=Math.max(result, height[i]*(j-i));
                i++;
            }
        }
        return result;
    }
    //93 24
}