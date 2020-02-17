//暴力法
public class Solution {
    public boolean Find(int target, int [][] array) {
        for(int i = 0; i < array[0].length; i++){
            for(int j = 0; j < array.length; j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}

//利用已知信息

public class Solution {
    public boolean Find(int target, int [][] array) {
        int col = array[0].length - 1;
        int row = 0;
        boolean flag = true;
        while(col >= 0 && row <= array.length - 1){
            if(array[row][col] < target){
                row += 1;
            }else if(array[row][col] > target){
                col -= 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
