import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author: 胖虎
 * @date: 2019/8/29 19:00
 **/
public class Temp {
    public static void main(String[] args) throws InterruptedException {

        final Object o = new Object();
        final Object o2 = new Object();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("r1开始");
                synchronized (o){
                    System.out.print("_A");
                    o.notify();
                    System.out.println("r1结束");
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("r2开始");
                synchronized (o){
                    try {
                        System.out.println("r2在等待");
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("_B");
                }
                synchronized (o2){
                    o2.notify();
                    System.out.println("r2结束");
                }
            }
        };
        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                synchronized (o2){
                    try {
                        System.out.println("r3在等待");
                        o2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("_C");
                }

            }
        };
        Scanner cin = new Scanner(System.in);
        String next = cin.next();
        System.out.print(next);
        Thread a = new Thread(r1);
        Thread b = new Thread(r2);
        Thread c = new Thread(r3);

        a.start();
        b.start();
        c.start();
    }
}
