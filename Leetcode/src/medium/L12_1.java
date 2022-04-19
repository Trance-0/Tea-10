package medium;

public class L12_1 {
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        int DecValues[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String RomanValues[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0; i<DecValues.length; i++){
            while(num>=DecValues[i]){
                num -= DecValues[i];
                sb.append(RomanValues[i]);
            }
        }
        return sb.toString();
    }
    // 96 83
}
