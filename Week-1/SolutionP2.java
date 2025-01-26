import java.util.Scanner;

public class SolutionP2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of cups

        System.out.println(willVisitAllCups(n) ? "YES" : "NO");
    }

    public static boolean willVisitAllCups(int n) {
        // The fly will visit all cups if GCD(n, k) is 1 for any k

        if (n == 1) {
            return true;
        }

        for (int k = 1; k < n; k++) {
            if (gcd(n, k) == 1) {
                return true;
            }
        }
        return false;
    }

    // Helper function to calculate GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}