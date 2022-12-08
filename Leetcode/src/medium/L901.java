package medium;

import java.util.Stack;

public class L901 {
    class StockSpanner {
        // each high price added would counteract the low price before
        Stack<int[]> span;
        // the first digit stores the price, the second digit store the span
        public StockSpanner() {
            span=new Stack<int[]>();
        }
        
        public int next(int price) {
            int result=1;
            while (!span.isEmpty()&&span.peek()[0]<=price){
                // add aggregate span
                result+=span.pop()[1];
            }
            // save result to stack
            span.push(new int[]{price,result});
            return result;
        }
    }
}
