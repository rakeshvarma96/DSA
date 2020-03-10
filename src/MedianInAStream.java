import java.util.Scanner;

public class MedianInAStream {
    static int maxHeap[];
    static int minHeap[];
    static int maxHeapSize, minHeapSize;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        maxHeap = new int[n / 2 + 1];
        minHeap = new int[n / 2 + 1];
        maxHeapSize = 0;
        minHeapSize = 0;
        while (n > 0) {
            int cur = sc.nextInt();
            if(maxHeapSize == 0 || (maxHeapSize > 0 && maxHeap[0] > cur))
                addToMaxHeap(cur);
            else
                addToMinHeap(cur);
            if(getSizeDiff()>1) {
                if(maxHeapSize>minHeapSize)
                    addToMinHeap(removeAndReturnFromMaxHeap());
                else
                    addToMaxHeap(removeAndReturnFromMinHeap());
            }
            if(minHeapSize == 0 && maxHeapSize == 1)
                System.out.println(maxHeap[0]);
            else if(maxHeapSize == minHeapSize)
                System.out.println((maxHeap[0]+minHeap[0])/2);
            else if(maxHeapSize > minHeapSize)
                System.out.println(maxHeap[0]);
            else
                System.out.println(minHeap[0]);
            n -= 1;
        }
    }

    public static void addToMaxHeap(int ele) {
        maxHeap[maxHeapSize] = ele;
        int temp = maxHeapSize;
        while (temp != 0 && maxHeap[temp] > maxHeap[temp / 2]) {
            int t = maxHeap[temp];
            maxHeap[temp] = maxHeap[temp / 2];
            maxHeap[temp / 2] = t;
            temp = temp / 2;
        }
        maxHeapSize += 1;
    }

    public static void addToMinHeap(int ele) {
        minHeap[minHeapSize] = ele;
        int temp = minHeapSize;
        while (temp != 0 && minHeap[temp] < minHeap[temp / 2]) {
            int t = minHeap[temp];
            minHeap[temp] = minHeap[temp / 2];
            minHeap[temp / 2] = t;
        }
        minHeapSize += 1;
    }

    public static int getSizeDiff() {
        return Math.abs(maxHeapSize - minHeapSize);
    }

    public static void maxHeapify(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < maxHeapSize && maxHeap[l] > maxHeap[largest])
            largest = l;
        if (r < maxHeapSize && maxHeap[r] > maxHeap[largest])
            largest = r;
        if(largest != i) {
            int temp = maxHeap[largest];
            maxHeap[largest] = maxHeap[i];
            maxHeap[i] = temp;
            maxHeapify(largest);
        }
    }
    public static void minHeapify(int i) {
        int l = 2*i+1;
        int r = 2*i+2;
        int smallest = i;
        if(l<minHeapSize && minHeap[l] < minHeap[smallest])
            smallest = l;
        if(r<minHeapSize && minHeap[r] < minHeap[smallest])
            smallest = r;
        if(smallest != i) {
            int temp = minHeap[smallest];
            minHeap[smallest] = minHeap[i];
            minHeap[i] = temp;
            minHeapify(smallest);
        }
    }
    public static int removeAndReturnFromMaxHeap() {
        int res = maxHeap[0];
        maxHeap[0] = maxHeap[maxHeapSize - 1];
        maxHeapSize -= 1;
        maxHeapify(0);
        return res;
    }
    public static int removeAndReturnFromMinHeap() {
        int res = minHeap[0];
        minHeap[0] = minHeap[minHeapSize - 1];
        minHeapSize -= 1;
        minHeapify(0);
        return res;
    }
}
