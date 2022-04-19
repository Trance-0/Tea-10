package medium;

public class L8_1 {
    public int myAtoi(String s) {
        int result=0;
        boolean isNegative=false;
        boolean isReading=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==45||s.charAt(i)==43){
                
                if(isReading){
                    break;
                }
                isReading=true;

                if(s.charAt(i)==45){
                    isNegative=true;
                }
            }
            // if is number character
            else if(s.charAt(i)>47&&s.charAt(i)<58){
                if(result<Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&s.charAt(i)-48<7)||(result==Integer.MAX_VALUE/10&&s.charAt(i)-48<8&&isNegative)){
                    result=result*10+s.charAt(i)-48;
                }else{
                    if(isNegative){
                        return Integer.MIN_VALUE;
                    }else{
                        return Integer.MAX_VALUE;
                    }
                }
                isReading=true;
                //if is space or +
            }else if(s.charAt(i)==32){
                if(isReading){
                    break;
                }
                continue;
            }else{
                break;
            }
        }
        if(isNegative){
        return -result;
        }else{
            return result;
        }
    }

    // 100 68
}
