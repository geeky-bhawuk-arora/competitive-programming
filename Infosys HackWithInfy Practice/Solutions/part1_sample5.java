import java.io.*;
import java.util.*;

class part1_sample5 {

    static class Cell {
        int row, col, time;
        Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int minTimeToInvade(char[][] grid) {
        Queue<Cell> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int enemyCnt = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'A') {
                    queue.offer(new Cell(i, j, 0));
                    visited[i][j] = true;
                } else if (grid[i][j] == 'E') {
                    enemyCnt++;
                }
            }
        }

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        int maxTime = 0;

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();

            for (int d = 0; d < 4; d++) {
                int newRow = curr.row + dRow[d];
                int newCol = curr.col + dCol[d];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    !visited[newRow][newCol] &&
                    grid[newRow][newCol] == 'E') {

                    visited[newRow][newCol] = true;
                    queue.offer(new Cell(newRow, newCol, curr.time + 1));
                    maxTime = Math.max(maxTime, curr.time + 1);
                    enemyCnt--;
                }
            }
        }

        return enemyCnt == 0 ? maxTime : -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim()); 
        int m = Integer.parseInt(br.readLine().trim());

        char[][] q = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            q[i] = line.toCharArray(); 
        }

        int minTime = minTimeToInvade(q);
        System.out.println(minTime);       
    }
}
