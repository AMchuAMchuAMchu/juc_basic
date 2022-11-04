package com.atguigu.threadmethods;

import com.sun.javafx.geom.transform.Translate2D;

import java.util.concurrent.*;

/**
 * Description ==> TODO
 * BelongsProject ==> juc_basic
 * BelongsPackage ==> com.atguigu.threadmethods
 * Version ==> 1.0
 * CreateTime ==> 2022-11-04 19:26:28
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
public class ImplementThreadTest01 {

    public void sayHello() {
        System.out.println("KNCW...");
        System.out.println("你好...");
        System.out.println("hello...");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        T11 t11 = new T11();
//        t11.start();

//        T2 t2 = new T2();
//        Thread thread = new Thread(t2);
//        thread.start();
//
//        T3 t3 = new T3();
//        FutureTask<String> futureTask = new FutureTask<>(t3);
//        Thread thread = new Thread(futureTask);
//        thread.start();
//        //注意一下执行的顺序,需要在start()之后执行的话才可以获取到结果的说...
//        String s = futureTask.get();
//        System.out.println(" >> "+s);

        ExecutorService es = Executors.newFixedThreadPool(3);
        ImplementThreadTest01 itt = new ImplementThreadTest01();
        for (int i = 0; i < 3; i++) {
            es.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "::");
                itt.sayHello();
            });
        }

        es.shutdown();

    }
}

class T3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("T3...");
        return "callable...";
    }
}

class T2 implements Runnable {

    @Override
    public void run() {
        System.out.println("T2...");
    }
}

class T11 extends Thread {
    @Override
    public void run() {
        System.out.println("T1...");
    }
}

