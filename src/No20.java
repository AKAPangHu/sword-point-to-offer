/**
 * 表示数值的字符串
 * @author: 胖虎
 * @date: 2019/10/7 18:56
 **/
public class No20 {

    private int i = 0;

    boolean isNumeric(String str){
        if (str == null){
            return false;
        }
        char[] chars = str.toCharArray();
        boolean isNumeric = scanInteger(chars);

        if (i < chars.length && chars[i] == '.'){
            i++;
            isNumeric = scanUnsignedInteger(chars) || isNumeric;
        }

        if (i < chars.length && (chars[i] == 'E' || chars[i] == 'e')){
            i++;
            isNumeric = isNumeric && scanInteger(chars);
        }

        return (i == chars.length) && isNumeric;
    }

    private boolean scanInteger(char[] chars) {
        if (i >= chars.length){
            return false;
        }
        if (chars[i] == '+' || chars[i] == '-'){
            i++;
        }
        return scanUnsignedInteger(chars);
    }

    private boolean scanUnsignedInteger(char[] chars) {
        int begin = i;
        while (i < chars.length && chars[i] >= '0' && chars[i] <= '9'){
            i++;
        }
        return begin < i;
    }

    public static void main(String[] args) {
        No20 a = new No20();
        System.out.println(a.isNumeric("-1231231231.123e-123"));
    }
}
