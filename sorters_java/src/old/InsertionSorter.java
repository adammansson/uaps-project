package old;

public class InsertionSorter {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // storing the value that is being sorted
            int key = arr[i];

            // the index of current predecessor
            int j = i - 1;

            // moving element one spot to the right if it's bigger than the element that we are sorting
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // inserting the value that is being sorted at its correct index
            arr[j + 1] = key;
        }
    }
}
