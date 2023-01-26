package contest;
class C329_1{
    public int alternateDigitSum(int n) {
        int result=0;
        boolean sign=n%2==0? true:false;
        while (n>9){
            if(sign){
            result+=n%10;

            }else{
                result-=n%10;
            }
            sign=!sign;
            n/=10;
        }
        result+=n;
        return result;
    }
    public static void main(String[] args) {
        C329_1 a=new C329_1();
        a.alternateDigitSum(886996);
    }
}