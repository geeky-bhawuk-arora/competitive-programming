import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int t = sc.nextInt();  
        int t = 2;
        while (t-- > 0) {
            String n = sc.next();  
            System.out.println(getDigitalRoot(n));
        }
        sc.close();
    }

    private static int getDigitalRoot(String n) {
        while (n.length() > 1) {
            int sum = 0;
            for (char digit : n.toCharArray()) {
                sum += digit - '0';  
            }
            n = String.valueOf(sum);  
        }
        return Integer.parseInt(n);  
    }
}
