/*
 *  Sorts a sequence of strings from standard input using Selection sort.
 *	S O R T E X A M P L E
 *	  ^
 *	It keeps sorted part on left and unsorted part on right
 *	It keeps an index pointing to the position of 1st unsorted
 *	It select smallest from the unsorted and swap with the element pointed to
 */

package andrew.xie.algorithm.sort;

public class Selection {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if(less(a[j], a[min])) swap(a, j, min);
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
