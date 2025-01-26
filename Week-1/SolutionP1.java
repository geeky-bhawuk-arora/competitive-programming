import java.util.PriorityQueue;
import java.util.Scanner;

public class SolutionP1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int t = sc.nextInt();
        int t = 5;
        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(maxiScore(n));
        }
        sc.close();
    }

    public static long maxiScore(long n) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        maxHeap.add(n);

        long totalScore = 0;

        while (!maxHeap.isEmpty() && maxHeap.size() < n) {
            long largest = maxHeap.poll();

            long a = largest / 2;
            long b = largest - a;

            totalScore += a * b;

            maxHeap.add(a);
            maxHeap.add(b);
        }

        return totalScore;
    }
}
