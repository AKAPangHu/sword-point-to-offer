/**
 * 在排序数组中查找数字
 * -------0~n-1中缺失的数字
 * 对于这个题，我们只需要求出第一个与下标不符的数字就可以知道缺失的数字了
 *
 * @author: 胖虎
 * @date: 2019/11/6 9:51
 **/
public class No53_2 {
    public static int getMissingNumber(int[] arr) {
        if (arr == null || arr.length < 1){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = (start + end) >> 1;
            if (arr[mid] != mid){
                if (mid == 0 || arr[mid - 1] == mid - 1){
                    return mid;
                }
                else {
                    end = mid - 1;
                }
            }
            else{
                start = mid + 1;
            }
        }
        //如果start遍历到数组之外，说明已经搜索过前面了
        //应该是最后一位缺失
        if (start == arr.length){
            return arr.length;
        }
        //无效的输入
        return -1;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4};
        System.out.println(getMissingNumber(arr1));
        int[] arr2 = {0, 1, 3, 4};
        System.out.println(getMissingNumber(arr2));
        int[] arr3 = {0, 1, 2, 3};
        System.out.println(getMissingNumber(arr3));
    }
}
