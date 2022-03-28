package pfk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("../data1.txt");
        Scanner inScanner = new Scanner(input);
        LinkedList<Integer> list = new LinkedList<Integer>();
        while (inScanner.hasNext()) {
            list.add(Integer.parseInt(inScanner.nextLine()));
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        InsertionSorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
