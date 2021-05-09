package com.chris.algorithm.demo.unionfinddemo;

import java.util.Random;

/**
 * Created by ye830 on 5/9/2021.
 */
public class UnionFindTest {
    private static int size = 100000;
    private static int round = 100000;
    private static Random random = new Random();

    public static void test(IUnionFind unionFind, int round) {
        long startTime = System.nanoTime();

        for (int i = 0; i < round; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFind.union(p, q);
        }

        for (int i = 0; i < round; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFind.isConnected(p, q);
        }

        long endTime = System.nanoTime();
        double cost = (endTime - startTime) / 1000000000.0;

        System.out.println("Collection Size:" + size + " Test Round:" + round + " " + unionFind.getClass().getSimpleName() + " cost is:" + cost);
    }

    public static void main(String[] args) {
        test(new UnionFind1(size), round);
        test(new UnionFind2(size), round);
        test(new UnionFind3(size), round);
    }
}
