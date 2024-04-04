package binary_search;

public class BinarySearchIterative {
    public static int calculateIterative(int[] arr, int numberLookFor) {
        int left = 0;
        int right = arr.length -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == numberLookFor) {
                return mid;
            }
            if (arr[mid] < numberLookFor) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
            return -1;
    }
}
