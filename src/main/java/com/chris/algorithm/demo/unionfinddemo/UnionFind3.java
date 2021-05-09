package com.chris.algorithm.demo.unionfinddemo;

/**
 * First implementation for UnionFind by using array, but the value for each item is the parent item id, it's quite like a tree structure, but still using array for the implementation
 * The different between {@link UnionFind2} and 3 is here for UnionFind3, just using point the short tree to the tall tree.
 * Created by ye830 on 5/9/2021.
 */
public class UnionFind3 implements IUnionFind {

    /**
     * This is the array for storing the mapping between element order and it's sub-collection
     */
    private int[] parent;

    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    /**
     * return the size of current collection
     *
     * @return int
     */
    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * Find the root id for number i element
     *
     * @param i the order if the collection
     * @return the root id
     */
    private int find(int i) {
        if(i < 0 || i > getSize()){
            throw new IllegalArgumentException("The number is out of bound");
        }
        while(i != parent[i]){
            i = parent[i];
        }
        return parent[i];
    }

    /**
     * Check if number p element and number q element are belong to the same root id
     * Time complexity is O(h), h is the height of the tree
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
     * For example, in order to merge number p element and number q element, which means all items in the sub tree should link to another root, at this point, here should just link the root id into another root id
     * Time complexity is O(h), h is the height of the tree
     * @param p the number p element in the collect
     * @param q the number q element in the collect
     */
    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        if(sz[rootP] < sz[rootQ]){
            parent[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            parent[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
    }
}
