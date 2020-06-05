//解法1
class Solution {
public:
    int back_track(int n) {
        // n <= 4, 表明不分，长度是最大的
        if (n <= 4) {
            return n;
        }

        int ret = 0;
        for (int i = 1; i < n; ++i) {
            ret = max(ret, i * back_track(n - i));
        }
        return ret;
    }
    int cutRope(int number) {
        // number = 2 和 3 时，分 2 段和分 1 段的结果是不一样的，所以需要特判一下
        if (number == 2) {
            return 1;
        }
        else if (number == 3) {
            return 2;
        }
        return back_track(number);
    }
};

//解法2  添加记忆，减去重复计算
import java.util.HashMap;

public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int cutRope(int target) {

        if(target == 2) return 1;
        if(target == 3) return 2;


        return cut(target);
    }

    public int cut(int tar){
        if(tar <= 4) return tar;
        if(map.get(tar) != null){
            return map.get(tar);
        }
        int res = 0;
        for(int i = 1; i < tar; i++){
            res = Math.max(res, i * cut( tar - i));
        }
        map.put(tar, res);
        return res;
    }
}

//解法3
public class Solution {
    public int cutRope(int target) {
        int[] list = new int[target + 1];
        for(int i = 0; i < target + 1; i++){
            list[i] = -1;
        }
        if(target == 2) return 1;
        if(target == 3) return 2;
        for(int i = 0; i <= 4; i++){
            list[i] = i;
        }
        for(int i = 5; i <= target; i++){
            for(int j = 1; j < i; j++){

                list[i] = Math.max(list[i], j * list[i - j]);
            }

        }

        return list[target];
    }
}
