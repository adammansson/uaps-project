package pfk;

public class MergeSorter {
    public static void merge(int[] input, int[] helper, int first, int mid, int last) {
        // Copies the elements from input to helper
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

    public static void sort(int[] input, int[] helper, int first, int last) {
        if (first < last) {
            int mid = first + (last - first) / 2;
            sort(input, helper, first, mid);
            sort(input, helper, mid + 1, last);
            merge(input, helper, first, mid, last);
        }
    }
}
