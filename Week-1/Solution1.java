import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int t = sc.nextInt();
        int t = 2;
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            long n = sc.nextLong();
            result.append(isSpecial(n) ? "YES\n" : "NO\n");
        }

        System.out.print(result.toString());
        sc.close();
    }

    private static boolean isSpecial(long n) {
        if (n == 1) {
            return false; 
        }
        return (n % 2 == 0) && (n & (n - 1)) == 0; 
    }
}
