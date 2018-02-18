/*
 * Exchange distance is reduced from h -> h/3 -> h/3/3 -> ... -> 1
 * Same for Insertion Sort
 * h starts < n/3
 */

package andrew.xie.algorithm.sort;

public class Shell {
    public static void sort(Comparable[] a) {
        int n = a.length;

        int h = 1;
        while(h < n/3) h = h*3 + 1;
        while(h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >=h ; j -=h) {
                    if(less(a[j], a[j-h]))
                        swap(a, j, j-h);
                }
            }

            h /= 3;
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable a[], int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void printArray(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 1, 7, 9, 8, 10, 12, 25, 17, 19};
        sort(arr);
        printArray(arr);
    }
}