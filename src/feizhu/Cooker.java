package feizhu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 题目二
 一个工厂，需要三名师傅，分别准备面包（师傅A），制作糕点（师傅B），封装打包（师傅C），要求这三个师傅（线程）一起协作，按照
 1. 准备面包（X）
 2. 制作糕点（Y）d
 3. 封装打包（Z）
 形式“准备面包、制作糕点、封装打包、准备面包、制作糕点、封装打包、...”输出，制作10个面包就可以。
 允许使用XYZ替代。

 输出样例1： 准备面包、制作糕点、封装打包、准备面包、制作糕点、封装打包.....循环10次。

 输出样例2： XYZXYZXYZXYZ.....循环10次。 */
public class Cooker {

    // 三个线程,三个条件
    private static Thread[] threads = new Thread[3];
    private static Condition[] conditions = new Condition[3];

    private volatile int count = 1;
    private volatile int currentId = 1;

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Cooker cooker = new Cooker();
        for (int i = 0; i < 3; i++) {
            conditions[i] = Cooker.lock.newCondition();
        }
        threads[0] = cooker.new PrintThread("X", 0);
        threads[1] = cooker.new PrintThread("Y", 1);
        threads[2] = cooker.new PrintThread("Z", 2);

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        Thread.sleep(3000l);
    }

    public class PrintThread extends Thread {
        // 输出内容
        private String value;
        // 编号，用于比较使用
        private int id;

        public PrintThread(String value, int id) {
            this.value = value;
            this.id = id;
        }

        @Override
        public void run() {
            while (count <= 10 * 3) {
                lock.lock();
                try {
                    while (currentId - 1 != id) {
                        conditions[id].await();
                    }
                    if (conditions.length == currentId) {
                        System.out.print(value);
                        currentId = 1;
                    } else {
                        System.out.print(value);
                        currentId += 1;
                    }
                    count++;

                    if (count == 10 * 3) {
                        notifyInterrupt();
                    }
                    conditions[currentId - 1].signal();
                } catch (Exception e) {
                    // error hander
                } finally {
                    lock.unlock();
                }
            }
        }

    }

    public void notifyInterrupt(){
        for (int i = 0; i < 3; i++) {
            threads[i].interrupt();
        }
    }


}
