package com.chris.algorithm.demo.stackdemo;

/**
 * Created by ye830 on 10/23/2020.
 */
public class MinStack {
    private Array<Integer> array;

    /** initialize your data structure here. */
    public MinStack() {
        this.array = new Array<>();
    }

    public void push(int x) {
        array.addLast(x);
    }

    public void pop() {
        array.removeLast();
    }

    public int top() {
        return array.getLast();
    }

    public int getMin() {
        int min = array.getFirst();
        for(int i=0; i < array.getSize(); i++){
            if(array.get(i) < min){
                min = array.get(i);
            }
        }
        return min;
    }


    private class Array<E> {
        /**
         * The array
         */
        private E[] array;

        /**
         * Total capacity of the array
         */
        private int capacity;

        /**
         * How many items in the array
         */
        private int size;

        public Array(int capacity) {
            this.array = (E[]) new Object[capacity];
            this.capacity = capacity;
            this.size = 0;
        }

        public Array() {
            this(10);
        }


        /**
         * Return the array element by specific index
         *
         * @param index index of inserted value
         * @return inserted value
         * @throws IllegalArgumentException
         */
        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException();
            }
            return array[index];
        }

        /**
         * Return the last element of the array
         *
         * @return the element value
         * @throws IllegalArgumentException
         */
        public E getLast() {
            return array[size - 1];
        }

        /**
         * Return the first element of the array
         *
         * @return the element value
         * @throws IllegalArgumentException
         */
        public E getFirst() {
            return array[0];
        }

        /**
         * Add the value into the array with specific index
         *
         * @param index index of inserted value
         * @param value inserted value
         * @return inserted value
         * @throws IllegalArgumentException
         */
        public E add(int index, E value) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException();
            }

            if (size + 1 > capacity) {
                resize(2 * capacity);
            }

            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            size++;
            return value;
        }

        /**
         * Add the value into the end of the array
         *
         * @param value inserted value
         * @return inserted value
         * @throws IllegalArgumentException
         */
        public E addLast(E value) {
            return add(size, value);
        }

        /**
         * Add the value into the beginning of the array
         *
         * @param value inserted value
         * @return inserted value
         * @throws IllegalArgumentException
         */
        public E addFirst(E value) {
            return add(0, value);
        }

        /**
         * Check if searched value been included in the array
         *
         * @param value searched value
         * @return the index of searched value
         * @throws IllegalArgumentException
         */
        public int contain(E value) {
            for (int i = 0; i < size; i++) {
                if (array[i] == value) {
                    return i;
                }
            }
            return -1;
        }

        /**
         * Remove array value by specific index
         *
         * @param index value index
         * @return array value
         */
        public E remove(int index) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException();
            }
            E result = array[index];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }

            size--;

            if (size <= capacity / 4) {
                resize(capacity / 2);
            }

            return result;
        }

        /**
         * Remove the last element of the array
         *
         * @return array value
         */
        public E removeLast() {
            return remove(size - 1);
        }

        /**
         * Remove the first element of the array
         *
         * @return array value
         */
        public E removeFirst() {
            return remove(0);
        }

        /**
         * Remove array value by specific value
         *
         * @param value Specific value
         * @return remove success or not success
         */
        public boolean removeByElement(E value) {
            int position = this.contain(value);
            if (position >= 0) {
                remove(position);
                return true;
            }
            return false;
        }

        /**
         * Resize the array with new capacity
         *
         * @param capacity New capacity of the array
         */
        public void resize(int capacity) {
            E[] newArray = (E[]) new Object[capacity];
            for (int i = 0; i < this.size; i++) {
                newArray[i] = array[i];
            }
            this.array = newArray;
            this.capacity = capacity;
        }

        /**
         * Get array capacity
         *
         * @return capacity
         */
        public int getCapacity() {
            return capacity;
        }

        /**
         * Get array size
         *
         * @return capacity
         */
        public int getSize() {
            return size;
        }

        /**
         * Get whether the array is empty or not
         *
         * @return empty or not
         */
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(array[i]);
                if (i != size - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
