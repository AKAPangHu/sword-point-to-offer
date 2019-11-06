/**
 * 数组中唯一出现一次的数字（其他数字都出现了3次）
 * 思路是沿用位运算，因为所有的数的位一定是出现三次，即被三整除，那么多出来的余数就是这个
 * 想要求解的数字的位了。
 * @author: 胖虎
 * @date: 2019/11/6 17:33
 **/
public class No56_2 {
    public int findNumAppearOnce(int[] arr){
        int[] bitSum = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                if ((bitMask & arr[i]) != 0){
                    bitSum[j]++;
                }
                bitMask = bitMask << 1;
            }
        }
        int r = 0;
        for (int i = 0; i < 32; i++) {
            r = r << 1;
            int remain = bitSum[i] % 3;
            if (remain != 0){
                r += 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        No56_2 n = new No56_2();
        int[] arr1 = {1, 2, 1, 1, 2, 2, 3};
        int[] arr2 = {11, 11, 11, 1};
        int[] arr3 = {-11, -11, -11, -1};
        int[] arr4 = {0, 0, 0, -1};
        int[] arr5 = {1, 1, 1, 0};
        System.out.println(n.findNumAppearOnce(arr1));
        System.out.println(n.findNumAppearOnce(arr2));
        System.out.println(n.findNumAppearOnce(arr3));
        System.out.println(n.findNumAppearOnce(arr4));
        System.out.println(n.findNumAppearOnce(arr5));
    }
}
