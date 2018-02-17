/*
 * Sort Process:
 * 5, 4, 3, 2, 1
 *    ^
 * 4, 5, 3, 2, 1
 *       ^
 * 4, 3, 5, 2, 1
 * 3, 4, 5, 2, 1
 *          ^
 * Sorted  | To be sorted
 */

package andrew.xie.algorithm.sort;

public class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if(less(a[j], a[j-1])) swap(a, j, j-1);
            }
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
        Integer[] arr = {5, 4, 3, 2, 1};
        sort(arr);
        printArray(arr);
    }
}
