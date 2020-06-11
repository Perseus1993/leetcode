//位运算 取得仅为位置，然后11变0， 然后进位位置<< 1寻找进一步进位

public class Solution {
    public int Add(int num1,int num2) {
        int res = num1;
        int carry;
        int pro = num2;

        while(pro != 0){
            //进位位置
            carry = pro & num1;
            //11变0
            num1 = num1 ^ pro;

            pro = carry << 1;

        }
        return num1;

    }
}
