package uaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sort {
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void merge(int[] input, int[] helper, int first, int mid, int last) {
        for (int i = first; i <= last; i++) {
            helper[i] = input[i];
        }

        int inFirst = first;
        int inSecond = mid + 1;
        for (int inNew = first; inNew <= last; inNew++) {
            if (inFirst > mid) {
                input[inNew] = helper[inSecond];
                inSecond++;
            }

            else if (inSecond > last) {
                input[inNew] = helper[inFirst];
                inFirst++;
            }

            else {
                if (helper[inFirst] < helper[inSecond]) {
                    input[inNew] = helper[inFirst];
                    inFirst++;
                }

                else {
                    input[inNew] = helper[inSecond];
                    inSecond++;
                }
            }
        }
    }

    public static void mergeSort(int[] input, int[] helper, int first, int last) {
        if (first < last) {
            int mid = first + (last - first) / 2;
            mergeSort(input, helper, first, mid);
            mergeSort(input, helper, mid + 1, last);
            merge(input, helper, first, mid, last);
        }
    }

    public static int[] loadFromFile(String fileName) throws FileNotFoundException {
        File input = new File(fileName);
        Scanner inScanner = new Scanner(input);

        int[] arr = new int[100000];
        int i = 0;
        while (inScanner.hasNext()) {
            arr[i] = (Integer.parseInt(inScanner.nextLine()));
            i++;
        }
        inScanner.close();
        return arr;
    }

    public static void main(String[] args) throws IOException {
        FileWriter outWriter = new FileWriter(args[1], false);
        outWriter.write("nbr, time in s\n");

        for (int i = 1; i <= Integer.parseInt(args[2]); i++) {
            int[] a = loadFromFile(args[0]);
            long t0 = System.nanoTime();

            // insertionSort(a);
            int[] b = new int[a.length];
            mergeSort(a, b, 0, a.length - 1);

            long t1 = System.nanoTime();
            double timeTaken = (t1 - t0) / 1e9;
            outWriter.write(i + ", " + timeTaken + "\n");
        }
        outWriter.close();
    }
}
