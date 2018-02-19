package andrew.xie.algorithm.string;

public class LSD {

    public static void sort(String[]a, int w) {
        int n = a.length;
        int R = 256; // ASCII alphabet size
        String[] aux = new String[n];

        for (int d = w-1; d >= 0; d--) {
            // Sort every digit, from left to right

            // Key-indexed counting
            // 1. Compute frequency
            int[] count = new int[R+1];
            for (int i = 0; i < n; i++)
                count[a[i].charAt(d)+1]++;

            // 2. Compute cumulates
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // 3. Move data to aux
            for (int i = 0; i < n; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            // 4. Copy back
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
        }

    }

    public static void main(String[] args) {
        String a[] = {"bed", "bug", "dad", "yes", "zoo"};
        int l = a[0].length();
        sort(a, l);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
