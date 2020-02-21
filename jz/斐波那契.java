//方法一 ：最直观的递归法
//只需要注意返回条件即可
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

//方法二：构建数组法 构建数组，一步一步直到第n个

import java.util.ArrayList;
public class Solution {
    public int Fibonacci(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(1);
        res.add(1);
        int i = 2;
        while( i <= n){
            res.add(res.get(res.size() - 1) + res.get(res.size() - 2));
            i++;
        }
        return res.get(n);
    }
}

// 方法三： 循环 用两个变量代替当前求解数前两个位置的数字，比解法2快而且占用内存小
public class Solution {
    public int Fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int pre1 = 0;
        int pre2 = 1;
        int res = 1;
        for(int  i = 2; i <= n; i++){
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }
        return res;
    }
}

//解法四 ：动态规划
public class Solution {
    public int Fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int pre = 0;
        int res = 1;
        n -= 2;
        while(n-- >= 0){
            res = pre + res;
            pre = res - pre;
        }
        return res;
    }
}
