//解法1
import java.util.HashMap;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
        	char c = str.charAt(i);
            map.put(c ,map.containsKey(c)? map.get(c) + 1 : 1);
        }
		for (int i = 0; i < str.length(); i++) {
			if (map.get(str.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
    }
}
//解法2
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int[] arr = new int['z' + 1];
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i)] += 1;
        }
        for(int i = 0; i < str.length(); i++){
            if(arr[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}
//解法3
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
