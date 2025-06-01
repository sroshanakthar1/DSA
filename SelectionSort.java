class SelectionSort {

    // Function to perform Selection Sort
    public void sort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Utility function to print the array
    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSort sorter = new SelectionSort();
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original array:");
        sorter.printArray(arr);

        sorter.sort(arr);

        System.out.println("Sorted array:");
        sorter.printArray(arr);
    }
}
