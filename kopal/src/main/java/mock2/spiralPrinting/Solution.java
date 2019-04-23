package mock2.spiralPrinting;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int a[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(spiralOrder(a));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrder = new ArrayList<>();
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            if (m == 1) {
                for (int i : matrix[0]) {
                    spiralOrder.add(i);
                }
            } else {
                int i, k = 0, l = 0;
                while (k < m && l < n) {
                    for (i = l; i < n; ++i) {
                        spiralOrder.add(matrix[k][i]);
                    }
                    k++;

                    for (i = k; i < m; ++i) {
                        spiralOrder.add(matrix[i][n - 1]);
                    }
                    n--;

                    if (k < m) {
                        for (i = n - 1; i >= l; --i) {
                            spiralOrder.add(matrix[m - 1][i]);
                        }
                        m--;
                    }

                    if (l < n) {
                        for (i = m - 1; i >= k; --i) {
                            spiralOrder.add(matrix[i][l]);
                        }
                        l++;
                    }
                }
            }
        }
        return spiralOrder;
    }
}