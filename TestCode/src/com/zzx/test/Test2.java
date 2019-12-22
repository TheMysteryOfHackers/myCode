package com.zzx.test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(10);
        list.add(12);
        list.add(15);
        Instant now1 = Instant.now();
        List<Integer> integers = method3(list, 7);
        Instant now2 = Instant.now();
        Duration between = Duration.between(now1, now2);
        long l = between.toMillis();
        System.out.println(integers.toString());
        System.out.println("时间间隔为："+l+"毫秒！");


    }

    public static List<Integer> method3(List<Integer> list, int num) {
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list6 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int abs = Math.abs(list.get(i) - num);
            list2.add(abs);
            list3.add(i);
        }
        Integer min = Collections.min(list2);
        for (int j = 0; j < list2.size(); j++) {
            if (list2.get(j) == min) {
                list6.add(list.get(list3.get(j)));
            }
        }
        return list6;
    }




    public void method() {
        int i = 0, j, l, m;
        m = ++i;
        j = m++;
        l = j++;
        System.out.println(m + " " + j + " " + l);
    }

}
