package cli;

import algorithms.MaxHeap;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 50000};  // можно изменить
        Random rand = new Random();

        for (int n : sizes) {
            PerformanceTracker tracker = new PerformanceTracker();
            MaxHeap heap = new MaxHeap(n + 5, tracker);

            long start = System.nanoTime();
            for (int i = 0; i < n; i++) {
                heap.insert(rand.nextInt(n * 10));
            }
            long mid = System.nanoTime();
            // можно измерить extract тоже
            while (!heap.isEmpty()) {
                heap.extractMax();
            }
            long end = System.nanoTime();

            System.out.printf(
                    "n=%d, insertTime=%.3fms, totalTime=%.3fms, metrics: %s%n",
                    n,
                    (mid - start) / 1e6,
                    (end - start) / 1e6,
                    tracker.toString()
            );
        }
    }
}
