import java.util.*;
import java.lang.*;
class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            t -= 1;
            String a[] = sc.next().split("");
            String b[] = sc.next().split("");
            int res = letsCompare(a, b);
            System.out.println(res);

        }

    }


    public static int letsCompare(String a[], String b[]) {
        if (a.length != b.length) {
            return 0;
        }
        int x = 0;
        int y = 0;
        int n = a.length;
        int res = 1;
        while (x < n) {
            if (a[x].equals(b[y])) {
                x++;
                y++;
            } else {
                x++;
                y = 0;
            }
        }
        x = 0;
        while (y < n) {
            if (a[x].equals(b[y])) {
                x++;
                y++;
            } else {
                res = 0;
                break;
            }
        }
        return res;
    }
}