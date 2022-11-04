package com.atguigu.first;

import org.junit.Test;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

/**
 * Description ==> TODO
 * BelongsProject ==> juc_basic
 * BelongsPackage ==> com.atguigu.first
 * Version ==> 1.0
 * CreateTime ==> 2022-11-03 18:41:03
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
public class SynchronizedTest01 {

    @Test
    public void testProperties(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.getProperties().entrySet().forEach(System.out::println);

    }

    public static void main(String[] args) {


        Thread thread01 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {
//                System.out.println("");
            }
        }, "Thread01");

        thread01.setDaemon(true);

        thread01.start();

        System.out.println(Thread.currentThread().getName() + ":: is over");

    }


}
