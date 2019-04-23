package lazypay.susequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Integer N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            sb.append(br.readLine());
        }
        String sub = sb.toString();
        List<String> subs = new ArrayList<>();
        permute(sub, 0, sub.length() - 1, subs);
        int count = 0;
        for (String str : subs) {
            count += getCount(S, str);
        }
        System.out.println(count);
    }

    private static int getCount(String a, String b) {
        int m = a.length();
        int n = b.length();

        int lookup[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= n; ++i)
            lookup[0][i] = 0;

        for (int i = 0; i <= m; ++i)
            lookup[i][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1] +
                            lookup[i - 1][j];

                else
                    lookup[i][j] = lookup[i - 1][j];
            }
        }

        return lookup[m][n];
    }

    private static void permute(String str, int l, int r, List<String> subs) {
        if (l == r) {
            System.out.println(str);
            subs.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r, subs);
                str = swap(str, l, i);
            }
        }
    }


    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}