package com.chris.algorithm.demo.unionfinddemo;

import java.util.Random;

/**
 * Created by ye830 on 5/9/2021.
 */
public class UnionFindTest {
    private static int size = 100000;
    private static int round = 10000;
    private static Random random = new Random();

    public static void  test(IUnionFind unionFind, int round) {
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

        System.out.println(unionFind.getClass().getSimpleName() +" cost is:" + cost);
    }

    public static void main(String[] args) {
        IUnionFind unionFind1 = new UnionFind1(size);
        IUnionFind unionFind2 = new UnionFind2(size);
        test(unionFind1, round);
        test(unionFind2, round);
    }
}
