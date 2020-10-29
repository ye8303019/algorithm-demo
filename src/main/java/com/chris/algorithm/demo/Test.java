package com.chris.algorithm.demo;

/**
 * Created by ye830 on 10/29/2020.
 */
public class Test {
    public static void main(String args[]){
        int a[] = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        int b[] = new int[3];
        b[0] = 4;
        b[1] = 5;
        b[2] = 6;
        b = a;
        b[0] = 7;
        b[1] = 8;
        b[2] = 9;
        System.out.println(a[0]+" "+a[1]+" "+a[2]);
        System.out.println(a==b);
    }
}
