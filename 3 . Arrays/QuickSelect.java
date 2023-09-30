import java.util.Random;

public class QuickSelect {

    public static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partition(arr, left, right);
        
        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int randomPivot = new Random().nextInt(right - left + 1) + left;
        swap(arr, randomPivot, right);
        int pivot = arr[right];
        int i = left - 1;
        
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2; // Find the 3rd smallest element

        int result = quickSelect(arr, 0, arr.length - 1, k);
        System.out.println("The " + (k + 1) + "th smallest element is: " + result);
    }
}





/*The provided Java code defines a class named `QuickSelect` that implements the QuickSelect algorithm, which is a variation of the QuickSort algorithm used to find the kth smallest (or largest) element in an unsorted array efficiently. Here's a description of the code:

1. `quickSelect` Method:
   - This method takes as input an integer array `arr`, two indices `left` and `right` representing the current range of elements to consider, and an integer `k` representing the rank of the element to find (e.g., 0 for the smallest element, 1 for the second smallest, and so on).
   - It recursively selects a pivot element and partitions the array such that elements smaller than the pivot are on the left, and elements greater than or equal to the pivot are on the right.
   - If the pivot's index `pivotIndex` is equal to `k`, it returns the element at that index as it has found the kth smallest element.
   - If `k` is less than `pivotIndex`, it recursively calls `quickSelect` on the left subarray (elements before the pivot).
   - If `k` is greater than `pivotIndex`, it recursively calls `quickSelect` on the right subarray (elements after the pivot).

2. `partition` Method:
   - This method is responsible for selecting a pivot element and rearranging the elements in the array so that elements smaller than the pivot are on the left, and elements greater than or equal to the pivot are on the right.
   - It chooses a random pivot element within the given range.
   - It uses a two-pointer approach where `i` starts at `left - 1`, and a loop iterates through the elements from `left` to `right - 1`.
   - If an element is smaller than the pivot, it swaps it with the element at `i + 1` and increments `i`.
   - Finally, it swaps the pivot element with the element at `i + 1`, ensuring that the pivot is in its correct position, and returns the index `i + 1` as the new pivot index.

3. `swap` Method:
   - This is a simple utility method that swaps two elements in an integer array.

4. `main` Method:
   - In the `main` method, an example integer array `arr` containing unsorted elements `{3, 2, 1, 5, 6, 4}` is provided, and the goal is to find the 3rd smallest element (k = 2).
   - The `quickSelect` method is called with the appropriate arguments, and the result is printed to the console, indicating the kth smallest element. In this case, it will print "The 3rd smallest element is: 3".*/
