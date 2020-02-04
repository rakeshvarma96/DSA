import java.util.*;
import java.lang.*;

class MaxForAllSubArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            t -= 1;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            findMaxForEverySubArr(arr, k, n);

        }

    }


    public static void findMaxForEverySubArr(int arr[], int k, int n) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (!dq.isEmpty()) {
                while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                    dq.pollLast();
            }
            dq.add(i);
        }
        System.out.print(arr[dq.peekFirst()] + " ");
        for (int i = k; i < n; i++) {
            int cur = arr[i];
            while (!dq.isEmpty() && i - dq.peekFirst() >= k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[dq.peekLast()] < cur) {
                dq.pollLast();
            }
            dq.add(i);
            System.out.print(arr[dq.peekFirst()] + " ");
        }
        System.out.println();
    }
}