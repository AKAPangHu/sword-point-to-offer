/**
 * 数值的整数次方
 * @author: 胖虎
 * @date: 2019/9/13 19:07
 **/
public class No16 {

    public double power(double base, int exponent) throws Exception {
        if (equals(0.0, base)){
            throw new Exception("Invalid Input!");
        }
        double result = powerWithUnsigned(base, Math.abs(exponent));

        if (exponent < 0){
            result = 1.0 / result;
        }

        return result;

    }

    private double powerWithUnsigned(double base, int exponent) {
        if (exponent == 0){
            return 1.0;
        }
        if (exponent == 1){
            return base;
        }
        double result = powerWithUnsigned(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1){
            result *= base;
        }
        return result;

    }

    private boolean equals(double a, double b) {
        return Math.abs(a - b) <= 0.0000001;
    }
}
