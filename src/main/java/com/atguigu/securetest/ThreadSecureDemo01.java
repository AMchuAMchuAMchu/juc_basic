package com.atguigu.securetest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * Description ==> TODO
 * BelongsProject ==> juc_basic
 * BelongsPackage ==> com.atguigu.securetest
 * Version ==> 1.0
 * CreateTime ==> 2022-11-04 18:38:31
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
public class ThreadSecureDemo01 {

    //票数
    private static volatile Integer tickets = 100;
    //代码块的锁
    private static Object o = new Object();

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

    private static StampedLock sl = new StampedLock();

    //   原线程安全例子  public void saleTicket() {
//  1.0 方法加锁解决线程安全问题  public synchronized void saleTicket() {
    public void saleTicket() {
//      2.0 代码块加锁解决  synchronized (o) {
//       3.0 可重入锁解决 reentrantLock.lock();
//       4.0 可重入读写锁 rw.writeLock().lock();
//       5.0 邮戳锁 long l = sl.writeLock();
        try {
            for (int i = 1; i <= 100; i++) {
                if (tickets > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":: 在销售第" + tickets-- + "张票");
                } else {
                    return;
                }
            }
        } finally {
//     3.0       reentrantLock.unlock();
//     4.0       rw.writeLock().unlock();
//     5.0       sl.unlock(l);
        }

//  2.0      }
    }


    public static void main(String[] args) {

        ThreadSecureDemo01 t1 = new ThreadSecureDemo01();
        for (int i = 1; i <= 3; i++) {
            new Thread(t1::saleTicket, "艾斯华伦斯坦" + String.valueOf(i)).start();
        }

//        t1.saleTicket();

    }


}
