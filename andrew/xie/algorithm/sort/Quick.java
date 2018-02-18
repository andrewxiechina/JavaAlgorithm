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
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Quick {
    public static void sort(Comparable[] a) {
        // 1. Shuffle
        shuffleArray(a);

        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int low, int high) {
        if(low >= high) return;
        int j = partition(a, low, high);
        sort(a, low, j-1);
        sort(a, j+1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low; // pointer on left
        int j = high + 1; // pointer on right

        Comparable v = a[low];
        while (true) {
            while(less(a[++i], v)) {
                if (i == high) break;
            }

            while(less(v, a[--j])) {
                if (j == low) break;
            }

            if (i >= j) break;

            swap(a, i, j);
        }
        swap(a, low, j);
        return j;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable a[], int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void shuffleArray(Comparable[] a) {
        // Using Fisher-Yates shuffle
        Random rnd = ThreadLocalRandom.current();
        for (int i = 0; i < a.length - 1; i++) {
            swap(a, i, rnd.nextInt(i + 1));
        }
    }

    private static void printArray(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 3, 2, 1};
        //shuffleArray(arr);
        sort(arr);
        printArray(arr);
    }
}