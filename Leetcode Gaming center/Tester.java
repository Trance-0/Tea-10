public class Tester {
    public static void printarr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
    public static void printarr(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] i : arr) {
            sb.append("[");
            for (int j : i) {
                sb.append(j);
                sb.append(",");
            }
            sb.append("]"+"\n");
        }
        System.out.println( sb.toString());
    }
    public static void main(String[] args) {
        Solution a=new Solution();
        int[] nums={1,2,3,4,5,6,7};
        a.rotate(nums, 3);
        printarr(nums);
    }
   
}
