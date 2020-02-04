import java.util.*;
import java.lang.*;

class RottenOranges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            t -= 1;
            System.out.println(findMinTime(sc));
        }

    }

    public static int findMinTime(Scanner sc) {
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int arr[][] = new int[m][n];
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }

        int minTime = 0;

        while (!q.isEmpty()) {
            int l = q.size();
            boolean flag = false;

            while (l > 0) {
                l -= 1;
                Point p = q.poll();
                int curRow = p.r;
                int curCol = p.c;
                if (curRow >= 0 && curRow < m && curCol - 1 >= 0 && curCol < n && arr[curRow][curCol - 1] == 1) {
                    q.add(new Point(curRow, curCol - 1));
                    arr[curRow][curCol - 1] = 2;
                    flag = true;
                }

                if (curRow >= 0 && curRow < m && curCol + 1 >= 0 && curCol + 1 < n && arr[curRow][curCol + 1] == 1) {
                    q.add(new Point(curRow, curCol + 1));
                    arr[curRow][curCol + 1] = 2;
                    flag = true;
                }

                if (curRow - 1 >= 0 && curRow - 1 < m && curCol >= 0 && curCol < n && arr[curRow - 1][curCol] == 1) {
                    q.add(new Point(curRow - 1, curCol));
                    arr[curRow - 1][curCol] = 2;
                    flag = true;
                }

                if (curRow + 1 >= 0 && curRow + 1 < m && curCol >= 0 && curCol < n && arr[curRow + 1][curCol] == 1) {
                    q.add(new Point(curRow + 1, curCol));
                    arr[curRow + 1][curCol] = 2;
                    flag = true;
                }
            }
            if (flag)
                minTime += 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minTime;


    }
}

class Point {
    int r, c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}