package SubArrayAvgSumGreaterThanAvgOfRemaining;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        String inputArrayString[] = br.readLine().split(" ");
        Integer arr[] = new Integer[inputArrayString.length];
        List<Integer> collect = Arrays.asList(inputArrayString).stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
        arr = collect.toArray(arr);
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            double temp = 0;
            for (int j = i; j < N; j++) {
                temp += arr[j];
                if ((N - (j - i + 1) == 0) || (temp / (j - i + 1) > (sum - temp) / (N - (j - i + 1)))) {
                    count++;
                    sb.append((i + 1) + " " + (j + 1) + "\n");
                }
            }
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
