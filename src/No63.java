/**
 * 股票的最大利润
 *
 * @author: 胖虎
 * @date: 2019/11/5 21:19
 **/
public class No63 {
    private static int maxDiff(int[] arr) {
        //记得判定数组为null
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = arr[0];
        int maxDiff = arr[1] - min;
        for (int i = 2; i < arr.length; i++) {
            int currentDiff = arr[i] - min;
            if (currentDiff > maxDiff) {
                maxDiff = currentDiff;
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 11, 8, 5, 7, 12, 16, 14};
        int[] arr2 = {9, 11, 8, 29, 7, 12, 16, 14};
        int[] arr3 = {9};
        int[] arr4 = {};

        System.out.println(maxDiff(arr1));
        System.out.println(maxDiff(arr2));
        System.out.println(maxDiff(arr3));
        System.out.println(maxDiff(arr4));
    }
}
