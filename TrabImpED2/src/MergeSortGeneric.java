public class MergeSortGeneric {
    
    // main function that sorts array[start..end] using merge()
    public static <T extends Comparable<T>> void mergeSort(T[] array, int start, int end)
    {
        // base case
        if (start < end)
        {
            // find the middle point
            int middle = (start + end) / 2;

            mergeSort(array, start, middle); // sort first half
            mergeSort(array, middle + 1, end);  // sort second half

            // merge the sorted halves
            merge(array, start, middle, end);
        }
    }

    // merges two subarrays of array[].
    private static <T extends Comparable<T>> void merge(T[] array, int start, int middle, int end)
    {
        T[] leftArray  = (T[]) new Comparable[middle - start + 1];
        T[] rightArray = (T[]) new Comparable[end - middle];

        // fill in left array
        for (int i = 0; i < leftArray.length; ++i)
            leftArray[i] = array[start + i];

        // fill in right array
        for (int i = 0; i < rightArray.length; ++i)
            rightArray[i] = array[middle + 1 + i];

        /* Merge the temp arrays */

        // initial indexes of first and second subarrays
        int leftIndex = 0, rightIndex = 0;

        // the index we will start at when adding the subarrays back into the main array
        int currentIndex = start;

        // compare each index of the subarrays adding the lowest value to the currentIndex
        while (leftIndex < leftArray.length && rightIndex < rightArray.length)
        {
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0)
            {
                array[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            }
            else
            {
                array[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }

        // copy remaining elements of leftArray[] if any
        while (leftIndex < leftArray.length) array[currentIndex++] = leftArray[leftIndex++];

        // copy remaining elements of rightArray[] if any
        while (rightIndex < rightArray.length) array[currentIndex++] = rightArray[rightIndex++];
    }

    public static <T extends Comparable<T>> void mergeWithInsertion (T[] array, int start, int end) {
    
        int sizeForInsertion = 15;

        //Merge Sort para vetores menores que 15
        if (end - start + 1 <= sizeForInsertion) {
            InsertionSort.insertionSort(array, start, end);
        }


        //Merge Sort
        if (start < end)
        {
            // find the middle point
            int middle = (start + end) / 2;

            mergeSort(array, start, middle); // sort first half
            mergeSort(array, middle + 1, end);  // sort second half

            // merge the sorted halves
            merge(array, start, middle, end);
        }

    }

    public static <T extends Comparable<T>> void mergeAlreadySorted (T[] array, int start, int end) {
        
        
        if (start < end)
        {
            // find the middle point
            int middle = (start + end) / 2;

            mergeAlreadySorted(array, start, middle); // sort first half
            mergeAlreadySorted(array, middle + 1, end);  // sort second half

            // merge the sorted halves
            if(array[middle].compareTo(array[middle+1]) <= 0){
                return;
            }
            merge(array, start, middle, end);
        }

    }

    public static <T extends Comparable<T>> void quickSort (T[] array, int start, int end) {
        int pivot, transitionToInsertion = 15;

        if (start < end) {
            
            pivot = partition(array, start, end);

            if(pivot - start <= transitionToInsertion ) {
                InsertionSort.insertionSort(array, start, pivot-1);
            } else {
                quickSort(array, start, pivot-1);
            }
            if(end - pivot <= transitionToInsertion) {
                InsertionSort.insertionSort(array,pivot+1, end);
            } else {
                quickSort(array, pivot+1 , end);
            }
        }

    }

    private static <T extends Comparable<T>> int partition(T[] array, int startIndex, int endIndex) {
        int pivotIndex = (startIndex + endIndex)/2;

        T pivot = array[pivotIndex];

        while (startIndex <= endIndex) {
            while (array[startIndex].compareTo(pivot) < 0 ){
                startIndex++;
            }

            if (startIndex >= endIndex) return endIndex;
        }

    }


}
