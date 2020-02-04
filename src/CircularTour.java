public class CircularTour {
    public static void main(String[] args) {
        int petrol[] = new int[]{4, 6, 7, 4};
        int distance[] = new int[]{6, 5, 3, 5};
        System.out.println(tour(petrol, distance));
    }

    public static int tour(int petrol[], int distance[]) {
        int start = 0;
        int end = 1;
        int n = petrol.length;
        int cur = petrol[start] - distance[start];

        while (start != end || cur < 0) {
            while (cur < 0 && start != end) {
                cur -= petrol[start] - distance[start];
                start = (start + 1) % n;
                if (start == 0)
                    return -1;
            }
            cur += petrol[end] - distance[end];
            end = (end + 1) % n;
        }
        return start;
    }
}


