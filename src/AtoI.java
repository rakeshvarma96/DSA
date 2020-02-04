import java.util.Scanner;

public class AtoI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            t--;
            String s = sc.next();
            boolean flag = false;
            int n = 0;
            try {
                n = Integer.parseInt(s);
            } catch(Exception e) {
                flag = true;
            }
            if(flag)
                System.out.println(-1);
            else
                System.out.println(n);
        }
    }
}
