import java.util.Scanner;

public class MergeSort {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t -= 1;
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            sort(arr, 0, n - 1);

            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            System.out.println(count);
        }
    }

    public static void sort(int arr[], int l, int r) {
        int m = (l + r) / 2;
        if (l < r) {
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int la[] = new int[n1];
        int ra[] = new int[n2];
        for (int i = l, q = 0; i <= m; i++, q++)
            la[q] = arr[i];
        for (int i = m+1, q = 0; i <= r; i++, q++)
            ra[q] = arr[i];
        int k = l;
        int x = 0;
        int y = 0;

        while (x < n1 && y < n2) {
            if (la[x] < ra[y]) {
                arr[k] = la[x];
                x++;
                k++;
            } else {
                count += n1-x;
                arr[k] = ra[y];
                k++;
                y++;
            }
        }

        while (x < n1) {
            arr[k++] = la[x++];
        }

        while (y < n2) {
            arr[k++] = ra[y++];
        }
    }
}
