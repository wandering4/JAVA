package Test03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xuzifan
 * @Date: 2024/1/28 - 01 - 28 - 16:35
 * @Description: Test03
 * @version: 1.0
 */
public class Test  {
    static Lock lock=new ReentrantLock();
    static boolean flag=false;
    static Condition cha=lock.newCondition();
    static Condition num=lock.newCondition();
    static class NumberThread implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                lock.lock();
                try {
                    if (flag) {
                        System.out.print(i + " ");
                        flag = false;
                        cha.signal();
                    } else {
                        i--;
                        num.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
        }
    }}

    static class LetterThread implements Runnable {
        @Override
        public  void run() {
            for (char ch = 'A'; ch <= 'J'; ch++) {
                lock.lock();
                try {
                    if (!flag) {
                        System.out.print(ch + " ");
                        flag = true;
                        num.signal();
                    } else {
                        ch--;
                        cha.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

        public static void main(String[] args) {
            // 创建两个线程对象
            Thread numberThread = new Thread(new NumberThread());
            Thread letterThread = new Thread(new LetterThread());

            // 启动线程
            numberThread.start();
            letterThread.start();
        }

}
