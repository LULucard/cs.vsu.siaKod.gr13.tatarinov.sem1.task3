import TatarMath.Math;

public class HeapPriorityQueue implements PriorityQueue {
    private BinaryHeap qBHeap;
    private final Order qOrder;
    private int length;

    public HeapPriorityQueue(BinaryHeap bHeap) {
        this.qOrder = bHeap.getOrder();
        qBHeap = bHeap;
        this.length = bHeap.getLength();
    }

    @Override
    public int getMax() {
        return qBHeap.getHeapMax();
    }

    @Override
    public int extractMax() {
        int result = getMax();
        qBHeap.deleteMax();
        length = qBHeap.getLength();
        return result; //O(log(n)) - т.к. дефолт метод BinaryHeap, просто для очереди.
    }

    @Override
    public void insert(int x) {
        qBHeap.insert(x);
        length++; // Дефолтный инсерт для очереди, только из-за струкутры BinaryHeap, мы присваиваем ему приоритет в соответствие с его ключом - O(log(n))
    }

    @Override
    public void increase(int x, int i) {
        qBHeap.increase(x, i);
    }

    public HeapPriorityQueue merge(HeapPriorityQueue a, HeapPriorityQueue b, Order qOrd) {
        BinaryHeap bHeap = new BinaryHeap(new int[Math.pow(2, ((a.length + b.length) / 2) + 1)], qOrd);
        HeapPriorityQueue result = new HeapPriorityQueue(bHeap);
        for (int i = 0; i < a.length; i++) {
            result.insert(a.qBHeap.value(i));
        }
        for (int i = 0; i < b.length; i++) {
            result.insert(b.qBHeap.value(i));
        }
        length = a.length + b.length;
        return result;
    }
}
