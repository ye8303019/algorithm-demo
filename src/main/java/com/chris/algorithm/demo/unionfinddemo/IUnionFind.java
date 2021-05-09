package com.chris.algorithm.demo.unionfinddemo;

/**
 * The interface for UnionFind algorithm
 * There are 3 major interface method here
 * 1 - getSize
 * 2 - union
 * 3 - isConnected
 *
 * Created by ye830 on 5/9/2021.
 */
public interface IUnionFind {

    /**
     * Return the size of current collection
     * @return int
     */
    int getSize();

    /**
     * Merge the number p element and number q element, link all related elements together
     * @param p the number p element in the collect
     * @param q the number q element in the collect
     */
    void union(int p, int q);

    /**
     * Check if number p element and number q element are linked
     * @param p the number p element in the collect
     * @param q the number q element in the collect
     * @return boolean
     */
    boolean isConnected(int p, int q);
}
