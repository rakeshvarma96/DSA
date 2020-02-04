import java.util.*;
import java.lang.*;

class LongestCommonSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            t -= 1;
            String a = sc.next();
            String b = findReverse(a);
            System.out.println(b);
            int n = a.length() - 1;
            System.out.println(findLongCommSubString(a, b, n, n, 0));
        }

    }

    public static int findLongCommSubString(String a, String b, int m, int n, int count) {
        if(m<0 || n<0) {
            return count;
        }
        if(a.charAt(m) == b.charAt(n)) {
            count = findLongCommSubString(a, b, m-1, n-1, count+1);
        }
        count = Math.max(Math.max(findLongCommSubString(a,b,m,n-1,0),
                    findLongCommSubString(a,b,m-1,n, 0)), count);
        return count;
    }

    public static String findReverse(String given) {
        String s[] = given.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--)
            sb.append(s[i]);
        return sb.toString();
    }
}
