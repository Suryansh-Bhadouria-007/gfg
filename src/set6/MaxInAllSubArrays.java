package set6;

import java.util.Scanner;

public class MaxInAllSubArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer testCases = Integer.parseInt(sc.nextLine());
        while (testCases-- > 0) {
            String line = sc.nextLine();
            String[] size_k = line.split(" ");
            Integer n = Integer.parseInt(size_k[0]);
            Integer k = Integer.parseInt(size_k[1]);
            int arr[] = new int[n];
            String values[] = sc.nextLine().split(" ");
            int i = 0;
            for (String val : values) {
                arr[i++] = Integer.parseInt(val);
            }
            printMax(arr, n, k);
        }
    }

    static void printMax(int arr[], int n, int k) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        int maxValues[] = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and
            second then update second  */
            else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third)
                third = arr[i];
        }

        maxValues[0] = first;
        int toCompare;
        for (int i = k; i < n; i++) {
            if (arr[i - k] == first) {

            } else if (arr[i - k] == second) {

            } else if (arr[i - k] == third) {
            }
        }
        for (int i : maxValues) {
            System.out.print(i + " ");
        }
    }


    static void print3largest(int arr[], int arr_size) {
        int i, first, second, third;

        /* There should be atleast two elements */
        if (arr_size < 3) {
            System.out.print(" Invalid Input ");
            return;
        }

        third = first = second = Integer.MIN_VALUE;
        for (i = 0; i < arr_size; i++) {
            /* If current element is smaller than
            first*/
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and
            second then update second  */
            else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third)
                third = arr[i];
        }

        System.out.println("Three largest elements are " +
                first + " " + second + " " + third);
    }
}
