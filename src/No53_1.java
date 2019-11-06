/**
 * 在排序数组中查找数字
 * -------数字在排序数组中出现的次数
 * 如果使用二分查找之后遍历前后，这样的方式较为简便，但却不快，因为如果数组规模为n，则时间复杂度为O（n）
 * 可以使用两次二分法分别递归寻找出最前和最后的下标
 *
 * @author: 胖虎
 * @date: 2019/11/6 9:13
 **/
public class No53_1 {
    public static int getNumberOfK(int[] arr, int k) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int first = getFirstK(arr, 0 , arr.length - 1, k);
        int end = getLastK(arr, 0, arr.length - 1, k);
        if (first == -1 && end == -1){
            return 0;
        }
        int numOfK = end - first + 1;
        return numOfK;
    }

    private static int getFirstK(int[] arr, int start, int end, int k) {
        if (start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if (arr[mid] == k){
            //如果这个数已经是k了
            //那么有可能前面的数不是k，或者前面没有数了
            //要不然就是前面还有k
            if (mid == 0 || arr[mid - 1] != k){
                return mid;
            }
            else{
                end = mid - 1;
            }
        }
        else if (arr[mid] < k){
            start = mid + 1;
        }
        else {
            end = mid - 1;
        }
        return getFirstK(arr, start, end, k);
    }

    private static int getLastK(int[] arr, int start, int end, int k) {
        if (start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if (arr[mid] == k){
            if ((mid < arr.length - 1 && arr[mid + 1] != k)
                    || mid == arr.length - 1){
                return mid;
            }
            else{
                start = mid + 1;
            }
        }
        else if (arr[mid] < k){
            start = mid + 1;
        }
        else {
            end = mid - 1;
        }
        return getLastK(arr, start, end, k);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5};
        System.out.println(getNumberOfK(arr, 3));
        int[] arr2 = {1, 1, 1, 1, 2, 3, 4, 5};
        System.out.println(getNumberOfK(arr2, 1));
        int[] arr3 = {1, 2, 3, 4, 5, 5, 5, 5, 5};
        System.out.println(getNumberOfK(arr3, 5));
        int[] arr4 = {1, 2, 3, 4, 5};
        System.out.println(getNumberOfK(arr4, 3));
        int[] arr5 = {};
        System.out.println(getNumberOfK(arr5, 3));
    }
}
