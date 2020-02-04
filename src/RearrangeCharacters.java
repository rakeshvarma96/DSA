import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RearrangeCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            String cur = sc.next();
            rearrange(cur);
        }
    }

    public static StringInfo harr[];
    public static int heapSize;
    public static void rearrange(String str) {
        HashMap<String, StringInfo> hm = new HashMap<>();
        String s[] = str.split("");
        for (int i = 0; i < s.length; i++) {
            if (hm.containsKey(s[i])) {
                StringInfo sInfo = hm.get(s[i]);
                sInfo.freq = sInfo.freq + 1;
                hm.put(s[i], sInfo);
            } else {
                hm.put(s[i], new StringInfo(s[i], 1));
            }
        }
        int x = 0;
        harr = new StringInfo[hm.size()];
        for(Map.Entry<String, StringInfo> entry: hm.entrySet()) {
           harr[x++] = entry.getValue();
        }

        heapSize = harr.length;
        int longNonLeaf = harr.length / 2 + 1;

        for (int i = longNonLeaf; i >= 0; i--) {
            maxHeapify(harr, i);
        }

        StringInfo prev = new StringInfo("#",-1);
        String finalRes = "";
        while(heapSize > 0) {
            StringInfo cur = extractMax();
            finalRes += cur.a;

            if(prev.freq > 0) {
                insertKey(prev);
            }
            cur.freq -= 1;
            prev = cur;
        }

        if(finalRes.length() != str.length()) {
            System.out.println("Not a valid string");
        } else {
            System.out.println(finalRes);
        }

    }

    public static void deleteRoot() {
        if(heapSize <=0)
            return ;
        harr[0] = harr[heapSize-1];
        heapSize -= 1;
        maxHeapify(harr, 0);
    }

    public static void insertKey(StringInfo val) {
        int i= heapSize;
        harr[i] = val;
        int par = i/2;
        while(i != 0 && harr[par].freq < harr[i].freq) {
            StringInfo temp = harr[par];
            harr[par] = harr[i];
            harr[i] = temp;
            i = par;
            par = i/2;
        }
        heapSize += 1;
    }

    public static StringInfo extractMax() {
        if(heapSize <=0) {
            return null;
        }
        StringInfo res = harr[0];
        deleteRoot();
        return res;
    }
    public static void maxHeapify(StringInfo[] arr, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && arr[left].freq > arr[largest].freq)
            largest = left;
        if (right < heapSize && arr[right].freq > arr[largest].freq)
            largest = right;

        if (largest != i) {
            StringInfo temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, largest);
        }
    }

}

class StringInfo {
    String a;
    int freq;

    StringInfo(String a, int freq) {
        this.a = a;
        this.freq = freq;
    }
}
