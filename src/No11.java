import java.util.Arrays;

/**
 * 快速排序
 *
 * @author: 胖虎
 * @date: 2019/8/29 15:47
 **/
public class No11 {

    public void quickSort(int[] arr) throws Exception {
        quickSortCore(arr, arr.length, 0, arr.length - 1);
    }

    private void quickSortCore(int[] arr, int length, int start, int end) throws Exception {
        if (start == end){
            return;
        }
        int index = partition(arr, length, start, end);
        if (index > start){
            quickSortCore(arr, length, start + 1, index);
        }
        if (index < end){
            quickSortCore(arr, length, index + 1, end);
        }
    }

    private int partition(int[] arr, int length, int start, int end) throws Exception {
        if (arr == null || length <= 0 || start < 0 || end >= length){
            throw new Exception("Invalid Parameters!");
        }
        int mid = (start + end) >> 1;
        swap(arr, mid, end);
        int small = start - 1;
        for (int i = start; i < end; i++){
            if (arr[i] < arr[end]){
                small++;
                swap(arr, small, i);
            }
        }
        small++;
        swap(arr, small, end);
        return small;
    }

    private void swap(int[] arr, int a, int b) {
        if (a != b){
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
    }

    public static void main(String[] args) throws Exception {
        int[] n1 = {1, 2, 3, 4, 5, 6};
        int[] n2 = {};
        int[] n3 = {6, 5, 4, 3, 2, 1};
        int[] n4 = {1, 6, 3, 2, 5, 4};
        No11 no11 = new No11();
        no11.quickSort(n1);
        no11.quickSort(n4);
        no11.quickSort(n3);
//        no11.quickSort(n2);
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
        System.out.println(Arrays.toString(n3));
        System.out.println(Arrays.toString(n4));
    }
}
