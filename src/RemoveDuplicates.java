import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int t = sc.nextInt();
        while(t>0) {
            t --;
            char c[] = sc.next().toCharArray();
            boolean extra[] = new boolean[256];
            for(int i=0;i<c.length;i++) {
                if(!extra[c[i]]){
                    System.out.print(c[i]);
                    extra[c[i]] = true;
                }
            }
            System.out.println();
        }
    }
}
