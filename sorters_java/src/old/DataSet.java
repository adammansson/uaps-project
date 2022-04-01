package old;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DataSet {
    public static void generate(int n) throws IOException {


        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        Collections.shuffle(list);

        FileWriter outWriter = new FileWriter("../small_data.txt", false);
        for (int i : list) {
            outWriter.write(i + "\n");
        }
        outWriter.close();
    }
}