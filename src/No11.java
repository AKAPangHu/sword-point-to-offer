/**
 * 旋转数组中的最小数字
 *
 * @author: 胖虎
 * @date: 2019/8/29 15:47
 **/
public class No11 {

    public int minNumberInRotateArray(int [] array) throws Exception {
        if (array == null || array.length <= 0){
            throw new Exception("Invalid Parameters");
        }
        //后面数组最后索引
        int index2 = array.length - 1;
        //前面数组开始索引
        int index1 = 0;
        int mid = 0;
        //如果前面数小于后面，代表没有数字被旋转到后面
        while (array[index1] >= array[index2]){
            //两索引相遇代表找到最小值
            if (index2 - index1 == 1){
                mid = index2;
                break;
            }
            mid = (index1 + index2) >> 1;
            //如果三个点数字均相等，则只能用顺序查找
            if (array[mid] == array[index1] && array[mid] == array[index2]){
                return minInOrder(array);
            }
            //若前面的小于中间的，则代表最小的点一定在中间之后，将第一个指针后移
            if (array[index1] <= array[mid]){
                index1 = mid;
            }
            //若后面的大于中间的，第二个指针前移
            else if (array[index2] >= array[mid]){
                index2 = mid;
            }
        }
        return array[mid];
    }

    private int minInOrder(int[] array) {
        int min = array[0];
        for (int i : array) {
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}
