//解法1
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        int count = 0;
        int x = 0;
        int y =0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(len1 == 1 ) {
            for(int i = 0; i < len2; i++){
                list.add(matrix[0][i]);
            }
        	return list;
        }
        if(len2 == 1){
            for(int i = 0; i < len1; i++){
                list.add(matrix[i][0]);
            }
        	return list;
        }
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
