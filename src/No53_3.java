/**
 * 在排序数组中查找数字
 * -------数组中数值和下标相等的元素
 * 假设和数值相等的数组下标为k
 * 由于数组是单调递增的，所以可观察到数组中与下标比数字小的均在k的左面。
 * 由此可用二分法
 *
 * @author: 胖虎
 * @date: 2019/11/6 10:44
 **/
public class No53_3 {
    static int getNumberSameAsIndex(int[] arr) {
        if (arr == null || arr.length < 1){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = (start + end) >> 1;
            if (arr[mid] == mid){
                return mid;
            }
            else if (arr[mid] < mid){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {-3, -1, 1, 3, 5};
        System.out.println(getNumberSameAsIndex(arr1));
        int[] arr2 = {0};
        System.out.println(getNumberSameAsIndex(arr2));
        int[] arr3 = {-1};
        System.out.println(getNumberSameAsIndex(arr3));
    }
}
