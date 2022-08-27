package medium;
import java.util.Stack;

public class L1472_1 {
    // two stack to solve the problem
    class BrowserHistory {
        private Stack<String> past;
        private Stack<String> future;
        public BrowserHistory(String homepage) {
            past=new Stack<String>();
            past.push(homepage);
            future=new Stack<String>();
        }
        
        public void visit(String url) {
            past.push(url);
            future=new Stack<String>();
        }
        
        public String back(int steps) {
            while (past.size()>1&&steps>1){
                steps--;
                future.push(past.pop());
            }
            return past.peek();
        }
        
        public String forward(int steps) {
            while (future.size()>0&&steps>0){
                steps--;
                past.push(future.pop());
            }
            return past.peek();
        }
    }
    
    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */
}
