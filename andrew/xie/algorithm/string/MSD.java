package andrew.xie.algorithm.string;

public class MSD {
    private static final int R = 256; //ASCII
    public static void sort(String[]a) {
        int n = a.length;
        String[] aux = new String[n];
        sort(a, 0, n-1, 0, aux);
    }

    // Due to number of digits is undetermined, find out by build custom charAt function
    private static int charAt(String s, int d) {
        if (d == s.length()) return -1; //Deviate from book ??
        return s.charAt(d);
    }

    private static void sort(String[] a, int low, int high, int d, String[] aux) {

// Should implement cutoff to insertion sort when item to be sorted is low
//        if (hi <= lo + CUTOFF) {
//            insertion(a, lo, hi, d);
//            return;
//        }
        if(high <= low) return;

        int[] count = new int[R+2];

        // 1. Compute frequency
        for (int i = low; i <= high; i++) {
            int c = charAt(a[i], d);
            count[c+2]++;
        }


        // 2. Compute cumulates
        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];

        // 3. Move data to aux
        for (int i = low; i <= high; i++) {
            int c = charAt(a[i], d);
            aux[count[c+1]++] = a[i];
        }

        // 4. Copy back
        for (int i = low; i <= high; i++)
            a[i] = aux[i-low];


        // Recursively sort next digit
        for (int r = 0; r < R; r++) {
            sort(a, low + count[r], low + count[r+1] - 1, d+1, aux);
            System.out.println(d+1);
        }
    }

    public static void main(String[] args) {
        String a[] = {"bedddd", "bugddd", "dadadsf", "yesfsa", "zoodfc", "zoodfb", "zoodfa"};
        sort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
