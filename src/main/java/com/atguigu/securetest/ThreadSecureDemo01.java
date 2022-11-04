package com.atguigu.securetest;

import java.util.concurrent.TimeUnit;

/**
 * Description ==> TODO
 * BelongsProject ==> juc_basic
 * BelongsPackage ==> com.atguigu.securetest
 * Version ==> 1.0
 * CreateTime ==> 2022-11-04 18:38:31
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
public class ThreadSecureDemo01 {

    private static Integer tickets = 100;

    public synchronized void saleTicket() {
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
    }


    public static void main(String[] args) {

        ThreadSecureDemo01 t1 = new ThreadSecureDemo01();
        for (int i = 1; i <= 3; i++) {
            new Thread(t1::saleTicket, "艾斯华伦斯坦" + String.valueOf(i)).start();
        }

//        t1.saleTicket();

    }


}
