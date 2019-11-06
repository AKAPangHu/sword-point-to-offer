/**
 * @author: 胖虎
 * @date: 2019/11/3 17:07
 **/
public class Temp2 {
    public static void main(String[] args) {
        //返回堆上的对象
        String b = new String("abc");
        //常量池中的引用
        String a = "abc";
        //返回常量池中的引用
        String c = "a" + "bc";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }
}
