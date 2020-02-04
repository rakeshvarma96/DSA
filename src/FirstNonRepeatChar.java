import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNonRepeatChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t>0)
        {
            t -= 1;
            int n = sc.nextInt();
            String s[] = new String[n];
            for(int i=0;i<n;i++)
                s[i] = sc.next();
            int temp[] = new int[26];
            Queue<String> q = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++) {
              if(!q.isEmpty()) {
                  if(temp[s[i].charAt(0) - 'a'] == 0) {
                      q.add(s[i]);
                      sb.append(q.peek()+" ");
                      temp[s[i].charAt(0) - 'a'] = 1;
                  } else {
                      q.remove(s[i]);
                      if(q.isEmpty())
                          sb.append("-1 ");
                      else
                          sb.append(q.peek()+" ");
                  }
              } else {
                  q.add(s[i]);
                  sb.append(s[i]+" ");
                  temp[s[i].charAt(0) - 'a'] = 1;
              }
            }
            System.out.println(sb.toString());
        }

    }
}
