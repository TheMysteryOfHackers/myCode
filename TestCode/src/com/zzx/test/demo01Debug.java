package com.zzx.test;

/**
 * @author zzx
 * @create 2019-09-25 20:42
 *
 *      Debug调试程序：
 *          可以让代码逐行执行，，查看代码的执行过程，调试程序中出现的bug：
 *      使用方式：
 *          在行号的右边，鼠标左键点击，添加断点（在方法的第一行，那里有bug就添加到哪里）
 *          右键，选择Debug执行程序
 *       执行程序：
 *          f6:逐行执行程序
 *          f5：进入方法中
 *          f7：跳出方法
 *          调到下一个断点，如果没有下一个断点，那么就结束程序
 *          Ctrl+f2:退出debug模式
 *          Console:切换到控制台
 */
public class demo01Debug {
    public static void main(String[] args) {
        System.out.println(123);
        printlnString();
    }

    public static void printlnString(){
        System.out.println("这是一个输出字符串的方法");
        System.out.println("这个是一个输出方法");


    }
}
