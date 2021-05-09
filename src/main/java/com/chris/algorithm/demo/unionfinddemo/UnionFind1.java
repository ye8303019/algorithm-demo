package com.chris.algorithm.demo.unionfinddemo;

/**
 * First implementation for UnionFind by using array
 * Created by ye830 on 5/9/2021.
 */
public class UnionFind1 implements IUnionFind {

    /**
     * This is the array for storing the mapping between element order and it's sub-collection
     */
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * return the size of current collection
     *
     * @return int
     */
    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * Find the sub-collection for number i element
     *
     * @param i the order if the collection
     * @return the sub-collection number
     */
    private int find(int i) {
        if(i < 0 || i > getSize()){
            throw new IllegalArgumentException("The number is out of bound");
        }
        return id[i];
    }

    /**
     * Check if number p element and number q element are linked
     * Time complexity is O(1)
     * @param p the number p element in the collect
     * @param q the number q element in the collect
     * @return boolean
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Merge the number p element and number q element, link all related elements together
     * For example, in order to merge number p element and number q element, which means all elements in p sub-collection should change the collection number to q related collected number
     * Time complexity is O(n)
     * @param p the number p element in the collect
     * @param q the number q element in the collect
     */
    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId){
            return;
        }
        for (int i =0; i < id.length; i ++){
            if(id[i] == pId){
                id[i] = qId;
            }
        }

    }
}
