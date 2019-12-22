package com.zzx.test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zzx
 * @create 2019-09-25 20:22
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Integer min = Collections.min(list);
        System.out.println(min);


    }

    public void method(){
        Thread thread = new Thread(){
            public void run(){
                System.out.print("pong");
            }
        };
        thread.start();
        System.out.print("ping");
    }
}
