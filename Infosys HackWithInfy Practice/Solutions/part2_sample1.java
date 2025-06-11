import java.io.*;
// import java.util.*;

class part2_sample1 {

    static final long MOD = 1_000_000_007;

    public static void processQuery(long[] arr, long[] query) {
        int l = (int) query[0];
        int r = (int) query[1];
        long x = query[2];
        long y = query[3];

        for (int i = l; i <= r && i < arr.length; i++) {
            arr[i] = x + (i - l) * y;
        }
    }

    public static long sumArray(long[] arr) {
        long sum = 0;
        for (long val : arr) {
            sum = (sum + val) % MOD;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim()); // number of elements in arr[]
        long[] arr = new long[n];

        // String[] arrInput = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            // arr[i] = Long.parseLong(arrInput[i]);
            arr[i] = Long.parseLong(br.readLine().trim());
        }

        int q = Integer.parseInt(br.readLine().trim()); // number of rows in the query
        long[][] queries = new long[q][4];

        for (int i = 0; i < q; i++) {
            String[] queryLine = br.readLine().trim().split("\\s+");
            for (int j = 0; j < 4; j++) { // l, r, x, y for the ith query
                queries[i][j] = Long.parseLong(queryLine[j]);
            }
            processQuery(arr, queries[i]);
        }

        long sum = sumArray(arr);
        System.out.println(sum);
    }
}

