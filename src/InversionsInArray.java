import java.util.Scanner;

public class InversionsInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int res = letsDo(arr, n);
        System.out.println(res);
    }
    public static int letsDo(int arr[], int n) {
        int count = 0;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j] > arr[i]) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
