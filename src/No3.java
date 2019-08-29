/**
 * 寻找数组中重复数字
 * @author: 胖虎
 * @date: 2019/8/20 17:59
 **/
public class No3 {

    /**
     * 第一种解法，效率较高，不过会改变数组
     */
    public boolean duplicate1(int[] numbers, int length, int[] duplication) {
        if (length <= 0 || numbers.length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                int number = numbers[i];
                if (numbers[number] == number) {
                    duplication[0] = number;
                    return true;
                } else {
                    int temp = numbers[i];
                    numbers[i] = numbers[number];
                    numbers[number] = temp;
                }
            }
        }

        return false;
    }


    /**
     * 第二种解法，不改变数组，但有可能找不出所有重复数字
     * 通不过测试用例-v-
     */
    public boolean duplicate2(int[] numbers, int length, int[] duplication) {
        if (length <= 0 || numbers.length <= 0) {
            return false;
        }
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int middle = ((end - start) >> 1) + start;
            int count = countInRange(numbers, start, middle);
            if (end == start) {
                if (count > 1) {
                    duplication[0] = end;
                    return true;
                } else {
                    return false;
                }
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }

    private int countInRange(int[] numbers, int start, int end) {
        int count = 0;
        for (int number : numbers) {
            if (number >= start && number <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No3 no3 = new No3();
        int[] array = {0, 1, 2, 3, 4, 5, 7, 7};
        int[] duplication = {-1};
        no3.duplicate2(array, 8, duplication);
        System.out.println(duplication[0]);
    }

}
