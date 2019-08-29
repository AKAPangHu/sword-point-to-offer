/**
 * 二维数组中查找
 * @author: 胖虎
 * @date: 2019/8/20 18:58
 **/
public class No4 {

    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int col = cols - 1;
        int row = 0;
        while (row < rows && col > 0){
            if (target == array[row][col]){
                return true;
            }
            else if (target < array[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }

}
