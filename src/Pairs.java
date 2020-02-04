import java.util.Arrays;
import java.util.Scanner;

public class Pairs {
    public static void main(String[] args) {
        /*int arr[] = {2,4,6,8,10};
        System.out.println(nextGreaterEltIndex(arr, 0, 4, 4));*/
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            t -= 1;
            int m = sc.nextInt();
            int n = sc.nextInt();
            int farr[] = new int[m];
            int sarr[] = new int[n];
            for(int i=0;i<m;i++)
                farr[i] = sc.nextInt();
            for(int i=0;i<n;i++)
                sarr[i] = sc.nextInt();

            Arrays.sort(sarr);
            int count = 0;
            for(int i=0;i<m;i++) {
                if(farr[i] == 1 || farr[i] == 0) {
                    continue;
                }
                if(sarr[0] == 1)
                    count ++;
                if(sarr[0] == 0)
                    count ++;
                int index = nextGreaterEltIndex(sarr, 0, n-1, farr[i]);
                System.out.println("Index: " + index);
                if(index == -1) {
                    continue;
                }
                if(farr[i] == sarr[index]) {
                    count = count + n-index-1;
                    if(farr[i] == 2 && index+1 < n && sarr[index+1] == 3) {
                        count = count - 1;
                    }
                    if(farr[i] == 2 && index+2 < n && sarr[index+2] == 4) {
                        count = count - 1;
                    }
                } else{
                    count = count + n-index;
                    if(farr[i] == 2 && sarr[index] == 3) {
                        count = count - 1;
                    }
                    if(farr[i] == 2 && index+1 < n && sarr[index+1] == 4) {
                        count = count - 1;
                    }
                }
                System.out.println("Iteration : " + count);
            }
            System.out.println(count);
        }
    }

    public static int nextGreaterEltIndex(int arr[], int l, int r, int key) {
        int m = (l+r)/2;
        if(l <= r) {
            if(arr[m] < key && arr[m+1] > key) {
                return m+1;
            } else if(arr[m] == key || (m>0 && arr[m-1] < key && key < arr[m])) {
                return m;
            } else if (arr[m] > key) {
                return nextGreaterEltIndex(arr, l, m-1, key);
            } else {
                return nextGreaterEltIndex(arr, m+1, r, key);
            }
        } else {
            if(key < arr[0]) {
                return 0;
            }
            return -1;
        }
    }
}
