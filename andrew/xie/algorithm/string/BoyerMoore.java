package andrew.xie.algorithm.string;

import java.util.Map;

public class BoyerMoore {
    private final int R;
    private String pattern;

    private int[] right; //256 alphabet dictionary, if letter in pattern == j, location of pattern letter

    public BoyerMoore(String pattern) {
        this.R = 256;
        this.pattern = pattern;

        // Initialize right to -1;
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }

        for (int j = 0; j < pattern.length(); j++) {
            right[pattern.charAt(j)] = j;
        }
    }

    public int search(String txt) {
        int m = pattern.length();
        int n = txt.length();

        int skip;
        for (int i = 0; i < n-m; i+=skip) {
            skip = 0;
            // 1. From right to left, find mismatch point d
            for (int j = m-1; j >=0 ; j--) {
                if(pattern.charAt(j) != txt.charAt(i+j)) {
                    // 2. If in pattern, move pattern by the distance of mismatch and potential match letter and compare
                    // 3. if not, shift pattern to after mismatch point
                    skip = Math.max(1, j-right[txt.charAt((i+j))]);
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return n;
    }
}
