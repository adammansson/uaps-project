package uaps;

import java.io.FileWriter;
import java.io.IOException;

public class DataSet {
    public static void generate(int n) throws IOException {
        int[] a = new int[n];

        FileWriter outWriter = new FileWriter("../data1.txt", false);
        for (int i = 0; i < a.length; i++) {
            int randNbr = (int) (Math.floor(Math.random() * 100000) + 1);
            a[i] = randNbr;
            outWriter.write(randNbr + "\n");
        }
        outWriter.close();
    }
}
