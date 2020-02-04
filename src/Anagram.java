import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            t --;
            String a = sc.next();
            String b = sc.next();
            if(a.length() != b.length()) {
                System.out.println("NO");
                continue;
            }
            String c[] = a.split("");
            String d[] = b.split("");
            Arrays.sort(c);
            Arrays.sort(d);
            String res = "YES";
            for(int i=0;i<c.length;i++) {
                if(!c[i].equals(d[i])) {
                    res = "NO";
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
