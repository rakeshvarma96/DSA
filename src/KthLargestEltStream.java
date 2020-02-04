import java.util.Scanner;

public class KthLargestEltStream {
    public static int heapSize;
    public static int harr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t -= 1;
            int k = sc.nextInt();
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            letsFindKthsmallestElt(arr, n, k);
        }
    }

    public static void letsFindKthsmallestElt(int arr[], int n, int k) {
        heapSize = 0;
        harr = new int[k];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (heapSize < k) {
                insertElt(arr[i]);
                if(heapSize == k)
                    sb.append(harr[0] + " ");
                else
                    sb.append("-1 ");
            } else {
                if (harr[0] < arr[i]) {
                    harr[0] = arr[i];
                    heapify(0);
                }
                sb.append(harr[0] + " ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void insertElt(int val) {
        int i = heapSize;
        harr[i] = val;
        int parent = heapSize / 2;

        while (i != 0 && harr[parent] > harr[i]) {
            int temp = harr[parent];
            harr[parent] = harr[i];
            harr[i] = temp;
            i = parent;
            parent = parent / 2;
        }
        heapSize += 1;
    }

    public static void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < heapSize && harr[left] < harr[smallest])
            smallest = left;
        if (right < heapSize && harr[right] < harr[smallest])
            smallest = right;
        if (smallest != i) {
            int temp = harr[smallest];
            harr[smallest] = harr[i];
            harr[i] = temp;
            heapify(smallest);
        }
    }
}
