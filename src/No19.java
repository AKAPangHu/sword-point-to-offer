/**
 * 字符串匹配
 *
 * @author: 胖虎
 * @date: 2019/10/7 14:55
 **/
public class No19 {

    public boolean isMatch(String str, String exp) {
        if (str == null || exp == null) {
            return false;
        }
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        //满足两个条件才能返回true
        return isValid(s, e) && process(s, e, 0, 0);
    }

    private boolean process(char[] s, char[] e, int si, int ei) {
        //这时说明exp已完全匹配完毕
        if (ei == e.length) {
            return si == s.length;
        }
        //下一字符不是*情况
        if (ei + 1 == e.length || e[ei + 1] != '*') {
            //1.保证si在界限内
            //2.保证当前字符匹配
            //3.跳转到下一状态
            return si != s.length &&
                    (s[si] == e[ei] || e[ei] == '.') &&
                    process(s, e, si + 1, ei + 1);
        }
        //下一字符是*情况
        while (si != s.length && (s[si] == e[ei] || e[ei] == '.')){
            //分别匹配0, 1, 2, 3..个字符情况, 看每次情况，若不符合，继续匹配
            if (process(s, e, si, ei + 2)){
                return true;
            }
            si++;
        }
        //匹配完毕
       return process(s, e, si, ei + 2);
    }

    private boolean isValid(char[] s, char[] e) {

        for (int i = 0; i < s.length; i++) {
            if (s[i] == '.' || s[i] == '*') {
                return false;
            }
        }
        for (int i = 0; i < e.length; i++) {
            if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No19 a = new No19();
        String str = "abcasdsaasd";
        String exp = "ab******";
        System.out.println(a.isMatch(str, exp));
    }

}
