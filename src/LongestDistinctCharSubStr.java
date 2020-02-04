import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LongestDistinctCharSubStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t -= 1;
            String s[] = sc.next().split("");
            int res = findDistinctCharSubStr(s);
            System.out.println(res);
        }
    }

    public static int findDistinctCharSubStr(String s[]) {
        Queue<String> q = new LinkedList<>();
        int res = 0;
        for(int i=0;i<s.length;i++) {
            if(q.isEmpty()) {
                q.add(s[i]);
                res = Math.max(res, q.size());
                continue;
            }
            if(!q.contains(s[i]))
            {
                q.add(s[i]);
                res = Math.max(res, q.size());
            } else {
                while(!q.remove().equals(s[i])) {
                    // continue popping
                }
                q.add(s[i]);
                res = Math.max(q.size(), res);
            }
        }
        return res;
    }
}
