package com.chris.algorithm.demo.BST;

/**
 * Created by ye830 on 1/18/2021.
 */
public class BST<E extends Comparable> {
    private class Node {
        E value;
        Node left;
        Node right;

        public Node(E value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public Node root;
    public int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E value) {
        root = add(root, value);
    }

    public Node add(Node node, E value) {
        if (node == null) {
            node = new Node(value);
            size++;
        } else if (value.compareTo(node.value) > 0) {
            node.right = add(node.right, value);
        } else if (value.compareTo(node.value) < 0) {
            node.left = add(node.left, value);
        }
        return node;
    }

    @Override
    public String toString() {
        return printNode(new StringBuilder(), root, 1).toString();
    }

    private StringBuilder printNode(StringBuilder sb, Node e, int level) {
        if (e == null) {
            return sb;
        }
        for(int i = 0; i < level; i++){
            sb.append("-");
        }
        sb.append(String.valueOf(e.value) + "\n");
        level = level+1;
        if (e.left != null) {
            printNode(sb, e.left, level);
        }
        if (e.right != null) {
            printNode(sb, e.right, level);
        }
        return sb;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        for (Integer i = 10; i > 0; i--) {
            bst.add(i);
        }
        bst.add(11);
        bst.add(9);
        System.out.println(bst);
    }
}
