//这道题比较巧，按照位数去考虑会很麻烦，不如两两进行拼接后比较大小，冒泡形式调整相对位置
import java.util.ArrayList;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        int tmp;
        Long n1;
        Long n2;
        for(int i = numbers.length - 1; i >= 1; i--){
            for(int j = 0; j <= i - 1; j++ ){
                n1 = Long.valueOf(numbers[j] + "" + numbers[j + 1]);
                n2 = Long.valueOf(numbers[j + 1] + "" + numbers[j]);
                if(n1 > n2){
                    tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }
        String str = "";
        for(int i : numbers){
            str += i;
        }

        return str;

    }
}
