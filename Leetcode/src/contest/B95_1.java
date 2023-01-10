class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        Long volume=(long) length*(long)width*(long)height;
        if(length>=10000||width>=10000||height>=10000||volume>=1000000000){
            if(mass>=100){
                return"Both";
            }
            return"Bulky";
        }else{
            if(mass>=100){
                return"Heavy";
            }
            return"Neither";
        }
    }
}