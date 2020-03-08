//解法1
//count相当于洋葱壳，循环一周后增加1，利用层数，再每一行列的尽头把握住两点：是否已经显示所有元素并跳出，或者跳到合适的地方进行下一层
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        //层数
        int count = 0;
        int x = 0;
        int y =0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(count < len1 - count && count < len2 - count){
            while(y < len2 - count){
                list.add(matrix[x][y++]);
            }
            y--;
            x++;
            if(count >= len1 - count - 1){
                break;
            }
            while(x < len1 - count){
                list.add(matrix[x++][y]);
            }
            if(count >= len2 - count - 1){
                break;
            }
            x--;
            y--;
            while(y >= count){
                list.add(matrix[x][y--]);
            }
            y++;
            x--;
            if(count >= len2 - count - 1){
                break;
            }
            while(x >= count + 1){
                list.add(matrix[x--][y]);
            }
            if(count >= len1 - count - 1){
                break;
            }
            x++;
            y++;
            count++;

        }
        return list;
    }
}
