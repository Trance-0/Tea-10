package contest;

public class B95_4 {
    public long maxPower(int[] stations, int r, int k) {
        int n=stations.length;
        Long[]power=new Long[n];
        Long[]healperPower=new Long[n];
        for(int i=0;i<n;i++){
            addStation(i,r,healperPower,stations[i],n);
        }
        Long swap=(long) 0;
        for(int i=0;i<n;i++){
            swap+=healperPower[i];
            power[i]=swap;
        }
        return 0;
    }

    private void addStation(int i, int r, Long[] healperPower, int j,int n) {
        int start=Math.min(i+r,n-1);
        int end=Math.max(i-r, 0);
        healperPower[start]+=j;
        healperPower[end]-=j;
    }
}
