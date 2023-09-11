package app;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    static double[] arr = getPricesArray();
    static int n = arr.length;
    static double sum = 0;
    static double average;

    public static void main(String[] args) {
        getSortedData(arr);
        calculateAverage(arr);
    }

    private static double[] getPricesArray() {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        System.out.print("Enter the number of days during which price changes were observed: ");
        int n = sc.nextInt();
        double[] arr = new double[n];

        System.out.println("Enter the price for each day, with a space: ");
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextDouble();
        return arr;
    }

    private static void getSortedData(double[] arr) {

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < (n - i - 1); ++j) {

                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted prices in increasing order (by bubble sort):");
        for (int i = 0; i < n; ++i) {
            System.out.println(arr[i] + " ");
        }
    }

    private static void calculateAverage(double[] arr) {

        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
        }
        average = sum / arr.length;
        System.out.printf("%nAverage price per period: %.2f%n", average);
    }
}
