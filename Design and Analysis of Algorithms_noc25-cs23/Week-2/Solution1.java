import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] singers = new int[N][3]; 

        for (int i = 0; i < N; i++) {
            singers[i][0] = sc.nextInt(); 
            singers[i][1] = sc.nextInt(); 
            singers[i][2] = i; 
        }

        Arrays.sort(singers, Comparator.comparingInt(a -> a[0]));

        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[singers[i][2]] = 2 * i;
        }

        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}
