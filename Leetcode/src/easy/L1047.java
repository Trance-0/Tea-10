package easy;

public class L1047 {
    // use dual pointer method
    public String removeDuplicates(String s) {
        // in this case, we store i as pointer to write, j is the pointer to compare
        int i=0,n=s.length();
        char[] result=s.toCharArray();
        for(int j=0;j<n;j++,i++){
            result[i]=result[j];
            // if i is in the range and char on i-1 and j is the same
            if(i>0&&result[i-1]==result[i]){
                 // the delete the char on i by deleting the 2 most recent element.
                i-=2;
            }
        }
        return new String(result,0,i);
    }
}
