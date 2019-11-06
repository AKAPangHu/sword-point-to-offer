import java.util.Iterator;
import java.util.LinkedList;

/**
 * 圆圈中最后剩下的数字（约瑟夫环问题）
 * @author: 胖虎
 * @date: 2019/11/5 21:48
 **/
public class No62 {

    /**
     * 使用最原始的方法模拟循环链表，删除结点
     * 该解法的时间复杂度是O（mn），空间复杂度是O（n）
     * @return
     */
    public static int lastRemaining1(int n, int m){
        //和面试官要约定好了返回值
        if (n <= 0 || m <= 0){
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.listIterator();
        while (list.size() > 1){
            //循环m次
            for (int i = 1; i <= m; i++) {
                if (it.hasNext()) {
                    it.next();
                }
                else {
                    it = list.listIterator();
                    it.next();
                }
            }
            it.remove();
        }
        return list.get(0);
    }

    /**
     * 第二种解法太难。。。
     * @param n n个数
     * @param m 每次删除第m个值
     * @return
     */
    public static int lastRemaining2(int n, int m){
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining1(5, 3));
        //System.out.println(lastRemaining1(6, 3));
    }
}
