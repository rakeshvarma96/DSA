import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RelativeSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            t--;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[m];
            for(int i=0;i<n;i++)
                a[i] = sc.nextInt();
            for(int i=0;i<m;i++)
                b[i] = sc.nextInt();
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            for(int i=0;i<n;i++) {
                if(tm.containsKey(a[i])) {
                    tm.put(a[i], tm.get(a[i])+1);
                } else {
                    tm.put(a[i], 1);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<m;i++) {
                if(tm.containsKey(b[i])) {
                    int count = tm.get(b[i]);
                    tm.remove(b[i]);
                    for(int j=0;j<count;j++)
                        sb.append(b[i]+" ");
                }
            }
            for(Map.Entry<Integer, Integer> entry: tm.entrySet()) {
                int count = entry.getValue();
                for(int i=0;i<count;i++)
                    sb.append(entry.getKey()+" ");
            }
            System.out.println(sb.toString());
        }
    }
}
