/*
 *  Sorts a sequence of strings from standard input using Selection sort.
 *	S O R T E X A M P L E
 *	  ^
 *	It keeps sorted part on left and unsorted part on right
 *	It keeps an index pointing to the position of 1st unsorted
 *	It select smallest from the unsorted and swap with the element pointed to
 */

package andrew.xie.algorithm.sort;

public class MergeBU {
    public static void sort(Comparable[] a) {
        int n = a.length;
        Integer[] aux = new Integer[a.length];

        for (int i = 1; i < n; i*=2) {
            for (int j = 0; j + i < n; j+=2*i) {
                merge(a, aux, j, j+i-1,Math.min(j+i+i-1, n-1));
            }
        }
    }

    private static void merge(Comparable[]a, Comparable[] aux, int low, int mid, int high) {
        int left = low;
        int right = mid+1;

        // Copy a to aux
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }

        // Two fingered approach
        for (int i = low; i <= high; i++) {
            if(left > mid) a[i] = aux[right++];
            else if(right > high) a[i] = aux[left++];
            else if (less(aux[left], aux[right])) a[i] = aux[left++];
            else a[i] = aux[right++];
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
        Integer[] arr2 = {1, 3, 5, 7, 2, 4, 6, 8};
        Integer[] aux2 = new Integer[8];
        merge(arr2, aux2, 0, 3, 7);
        printArray(arr2);
        Integer[] arr = {5, 4, 3, 2, 1, 7, 9, 8, 10};
        sort(arr);
        printArray(arr);
    }
}
