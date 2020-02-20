//最直观的递归法
//本题需要注意返回条件
public class Solution {
    public int Fibonacci(int n) {
        if(n == 0 ){
            return 0;
        }else if(n == 1 || n == 2){
            return 1;
        }else{
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}
