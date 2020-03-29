//解法1
public class Solution {
    public int RectCover(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        return RectCover(target - 1) + RectCover(target - 2);
    }
}

//解法2
public class Solution {
    public int RectCover(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int res = 0;
        int pre1 = 2;
        int pre2 = 1;
        for(int i = 2; i < target; i++){
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }
}
