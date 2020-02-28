//解法1
import java.util.ArrayList;
import java.util.*;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack stack = new Stack();
        int lens = pushA.length;
        int pushed = 0;
        for(int i = 0; i < lens; i++){
            //试着弹栈，碰见了就弹栈，然后匹配下一个
            if(stack.isEmpty() == false && (int)stack.peek() == popA[i]){
                stack.pop();
                continue;
            }
            //试着加入并验证，直到加不了
            while(pushed < lens){
                stack.push(pushA[pushed]);
                pushed++;
                if((int)stack.peek() == popA[i]){
                    stack.pop();
                    break;
                }
            }
        }
        return stack.isEmpty();

    }
}

//解法2 简洁版写法
import java.util.*;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack stack = new Stack();
        int poped  = 0;
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(stack.isEmpty() == false && (int)stack.peek() == popA[poped]){
                poped++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
