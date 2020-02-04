import java.util.*;
import java.lang.*;

class RecursivelyRemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t -= 1;
            String res = removeDuplicates(sc.next());
            String prev = "";
            while(!res.equals(prev)) {
                prev = res;
                res = removeDuplicates(res);
            }
            System.out.println(res);
        }
    }

    public static String removeDuplicates(String in) {
        String[] given = in.split("");
        Stack<String> stk = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < given.length; i++) {
            if (!stk.isEmpty()) {
                String top = stk.peek();
                if (top.equals(given[i])) {
                    flag = true;
                    continue;
                }
                if (!top.equals(given[i]) && flag) {
                    stk.pop();
                    flag = false;
                    stk.push(given[i]);
                } else if (!top.equals(given[i]) && !flag) {
                    stk.push(given[i]);
                }
            } else {
                stk.push(given[i]);
            }
        }
        if (flag)
            stk.pop();
        StringBuilder sb = new StringBuilder();
        for (String s :
                stk) {
            sb.append(s);
        }
        return sb.toString();
    }
}