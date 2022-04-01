package uaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] a;
        // DataSet.generate(1000);

        FileWriter outWriter = new FileWriter(args[1], false);
        outWriter.write("nbr, time in ns\n");

        for (int i = 1; i <= Integer.parseInt(args[2]); i++) {
            a = loadFromFile(args[0]);
            long t0 = System.nanoTime();

            // InsertionSorter.sort(a);
            int[] b = new int[a.length];
            MergeSorter.sort(a, b, 0, a.length - 1);

            long t1 = System.nanoTime();
            long timeTaken = t1 - t0;
            outWriter.write(i + ", " + timeTaken + "\n");
        }
        outWriter.close();
    }

    public static int[] loadFromFile(String filename) throws FileNotFoundException {
        File input = new File("../" + filename);
        Scanner inScanner = new Scanner(input);

        int[] arr = new int[1000];
        int i = 0;
        while (inScanner.hasNext()) {
            arr[i] = (Integer.parseInt(inScanner.nextLine()));
            i++;
        }
        return arr;
    }
}
