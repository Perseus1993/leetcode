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

//解法2 java自带大顶堆
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int len= input.length;
        if(k > len || k == 0){
           return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }});
        for(int i = 0; i < len; i++){
            if(maxHeap.size() != k){
                maxHeap.offer(input[i]);
            }else if(maxHeap.peek() > input[i]){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for( Integer i : maxHeap){
            result.add(i);
        }
        return result;
    }
}
//解法3
//手写大顶堆
