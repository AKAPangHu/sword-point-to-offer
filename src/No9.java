import java.util.Stack;

/**
 * 使用栈来实现队列
 * @author: 胖虎
 * @date: 2019/8/29 12:27
 **/
public class No9 {

    private Stack<Integer> main = new Stack<>();
    private Stack<Integer> support = new Stack<>();

    public void add(Integer integer){
        support.push(integer);
    }
    public Integer poll(){
        if (main.empty() && support.empty()){
            throw new RuntimeException("Queue is empty");
        }
        else if (main.empty()){
            while (!support.empty()){
                main.push(support.pop());
            }
        }
        return main.pop();
    }
    public Integer peek(){
        if (main.empty() && support.empty()){
            throw new RuntimeException("Queue is empty");
        }
        else if (main.empty()){
            while (!support.empty()){
                main.push(support.pop());
            }
        }
        return main.peek();
    }

    public static void main(String[] args) {
        No9 no9 = new No9();
        no9.add(1);
        no9.add(2);
        System.out.println(no9.peek());
        System.out.println(no9.poll());
        no9.add(3);
        no9.add(4);
        System.out.println(no9.poll());
        System.out.println(no9.poll());
    }

}
