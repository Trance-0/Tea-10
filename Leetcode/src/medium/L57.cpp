class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        bool stage=false;
        vector<int> interval;
        for (int i=0;i<intervals.size;i++){
            interval=intervals[i];
            // stage one is used to check the start of the interval
            if(stage){
                // if start is lower than new interval
                if(newInterval[0]<interval[0]){
                    // if start can continue
                    // if end is lower than new interval
                    if(newInterval[1]<interval[0]){
                        intervals.insert(i,newInterval);
                        break;
                    }
                    // if end is higher than new interval
                    else if(newInterval[1]<interval[1]){
                        intervals[i][0]=interval[0];
                        break;
                    }
                    // if the end is lower than new interval
                    else{
                        stage=false;
                    }
                }
                // if start is in the interval
                else if(){

                }
                // if start is greater than interval
            }else{

            }
        }
        return intervals;
    }
};