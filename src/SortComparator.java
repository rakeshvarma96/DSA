import java.util.Comparator;
import java.util.HashMap;

public class SortComparator implements Comparator<Integer> {
    HashMap<Integer, Integer> freqMap;
    SortComparator(HashMap<Integer, Integer> hm) {
        this.freqMap = hm;
    }
    @Override
    public int compare(Integer a, Integer b) {
        int freqCompare = freqMap.get(b).compareTo(freqMap.get(a));
        int valCompare = a.compareTo(b);
        if(freqCompare == 0) {
            return valCompare;
        } else {
            return freqCompare;
        }
    }
}
