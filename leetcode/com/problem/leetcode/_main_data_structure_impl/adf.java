package _main_data_structure_impl;

public class adf {
    private static void merge(Integer[] a, Integer[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if ((aux[j] < aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
