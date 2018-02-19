package andrew.xie.algorithm.string;

public class SubstringBrute {
    public static int search (String pattern, String txt) {
        int m = pattern.length();
        int n = txt.length();

        for (int i = 0; i <= n-m; i++) {
            int j;
            for (j = 0; j <m; j++) {
                // If not fit, break
                if(txt.charAt(i+j) != pattern.charAt(j)) break;
            }
            if (j == m) return i;
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        System.out.println(search("net", "internet"));
    }
}
