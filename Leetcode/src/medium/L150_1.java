package medium;

import java.util.Stack;

public class L150_1 {
    private Stack<Integer> memory=new Stack<Integer>();
    private int swap;
    public int evalRPN(String[] tokens) {
        for(String i :tokens){
            if(i.compareTo("+")==0){
                memory.push(memory.pop()+memory.pop());
            }else if(i.compareTo("-")==0){
                swap=memory.pop();
                memory.push(memory.pop()-swap);
            }else if(i.compareTo("*")==0){
                memory.push(memory.pop()*memory.pop());
            }else if(i.compareTo("/")==0){
                swap=memory.pop();
                memory.push(memory.pop()/swap);
            }else{
                memory.push(Integer.parseInt(i));
            }
        }
        return memory.pop();
    }
}
