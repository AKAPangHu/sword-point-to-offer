/**
 * 机器人的运动范围
 *
 * @author: 胖虎
 * @date: 2019/9/13 18:32
 **/
public class No13 {

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return movingCountCore(threshold, 0, 0, rows, cols, visited);
    }

    private int movingCountCore(int threshold, int row, int col, int rows, int cols, boolean[][] visited) {
        int count = 0;
        if (check(threshold, row, col, rows, cols, visited)) {
            count = 1 + movingCountCore(threshold, row - 1, col, rows, cols, visited)
                    + movingCountCore(threshold, row, col - 1, rows, cols, visited)
                    + movingCountCore(threshold, row + 1, col, rows, cols, visited)
                    + movingCountCore(threshold, row, col + 1, rows, cols, visited);
        }
        return count;
    }

    private boolean check(int threshold, int row, int col, int rows, int cols, boolean[][] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && !visited[row][col]
                && getDigitSum(row) + getDigitSum(col) <= threshold) {
            visited[row][col] = true;
            return true;
        }
        return false;
    }

    private int getDigitSum(int num) {
        int r = 0;
        while (num != 0) {
            r += num % 10;
            num /= 10;
        }
        return r;
    }

}
