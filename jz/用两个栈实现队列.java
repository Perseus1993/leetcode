//解法1
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);
        System.out.println(stack1.peek());
    }

    public int pop() {
        if(stack1.isEmpty() == true) return (Integer)null;
        while(stack1.isEmpty() == false){
            stack2.push(stack1.pop());

        }
        //这一步也可以不用每次弹出去就返回stack1，而是判断stack2空了再找stack1要
        int res = stack2.pop();
        while(stack2.isEmpty() == false){
            stack1.push(stack2.pop());
        }
        return res;

    }
}
