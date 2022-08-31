package medium;


public class L2249_1 {
    //prefix
    public int countLatticePoints(int[][] circles) {
        int graphSize=200;
        int[][]graph=new int[graphSize][graphSize];
        // add to difference
        for (int i [] :circles){
            // scan from top to down
            // y value
            for (int j=i[1]-i[2],delta;j<=i[1]+i[2];j++){
                // x value
                delta=(int) Math.sqrt(Math.pow(i[2], 2)-Math.pow(j-i[1], 2))+1;
                graph[j][i[0]-delta+1]+=1;
                graph[j][i[0]+delta]-=1;
            }
        }
        int latticeCount=0;
        //printArray(graph);
        // count value
        for(int i =0;i<graphSize;i++){
            for (int j=0,value=0;j<graphSize;j++){
                value+=graph[i][j];
                if(value>0){
                    latticeCount++;
                }
            }
        }
        return latticeCount;
    }

    private void printArray(int[][]test){
        StringBuilder sb=new StringBuilder();
        for(int i =0;i<test.length;i++){
            for (int j=0;j<test[i].length;j++){
                sb.append(test[i][j]);
                sb.append("");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        L2249_1 a=new L2249_1();
        int[][] testCase={{34,70,10},{28,89,6},{36,95,18},{51,93,48},{13,50,8},{52,20,14},{64,1,1},{45,90,17},{94,47,3},{12,20,4},{46,1,1},{60,59,54},{32,86,25},{41,51,15},{26,66,20},{76,60,31},{95,56,27},{67,51,13},{18,70,9},{87,63,32},{84,6,6},{25,55,14},{11,74,2},{47,21,7},{57,88,56},{60,4,1},{34,14,14},{51,61,16},{39,38,1},{23,69,14},{79,75,70},{95,80,10},{14,66,4},{69,91,67},{95,18,11},{35,84,7},{9,48,6},{13,72,3},{76,11,5},{14,75,11},{8,94,1},{34,80,21},{53,86,49},{32,15,3},{64,61,58},{62,28,10},{67,22,20},{87,48,46},{3,5,2},{7,48,4},{75,88,68},{81,55,52},{95,74,63},{73,18,17},{17,7,4},{57,38,23},{81,22,10},{47,33,29},{58,33,31},{48,77,15},{56,55,36},{45,77,11},{82,93,22},{61,8,1},{97,58,38},{97,93,92},{53,39,24},{65,25,23},{32,90,4},{17,22,15},{40,98,32},{65,17,4},{10,28,10},{10,65,6},{23,94,3},{43,19,10},{33,90,5},{2,28,2},{96,26,9},{99,98,32}};
        System.out.println(a.countLatticePoints(testCase));
    }
}
