package com.atguigu.threadmethods;

import com.sun.javafx.geom.transform.Translate2D;

/**
 * Description ==> TODO
 * BelongsProject ==> juc_basic
 * BelongsPackage ==> com.atguigu.threadmethods
 * Version ==> 1.0
 * CreateTime ==> 2022-11-04 19:26:28
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
public class ImplementThreadTest01 {
    public static void main(String[] args) {
//        T11 t11 = new T11();
//        t11.start();

        T2 t2 = new T2();
        Thread thread = new Thread(t2);
        thread.start();


    }
}

class T2 implements Runnable{

    @Override
    public void run() {
        System.out.println("T2...");
    }
}

class T11 extends Thread{
    @Override
    public void run() {
        System.out.println("T1...");
    }
}

