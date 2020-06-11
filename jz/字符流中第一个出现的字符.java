//解法1 用queue先进先出，用map去重
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    //Insert one char from stringstream
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    Queue<Character> q = new LinkedList<Character>();;
    public void Insert(char ch)
    {
        if(map.containsKey(ch) == false){
            map.put(ch, 1);
        }else{
            map.put(ch,map.get(ch) + 1);
        }
        if(map.get(ch) == 1){
            q.offer(ch);
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while(q.peek() != null){
            char c = q.peek();
            if(map.get(c) == 1){
                return c;
            }else{
                q.poll();
            }
        }

        return '#';

    }
}

//解法2
public class Solution {
    int[] chlist = new int[256];
    String str = "";
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        str += ch;
        chlist[ch] += 1;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] chArr = str.toCharArray();
        for(char ch : chArr){
            if(chlist[ch] == 1){
                return ch;
            }
        }
        return '#';

    }
}
