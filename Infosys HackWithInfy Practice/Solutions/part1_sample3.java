import java.io.*;
// import java.util.*;

class part1_sample3 {

    public static long getOptimumOilLevel(long[] arr, long capacity) {
        long oil = 0;
        long minOil = 0;
        long maxOil = 0;

        for(int i = 0; i < arr.length; i++) {
            oil += arr[i];
            minOil = Math.min(minOil, oil);
            maxOil = Math.max(maxOil, oil);
        }
        
        long minX = - minOil;
        long maxX = capacity - maxOil;

        if(minX > maxX) {
            return -1;
        } else {
            return minX;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        long n = Long.parseLong(br.readLine().trim()); // number of elements in arr[]

        long c = Long.parseLong(br.readLine().trim()); // tank capacity

        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine().trim());
        }

        long optimumLevel = getOptimumOilLevel(arr, c);
        System.out.println(optimumLevel);
    }
}
