//解法1
//原生态hashmap方法，干就完了
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
//利用字符有限来进行哈希，注意ascii码是从0开始， 因此初始化数组时候要小心
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
//24 + 24个位置行哈希，比上一个方法省点空间
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
