import java.io.*;
import java.util.*;

class part1_sample8 {


    static int minJumps(int n, int start, int end, int[] arr) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> steps = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        steps.add(0);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            int step = steps.poll();
            
            if(curr == end) return steps;

            int jump = arr[curr];

            int right = (curr + jump) % n;
            if(!visited[right]) {
                visited[right] = true;
                queue.add(right);
            }

            int left = (curr - jump + n) % n;
            if(!visited[left]) {
                visited[left] = true;
                queue.add(left);
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim()); // number of people playing the game

        int x = Integer.parseInt(br.readLine().trim()); // chair on which Bob is seated

        int y = Integer.parseInt(br.readLine().trim()); // chair which Bob wants to reach

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim()); // number of chairs the person can jump
        }

        minJumps(n, x, y, arr)
        System.out.println(1); 
    }
}
