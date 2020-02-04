public class KmpAlgorithm {
    public static void main(String[] args) {
        String text[] = "AAAAAAAAAAAAAAAAAB".split("");
        String pattern[] = "AAAAB".split("");

        int lps[] = new int[pattern.length];
        int i = 1;
        int j = 0;
        lps[0] = 0;
        while (i < pattern.length) {
            if (pattern[i].equals(pattern[j])) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        for (int k = 0; k < pattern.length; k++) {
            System.out.print(lps[k] + " ");
        }
        System.out.println();
        int x = 0;
        int y = 0;
        while (x < text.length && y < pattern.length) {
            if (text[x].equals(pattern[y])) {
                x++;
                y++;
            } else {
                if (y != 0) {
                    y = lps[y - 1];
                }
            }
        }
        if (y == pattern.length) {
            System.out.println(x - pattern.length);
        }
    }
}
