// Line Trip
// https://codeforces.com/problemset/problem/1901/A

import java.util.*;
import java.util.Scanner;

public class LineTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // int t = scanner.nextInt(); // Number of test cases
        int t = 3;
        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of gas stations
            int x = scanner.nextInt(); // Destination point
            
            int[] stations = new int[n + 2]; // Include 0 and x as "virtual" stations
            stations[0] = 0; // Start at 0
            stations[n + 1] = x; // End at x
            
            for (int i = 1; i <= n; i++) {
                stations[i] = scanner.nextInt(); // Gas station positions
            }
            
            // Sort the stations array
            Arrays.sort(stations);
            
            // Calculate the maximum gap between consecutive stations
            int maxGap = 0;
            for (int i = 1; i < stations.length; i++) {
                maxGap = Math.max(maxGap, stations[i] - stations[i - 1]);
            }
            
            // The minimum tank size required is half of the maximum gap (rounded up)
            int minTankSize = (maxGap + 1) / 2;
            
            // Output the result for the current test case
            System.out.println(minTankSize);
        }
        
        scanner.close();
    }
}
