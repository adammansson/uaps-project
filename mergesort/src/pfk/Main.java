package pfk;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] a = DataSet.generate(10000);
        int[] b = new int[a.length];
        MergeSorter.sort(a, b, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
