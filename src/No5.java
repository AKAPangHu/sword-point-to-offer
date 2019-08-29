/**
 * 字符串中替换空格
 * @author: 胖虎
 * @date: 2019/8/20 19:17
 **/
public class No5 {
    public String replaceSpace(StringBuffer str) {
        String trueString = str.toString();
        char[] chars = trueString.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == ' '){
                count++;
            }
        }
        char[] result = new char[chars.length + 2 * count];
        int oldIndex = chars.length - 1;
        int newIndex = result.length - 1;
        while (oldIndex >= 0 && newIndex >=0){
            if (chars[oldIndex] == ' '){
                result[newIndex--] = '0';
                result[newIndex--] = '2';
                result[newIndex] = '%';
            }
            else {
                result[newIndex] = chars[oldIndex];
            }
            newIndex--;
            oldIndex--;
        }
        return String.copyValueOf(result);
    }

    public static void main(String[] args) {
        No5 no5 = new No5();
        System.out.println(no5.replaceSpace(new StringBuffer("We Are Happy")));
    }
}
