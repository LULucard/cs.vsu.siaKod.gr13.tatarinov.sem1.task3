import TatarMath.Math;

import static TatarMath.Math.swap;


public class BinaryHeap {
    private int[] array;
    private final Order order;
    int length;

    public BinaryHeap(int[] array, Order order) {
        this.array = new int[Math.pow(2, array.length / 2 + 1)];
        this.order = order;
        for (int j : array) {
            insert(j);
        }

    }

    public Order getOrder() {
        return order;
    }

    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int value(int i) {
        return array[i];
    }

    public int getHeapMax() {
        return array[0];
    }

    public int getLength() {
        return length;
    }

    public void heapifyUP(int i) {
        if (order == Order.UP) {
            do {
                if (this.value(parent(i - 1)) < value(i)) {
                    swap(array, parent(i - 1), i);
                    i = parent(i - 1);
                }
            } while ((i > 0) && (value(parent(i - 1)) < value(i)));

        } else if (order == Order.DOWN) {
            do {
                if (value(parent(i) - 1) > value(i)) {
                    swap(array, parent(i - 1), i);
                    i = parent(i - 1);
                }
            } while ((i > 0) && (value(parent(i) - 1) > value(i)));
        }
    }

    public void heapifyDown(int i) {
        if (order == Order.UP) {
            do {
                int r = right(i);
                int l = left(i);
                int largest = i;
                if ((l < length) && (java.lang.Math.max(array[r], array[l]) == array[l])) {
                    largest = l;
                }
                if ((r < length) && (java.lang.Math.max(array[r], array[l]) == array[r])) {
                    largest = r;
                }
                if (largest != i) {
                    swap(array, i, largest);
                    i = largest;
                } else break;


            } while (i < length);
        } else if (order == Order.DOWN) {
            do {
                int r = right(i);
                int l = left(i);
                int largest = i;
                if ((l < length) && (java.lang.Math.min(array[r], array[l]) == array[l])) {
                    largest = l;
                }
                if ((r < length) && (java.lang.Math.min(array[r], array[l]) == array[r])) {
                    largest = r;
                }
                if (largest != i) {
                    swap(array, i, largest);
                    i = largest;
                } else break;


            } while (i < length);

        }


    }

    public void deleteMax() {
        swap(array, 0, length - 1);
        array[length - 1] = 0;
        length--;
        heapifyDown(0);
    }

    public void insert(int a) {
        if (length == array.length) {
            System.out.println("Создайте новую кучу");

        } else {
            array[length] = a;
            length++;
            heapifyUP(length - 1);
        }

    }

    public void increase(int x, int i) {
        array[i] = x;
        heapifyUP(i);
        heapifyDown(i);
    }


}
