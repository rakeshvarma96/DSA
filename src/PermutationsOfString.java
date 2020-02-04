import java.util.*;
import java.lang.*;

class PermutationsOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t -= 1;
            String input = sc.next();
            findPermutations(input, 0, input.length() - 1);
            /*String inArr[] = input.split("");
            Arrays.sort(inArr);
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<inArr.length;i++)
                stringBuilder.append(inArr[i]);
            findPerm("", stringBuilder.toString());
            System.out.println(sb.toString());*/
        }
    }

    public static void findPermutations(String in, int l, int r) {
        if (l == r) {
            System.out.println(in);
            return ;
        }
        for (int i = l; i <= r; i++) {
            in = swap(in, l, i);
            findPermutations(in, l + 1, r);
            in = swap(in, l, i);
        }
    }


    public static String swap(String in, int l, int r) {
        String s[] = in.split("");
        String temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
        }
        return sb.toString();
    }
    public static StringBuilder sb = new StringBuilder();
    public static void findPerm(String prefix, String remaining) {
        int len = remaining.length();
        if(len == 0) {
            sb.append(prefix);
            sb.append(" ");
            return ;
        }
        for(int i=0;i<len;i++) {
            findPerm(prefix+ remaining.charAt(i),
                    remaining.substring(0, i) + remaining.substring(i+1, len));
        }
    }
}