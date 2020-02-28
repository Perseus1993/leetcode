//解法1
import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int len = input.length;
        ArrayList<Integer> nums = new ArrayList<>();
        if (k > len || k == 0) return nums;

        for(int i = 0; i < k; i++){
            nums.add(input[i]);
        }
        Collections.sort(nums);
        int max = nums.get(k - 1);

        for(int i = k; i < len; i++){
            if(input[i] < max){
                nums.set(k -1, input[i]);
                Collections.sort(nums);
                max = nums.get(k - 1);
            }

        }
        return nums;
    }
}
