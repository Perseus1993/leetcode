//解法1
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int[] arr = new int[58];
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - 65] += 1;
        }
        for(int i = 0; i < str.length(); i++){
            if( arr[str.charAt(i) -65] == 1){
                return i;
            }
        }
        return -1;
    }
}
