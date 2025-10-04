package algorithms;

import metrics.PerformanceTracker;

public class MaxHeap {
    private int[] heap;
    private int size;
    private final PerformanceTracker tracker;

    public MaxHeap(int capacity, PerformanceTracker tracker) {
        heap = new int[capacity];
        size = 0;
        this.tracker = tracker;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        tracker.incrementSwaps();
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
        tracker.incrementArrayAccess();
        tracker.incrementArrayAccess();
    }

    public void insert(int value) {
        if (size == heap.length) {
            throw new RuntimeException("Heap overflow");
        }
        heap[size] = value;
        tracker.incrementArrayAccess();
        int cur = size;
        size++;

        while (cur > 0) {
            int p = parent(cur);
            tracker.incrementComparisons();
            if (heap[p] < heap[cur]) {
                swap(cur, p);
                cur = p;
            } else {
                break;
            }
        }
    }

    public int extractMax() {
        if (size == 0) {
            throw new RuntimeException("Heap underflow");
        }
        if (size == 1) {
            size--;
            tracker.incrementArrayAccess();
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        tracker.incrementArrayAccess();
        size--;
        maxHeapify(0);
        return root;
    }

    private void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l < size) {
            tracker.incrementComparisons();
            if (heap[l] > heap[largest]) {
                largest = l;
            }
        }

        if (r < size) {
            tracker.incrementComparisons();
            if (heap[r] > heap[largest]) {
                largest = r;
            }
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public void increaseKey(int index, int newValue) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        tracker.incrementArrayAccess();
        if (newValue < heap[index]) {
            throw new IllegalArgumentException("New key is smaller than current");
        }
        heap[index] = newValue;
        tracker.incrementArrayAccess();

        while (index > 0) {
            int p = parent(index);
            tracker.incrementComparisons();
            if (heap[p] < heap[index]) {
                swap(index, p);
                index = p;
            } else {
                break;
            }
        }
    }

    public void merge(MaxHeap other) {
        for (int i = 0; i < other.size; i++) {
            tracker.incrementArrayAccess();
            insert(other.heap[i]);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peekMax() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        tracker.incrementArrayAccess();
        return heap[0];
    }
}
