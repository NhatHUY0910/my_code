package bai_tap_interface;

public class InsertionSort implements Sort {
    @Override
    public void ascendingOrder(double[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            double key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public void descendingOrder(double[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            double key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
