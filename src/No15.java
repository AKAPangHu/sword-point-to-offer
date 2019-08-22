/**
 * @author: 胖虎
 * @date: 2019/8/22 22:43
 **/
public class No15 {

    public int NumberOf1(int n) {
        int res = 0;
        while (n != 0){
            n = n & (n - 1);
            res++;
        }
        return res;
    }

}
