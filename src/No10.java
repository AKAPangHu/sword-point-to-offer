/**
 * 斐波那契数列、跳台阶
 * @author: 胖虎
 * @date: 2019/8/29 14:29
 **/
public class No10 {

    public int fib(int num){
        int[] fibs = {0 , 1};
        if (num < 2){
         return fibs[num];
        }
        int result = -1;
        for (int i = 2; i <= num; i++){
            result = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = result;
        }
        return result;
    }

    public int JumpFloor(int target) {
        int[] res = {0, 1, 2};
        if (target <= 2){
            return res[target];
        }
        int result = -1;
        for (int i = 3; i <= target; i++) {
            result = res[1] + res[2];
            res[1] = res[2];
            res[2] = result;
        }
        return result;

    }

}
