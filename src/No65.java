/**
 * 不用乘除法做加法
 *
 * @author: 胖虎
 * @date: 2019/11/5 20:23
 **/
public class No65 {
    public int add(int a, int b) {
        int sum, carry;
        //可能会产生多次进位
        do{
            //算出未进位时的值（异或正好和这个逻辑相符）
            sum = a ^ b;
            //算出进位（如果两个位一样且为1，证明该位置上有进位）
            carry = (a & b) << 1;
            //看看是否需要进行下一次循环
            a = sum;
            b = carry;
        }while (b != 0);
        return sum;
    }
}
