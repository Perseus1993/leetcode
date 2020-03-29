import java.util.Stack;

public class Solution {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public void push(int node) {
        if(min.isEmpty() == true){
            min.push(node);
            stack.push(node);
        }else if(node > min.peek()){
            stack.push(node);
        }else{
            min.push(node);
            stack.push(node);
        }

    }

    public void pop() {
        if(stack.isEmpty() == true){
            return;
        }
        if(stack.pop() == min.peek()){
            min.pop();
        }
        return;
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
