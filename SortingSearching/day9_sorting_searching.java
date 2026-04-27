public class Day9SortingSearching {

    // 1. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n - 1; i++) {

            // Optimization: check if already sorted
            boolean swapped = false;

            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {

                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps, array is already sorted
            if(!swapped) break;
        }
    }

    // 2. Linear Search
    public static int linearSearch(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i; // return index
            }
        }
        return -1; // not found
    }

    // 3. Binary Search (array must be sorted)
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] == target) {
                return mid;
            } 
            else if(arr[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return -1; // not found
    }
}

/*
Day 9: Sorting & Searching

Algorithms:
1. Bubble Sort
2. Linear Search
3. Binary Search

Concepts:
- Sorting basics
- Sequential search
- Divide and conquer (binary search)

Time Complexity:
- Bubble Sort: O(n^2)
- Linear Search: O(n)
- Binary Search: O(log n)

Space Complexity: O(1)
*/
