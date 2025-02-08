import java.util.Scanner;

public class SolutionP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();  // Read the input
        sc.close();

        System.out.println(willVisit(n));  // Call the willVisit function
    }

    public static String willVisit(long n) {
        if (n == 1) {
            return "YES";  // If only one cup, always YES
        }

        int current = 0;
        boolean[] visited = new boolean[(int) n];  // Use int for the array size
        int count = 0;

        for (int k = 1; k <= n; k++) {
            current = (current + k) % (int) n;  // Calculate the next cup
            if (!visited[current]) {
                visited[current] = true;  // Mark as visited
                count++;
            } else {
                break;  // Exit early if we revisit a cup
            }
        }

        return count == n ? "YES" : "NO";  // Check if all cups are visited
    }
}
