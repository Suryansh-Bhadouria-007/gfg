package MAR_14_2019;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class GCDProblem {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        Integer size = n;
        List<Integer> result = new ArrayList<>();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = size--;
        }
        Set<Integer> primes = sieveOfEratosthenes(n);
        Set<Integer> toExclude = new HashSet<>();
        for (int elem : arr) {
            if (!toExclude.contains(elem)) {
                if (!primes.contains(elem)) {
                    List<Integer> withGCDNE1 = getSortedListOfNumbersWithGCDNE1(elem, toExclude);
                    toExclude.addAll(withGCDNE1);
                    toExclude.add(elem);
                    result.add(elem);
                    result.addAll(withGCDNE1);
                } else if (primes.contains(elem)) {
                    result.add(elem);
                }
            }
        }
        result.stream().map(elem -> elem + " ").forEach(System.out::print);
    }


    private static List<Integer> getSortedListOfNumbersWithGCDNE1(int top, Set<Integer> toExclude) {
        List<Integer> res = new ArrayList<>();
        int[] primeFactors = getPrimeFactors(top);
        int primeFacOffset[] = new int[primeFactors.length];
        for (int i = 0; i < primeFactors.length; i++) {
            primeFacOffset[i] = (top / primeFactors[i]) - 1;
        }
        while (checkIfAnyIndexIsNotZero(primeFacOffset)) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int i = 0; i < primeFactors.length; i++) {
                if (max < (primeFactors[i] * primeFacOffset[i])) {
                    max = primeFactors[i] * primeFacOffset[i];
                    maxIndex = i;
                }
            }
            if (maxIndex >= 0){
                if (!toExclude.contains(max)) {
                    toExclude.add(max);
                    res.add(max);
                }
                primeFacOffset[maxIndex] -= 1;
            }
        }
        return res;
    }

    private static boolean checkIfAnyIndexIsNotZero(int[] primeFacOffset) {
        for (int i : primeFacOffset) {
            if (i != 0)
                return true;
        }
        return false;
    }

    private static int[] getPrimeFactors(int n) {
        Set<Integer> primeFactors = new HashSet<>();
        while (n % 2 == 0) {
            primeFactors.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }
        if (n > 2)
            primeFactors.add(n);
        int arr[] = new int[primeFactors.size()];
        int k = 0;
        for (int i : primeFactors) {
            arr[k++] = i;
        }
        return arr;
    }


    static Set<Integer> sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        Set<Integer> primes = new HashSet<>();
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                primes.add(i);
        }
        return primes;
    }


    private static boolean checkPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
