package CoderLandGreedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Long C[] = new Long[N];
            Long L[] = new Long[N];
            String split[] = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                C[i] = Long.parseLong(split[i]);
            }
            split = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                L[i] = Long.parseLong(split[i]);
            }
            System.out.println(minCost(C, L, N));
        }

    }

    private static Long minCost(Long[] c, Long[] l, int n) {
        Long cost = 0l;
        Long minToLeftInclusiveCost[] = new Long[n];
        minToLeftInclusiveCost[0] = c[0];
        for (int i = 1; i < n; i++) {
            minToLeftInclusiveCost[i] = Math.min(minToLeftInclusiveCost[i - 1], c[i]);
        }
        for (int i = 0; i < n; i++) {
            cost += minToLeftInclusiveCost[i] * l[i];
        }
        return cost;
    }
}
