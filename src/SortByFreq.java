import java.util.*;

public class SortByFreq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            FreqSortUtil(arr);
            /*HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (hm.containsKey(arr[i])) {
                    hm.put(arr[i], hm.get(arr[i]) + 1);
                } else {
                    hm.put(arr[i], 1);
                }
            }
            TreeMap<Integer, TreeSet<Integer>> tm = new TreeMap<>();
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                if (tm.containsKey(entry.getValue())) {
                    TreeSet temp = tm.get(entry.getValue());
                    temp.add(entry.getKey());
                    tm.put(entry.getValue(), temp);
                } else {
                    TreeSet ts = new TreeSet();
                    ts.add(entry.getKey());
                    tm.put(entry.getValue(), ts);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, TreeSet<Integer>> e : tm.entrySet()) {
                TreeSet temp = e.getValue();
                int key = e.getKey();
                Iterator<Integer> itr = temp.descendingIterator();
                while (itr.hasNext()) {
                    int cur = itr.next();
                    for(int i=0;i<key;i++)
                        sb.append(cur + " ");
                }
            }
            System.out.println(reverseString(sb.toString().trim()));*/
        }
    }
    public static String reverseString(String s) {
        String sArr[] = s.split(" ");
        int l = 0;
        int r = sArr.length-1;
        while(l<r) {
            String temp = sArr[l];
            sArr[l] = sArr[r];
            sArr[r] = temp;
            l++;
            r--;
        }
        return String.join(" ", sArr);
    }

    public static void FreqSortUtil(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            int val = hm.getOrDefault(arr[i], 0);
            hm.put(arr[i], val+1);
            list.add(arr[i]);
        }
        SortComparator sortComparator = new SortComparator(hm);
        Collections.sort(list, sortComparator);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

}
