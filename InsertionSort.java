class InsertionSort {

    // Function to perform insertion sort
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
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
        InsertionSort sorter = new InsertionSort();
        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Original array:");
        sorter.printArray(arr);

        sorter.sort(arr);

        System.out.println("Sorted array:");
        sorter.printArray(arr);
    }
}
