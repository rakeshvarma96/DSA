import java.util.HashMap;
import java.util.Scanner;

public class LargestZeroSumSubArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t -= 1;
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            HashMap<Integer, Integer> hm = new HashMap<>();
            int curSum = 0;
            int curMaxLen = 0;
            for (int i = 0; i < n; i++) {
                curSum += arr[i];
                if(curSum == 0) {
                    curMaxLen = i+1;
                    continue;
                }
                if(hm.containsKey(curSum)) {
                    curMaxLen = Math.max(curMaxLen, i-hm.get(curSum));
                } else {
                    hm.put(curSum, i);
                }
            }
            System.out.println(curMaxLen);
        }
    }
}
