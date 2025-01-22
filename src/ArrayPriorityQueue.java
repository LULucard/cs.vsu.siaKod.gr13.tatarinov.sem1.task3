
import static TatarMath.Math.*;

public class ArrayPriorityQueue implements PriorityQueue {
    private int[] qArray;
    private final Order qOrder;
    private int length;

    public ArrayPriorityQueue(int[] qArray, Order qOrder) {
        this.qOrder = qOrder;
        this.qArray = new int[pow(2, (qArray.length / 2) + 1)];
        System.arraycopy(qArray, 0, this.qArray, 0, qArray.length);
        length = qArray.length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public int extractMax() {
        int qMax;
        if (qOrder == Order.UP) {
            qMax = max(qArray);
            for (int i = maxDex(qArray) + 1; i < length; i++) {
                swap(qArray, i, i - 1);
            }
        } else {
            qMax = min(qArray);
            for (int i = minDex(qArray) + 1; i < length; i++) {
                swap(qArray, i, i - 1);
            }
        }
        qArray[length - 1] = 0;
        length--;
        return qMax; // O(n) - Теоритеческая сложность, по сути мы просто по массиву идем, будто пузырьком переносим максимальный элемент, и удаляем его в конце.
    }

    @Override
    public void insert(int x) {
        if (length + 1 <= qArray.length) {
            System.out.println("В очереди закончилось место");
        } else {
            qArray[length] = x;
            length++; // Я сделал стандартную реализацию инсерта для очереди, т.к. у меня ключом для сравнения является значение самой ячейки, поэтому O(1).
        }

    }

    @Override
    public int getMax() {
        if (qOrder == Order.UP) {
            return max(qArray);
        } else {
            return min(qArray);
        }
    }

    @Override
    public void increase(int x, int i) {
        qArray[i] = x;
    }


    public ArrayPriorityQueue merge(ArrayPriorityQueue a, ArrayPriorityQueue b, Order qOrd) {
        int[] newArray = new int[pow(2, ((a.length + b.length) / 2) + 1)];
        System.arraycopy(a.qArray, 0, newArray, 0, a.length);
        System.arraycopy(b.qArray, a.length, newArray, a.length, a.length + b.length - a.length);
        return new ArrayPriorityQueue(newArray, qOrd);
    }

}