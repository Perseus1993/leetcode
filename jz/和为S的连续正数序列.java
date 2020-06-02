//解法1 遍历解法，复杂度二次方，注意i和j的范围可以缩小
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();

        if(sum == 1){
            return result;
        }
        int tmp;
       for(int i = 1; i <= sum / 2; i++){
           tmp = 0;
           for(int j = i ; j < sum ; j++){
               tmp += j;
               if(tmp == sum){
                   ArrayList<Integer> seq = new ArrayList<Integer>();
                   for(int k = i; k <= j; k++){
                       seq.add(k);
                   }
                   result.add(seq);
               }
               if(tmp > sum){
                   break;
               }
           }
       }
        return result;
    }
}

//解法2 窗口指针方法
//精髓在于大了左边右移，小了右边右移。每找到一组答案左边界右移这样后面的解也可以找到（考虑答案只有两个连续数值的情况，也欸问题的）

import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
        int left = 1;
        int right = 2;
        int tmp = 3;
        while(left < right){
            if(tmp < sum){
                right++;
                tmp += right;
            }else if(tmp > sum){
                tmp -= left;
                left++;
            }else{
                ArrayList<Integer> seq = new ArrayList<Integer>();
                for(int k = left; k <= right; k++){
                    seq.add(k);
                }
                result.add(seq);
                tmp -= left;
                left++;
            }
        }
        return result;
    }
}
