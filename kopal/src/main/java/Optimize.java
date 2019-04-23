public class Optimize {
    public static void main(String[] args) {
        int N = 1000;
        original(N);
        optimize(N);
        optimize2(N);
    }

    private static void original(int N) {
        long cnt = 0;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if ((i * j) % k == 0) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println("org");
        System.out.println(cnt);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("__________________________________");
    }

    private static void optimize(int N) {
        long start = System.currentTimeMillis();
        long cnt = N * N;
        for (int k = 2; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i % k == 0) {
                    cnt += N;
                } else {
                    for (int j = 1; j <= N; j++) {
                        if ((i * j) % k == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println("opt");
        System.out.println(cnt);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("__________________________________");
    }

    private static void optimize2(int N) {
        long start = System.currentTimeMillis();
        long cnt = N * N;
        for (int k = 2; k <= N; k++) {
            int localCount = 0;
            for (int i = 2; i <= N; i++) {
                if (i == k || i % k == 0) {
                    localCount++;
                }
            }
            cnt += 2 * localCount;
        }
        System.out.println("opt 2");
        System.out.println(cnt);
        System.out.println(System.currentTimeMillis() - start);
    }

}
