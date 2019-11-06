import java.util.ArrayList;

/**
 * 数组中只出现一次的两个数字（其余数字出现2次）
 *
 * @author: 胖虎
 * @date: 2019/11/6 17:11
 **/
public class No56_1 {
    public void findNumsAppearOnce(int[] arr, int[] num1, int[] num2) {
        int exclusiveOr = 0;
        for (int i : arr) {
            //异或
            exclusiveOr ^= i;
        }
        int carry = 1;
        //位运算一定要加括号
        while ((carry & exclusiveOr) == 0){
            carry = carry << 1;
        }
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        for (int i : arr) {
            if ((i & carry) == 0){
                a.add(i);
            }
            else {
                b.add(i);
            }
        }
        for (Integer i : a) {
            num1[0] ^= i;
        }
        for (Integer i : b) {
            num2[0] ^= i;
        }
    }


    public static void main(String[] args) {
        No56_1 n = new No56_1();
        int[] arr = {1, 1, 2, 2, 3, 4};
        int[] num1 = {0};
        int[] num2 = {0};
        n.findNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
