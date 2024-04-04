package binary_search;

public class BinarySearchRecursive {
    public static int calculateRecursive(int[] arr, int left, int right, int numberLookFor) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == numberLookFor) {
                return mid;
            }
            if (arr[mid] < numberLookFor) {
                return calculateRecursive(arr, mid + 1, right, numberLookFor);
            } else {
                return calculateRecursive(arr, left, mid - 1, numberLookFor);
            }
        }
            return -1;
    }
}
