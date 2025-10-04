package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxHeapTest {

    @Test
    public void testInsertExtractSimple() {
        PerformanceTracker t = new PerformanceTracker();
        MaxHeap h = new MaxHeap(10, t);

        h.insert(5);
        h.insert(2);
        h.insert(8);
        h.insert(1);

        assertEquals(8, h.extractMax());
        assertEquals(5, h.extractMax());
        assertEquals(2, h.extractMax());
        assertEquals(1, h.extractMax());
        assertTrue(h.isEmpty());
    }

    @Test
    public void testIncreaseKey() {
        PerformanceTracker t = new PerformanceTracker();
        MaxHeap h = new MaxHeap(10, t);

        h.insert(3);
        h.insert(6);
        h.insert(1);

        // уменьшать нельзя, но увеличим индекс 2 (value 1) до 10
        h.increaseKey(2, 10);
        assertEquals(10, h.extractMax());
    }

    @Test
    public void testPeekMax() {
        PerformanceTracker t = new PerformanceTracker();
        MaxHeap h = new MaxHeap(5, t);
        h.insert(7);
        assertEquals(7, h.peekMax());
    }

    @Test
    public void testMerge() {
        PerformanceTracker t1 = new PerformanceTracker();
        MaxHeap h1 = new MaxHeap(10, t1);
        h1.insert(5);
        h1.insert(9);

        PerformanceTracker t2 = new PerformanceTracker();
        MaxHeap h2 = new MaxHeap(10, t2);
        h2.insert(7);
        h2.insert(2);

        h1.merge(h2);
        // после слияния максимальный должен быть 9
        assertEquals(9, h1.extractMax());
        assertEquals(7, h1.extractMax());
        assertEquals(5, h1.extractMax());
        assertEquals(2, h1.extractMax());
        assertTrue(h1.isEmpty());
    }
}
