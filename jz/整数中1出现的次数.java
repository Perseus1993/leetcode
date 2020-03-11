//解法1
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        String str;
        for(int i = 0; i <= n; i++){
            str = i + "";
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '1'){
                    count += 1;
                }
            }
        }
        return count;
    }
}
//解法2
//todo
