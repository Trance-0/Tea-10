 package easy;
 class L121{
 public int maxProfit(int[] prices) {
        int smallest_before_i=prices[0];
        int highest_profit=0;
        for(int i=1;i<prices.length;i++){
            highest_profit=Math.max(highest_profit,prices[i]-smallest_before_i);
            smallest_before_i=Math.min(smallest_before_i,prices[i]);
        }
        return highest_profit;
    }
}