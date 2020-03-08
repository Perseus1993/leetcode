//解法1
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }
    return sb.toString();
    }
}

//解法2
public class Solution {
    public String replaceSpace(StringBuffer str) {
    return str.toString().replace(" ","%20");
    }
}

//解法3

public class Solution {
    public String replaceSpace(StringBuffer str) {
        //获取空格数量
        int blank_num = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                blank_num++;
            }
        }
        int oldLength = str.length();
        int newLength = blank_num * 2 + oldLength;
        str.setLength(newLength);

        for(int i = newLength - 1; i >= 0; ){
            oldLength--;
            if(str.charAt(oldLength) == ' ' ){
                str.setCharAt(i--,'0');
                str.setCharAt(i--,'2');
                str.setCharAt(i--,'%');
            }else{
                str.setCharAt(i--,str.charAt(oldLength));
            }
        }
        return str.toString();
    }
}
