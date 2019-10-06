/**
 * 打印从1到最大的n位数
 * @author: 胖虎
 * @date: 2019/10/6 15:46
 **/
public class No17 {

    public void print1ToMaxOfNDigits(int n){
        if (n <= 0){
            return;
        }
        char[] chars = new char[n];
        for (int i = 0; i < 10; i++) {
            //首先设置高位，递归设置低位数字
            chars[0] = (char) ('0' + i);
            print1ToMaxOfNDigitsRecursively(chars, n, 0);
        }
    }

    private void print1ToMaxOfNDigitsRecursively(char[] chars, int length, int index) {
        if (index == length - 1){
            printNum(chars);
            return;
        }
        for (int i = 0; i < 10; i++) {
            chars[index + 1] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(chars, length, index + 1);
        }
    }

    private void printNum(char[] num) {
        boolean beginningWith0 = true;
        for (char c : num) {
            if (beginningWith0 && c != '0'){
                beginningWith0 = false;
            }
            if (beginningWith0){
                continue;
            }
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        No17 a = new No17();
        a.print1ToMaxOfNDigits(10);
    }

}
