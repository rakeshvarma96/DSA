import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

class MergeLL{
    static Node head;
    public static void addToTheLast(Node node) {
        if(head == null) {
            head = node;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public static void printList(Node node) {
        if(node == null) {
            return ;
        } else {
            while(node != null) {
                System.out.print(node.data+" ");
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0) {
            t -= 1;
            int N = sc.nextInt();
            Node a[] = new Node[N];
            for(int i=0;i<N;i++) {
                int n = sc.nextInt();
                int p = sc.nextInt();
                Node start = null;
                Node cur = null;
                Node head = new Node(p);
                start = head;
                cur = head;
                for(int j=1;j<n;j++) {
                    int a1 = sc.nextInt();
                    Node ptr = new Node(a1);
                    cur.next = ptr;
                    cur = ptr;
                }
                a[i] = start;
            }
            Node start = a[0];
            MergeSortedKLists g = new MergeSortedKLists();
            Node res = g.mergeKList(a, N);
            if(res != null)
                printList(res);
            System.out.println();
        }
    }
}

class MergeSortedKLists
{
    NodeInfo harr[];
    int heapSize;
    Node mergeKList(Node[]a,int N)
    {
        harr = new NodeInfo[N];
        heapSize = N;
        int resSize = 0;
        for(int i=0;i<N;i++) {
            harr[i] = new NodeInfo(a[i].data, i, a[i].next);
            resSize += getSize(a[i]);
        }
        buildHeap();
        int finalRes[] = new int[resSize];
        for(int i=0;i<resSize;i++) {
            System.out.println("0******** "+harr[0].ele+"*************");
            System.out.println("1******** "+harr[1].ele+"*************");
            finalRes[i] = harr[0].ele;
            Node next = harr[0].next;
            if(next != null) {
                harr[0] = new NodeInfo(next.data, harr[0].arrIndex, next.next);
            } else {
                harr[0] = new NodeInfo(Integer.MAX_VALUE, harr[0].arrIndex, null);
            }
            minHeapify(0);
        }

        Node finalHead = new Node(finalRes[0]);
        Node temp = finalHead;
        for(int i=1;i<resSize;i++) {
            temp.next = new Node(finalRes[i]);
            temp = temp.next;
        }
        return finalHead;
    }

    void buildHeap() {
        int longNonLeaf = harr.length/2;
        for(int i=longNonLeaf;i>=0;i--) {
            minHeapify(i);
        }
    }

    void minHeapify(int i) {
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i + 2;

        if(left<heapSize && harr[left].ele < harr[smallest].ele)
            smallest = left;
        if(right<heapSize && harr[right].ele < harr[smallest].ele)
            smallest = right;
        if(smallest != i) {
            NodeInfo temp = harr[smallest];
            harr[smallest] = harr[i];
            harr[i] = temp;

            minHeapify(smallest);
        }
    }

    int getSize(Node cur) {
        int res = 0;
        while(cur != null) {
            res += 1;
            cur = cur.next;
        }
        return res;
    }
}

class NodeInfo {
    int ele, arrIndex;
    Node next;
    NodeInfo(int a, int b, Node c) {
        this.ele = a;
        this.arrIndex = b;
        this.next = c;
    }
}
