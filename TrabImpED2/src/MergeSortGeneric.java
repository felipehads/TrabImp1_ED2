public class MergeSortGeneric {

    public static <T extends Comparable<T>> T[] chooseMethodType(T[] array, int method) {
        
        

        T[] arrayAux = (T[]) new Comparable[array.length];

        if (method == 1) {
            mergeSort(array, arrayAux, 0, (array.length-1));
            
        }
        
        if (method == 2) {
            mergeWithInsertion(array, arrayAux, 0, (array.length-1));
        }

        if (method == 3) {
            mergeAlreadySorted(array, arrayAux, 0, (array.length-1));
        }

        if (method == 4) {
            mergeSortWithNoCopy(array, arrayAux, 0, (array.length-1));
        }

        if (method == 5) {
            quickSortAnyPartitionLessThenL(array, 0, (array.length-1));
        }

        if (method == 6) {
            quickSortAllPartitionsLessThenL(array, 0, (array.length-1));
        }

        return array;
        

    }
    
    // main function that sorts array[start..end] using merge()
    public static <T extends Comparable<T>> T[] mergeSort(T[] array, T[] arrayAux, int start, int end)
    {
        // base case
        if (start < end)
        {
            // find the middle point
            int middle = (start + end) / 2;

            mergeSort(array, arrayAux, start, middle); // sort first half
            mergeSort(array, arrayAux, middle + 1, end);  // sort second half

            // merge the sorted halves
            merge(array, arrayAux, start, middle+1, end);
        }

        return array;

    }

    // merges two subarrays of array[].
    private static <T extends Comparable<T>> void merge(T[] array, T[] arrayAux, int leftIndex, int rightIndex, int end)
    {
        int leftEnd = rightIndex - 1;
        int auxIndex = leftIndex;
        int arraySize = end - leftIndex + 1;


        while (leftIndex <= leftEnd && rightIndex <= end) {

            if(array[leftIndex].compareTo(array[rightIndex]) <= 0) {
                arrayAux[auxIndex++] = array[leftIndex++];
            } else {
                arrayAux[auxIndex++] = array[rightIndex++];
            }
        }

        while (leftIndex <= leftEnd) {
            arrayAux[auxIndex++] = array[leftIndex++];
        }

        while (rightIndex <= end) {
            arrayAux[auxIndex++] = array[rightIndex++];
        }

        for (int i = 0; i < arraySize; i++, end--) {
            array[end] = arrayAux[end];
        }
        
    }

    public static <T extends Comparable<T>> T[] mergeWithInsertion (T[] array, T[] arrayAux, int start, int end) {
    
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

            mergeWithInsertion(array, arrayAux, start, middle); // sort first half
            mergeWithInsertion(array, arrayAux, middle + 1, end);  // sort second half

            // merge the sorted halves
            merge(array, arrayAux, start, middle+1, end);
        }

        return array;

    }

    public static <T extends Comparable<T>> T[] mergeAlreadySorted (T[] array, T[] arrayAux, int start, int end) {
        
        
        if (start < end)
        {
            // find the middle point
            int middle = (start + end) / 2;

            mergeAlreadySorted(array, arrayAux, start, middle); // sort first half
            mergeAlreadySorted(array, arrayAux, middle + 1, end);  // sort second half

            // merge the sorted halves
            if(array[middle].compareTo(array[middle+1]) <= 0){
                return array;
            }
            merge(array, arrayAux, start, middle+1, end);
        }
        return array;

    }

    public static <T extends Comparable<T>> T[] mergeSortWithNoCopy(T[] array, T[] arrayAux, int start, int end)
    {


        // base case
        if (start < end)
        {
            // find the middle point
            int middle = (start + end) / 2;

            mergeSortWithNoCopy(array, arrayAux, start, middle); // sort first half
            mergeSortWithNoCopy(array, arrayAux, middle + 1, end);  // sort second half

            // merge the sorted halves
            mergeWithNoCopy(array, arrayAux, start, middle+1, end);
            mergeWithNoCopy(arrayAux, array, start, middle+1, end);
        }
        
        return arrayAux;
        
    }
    
    // merges two subarrays of array[].
    private static <T extends Comparable<T>> void mergeWithNoCopy(T[] array, T[] arrayAux, int leftIndex, int rightIndex, int end)
    {
        int leftEnd = rightIndex - 1;
        int auxIndex = leftIndex;
        
        
        while (leftIndex <= leftEnd && rightIndex <= end) {
            
            if(array[leftIndex].compareTo(array[rightIndex]) <= 0) {
                arrayAux[auxIndex++] = array[leftIndex++];
            } else {
                arrayAux[auxIndex++] = array[rightIndex++];
            }
        }
        
        while (leftIndex <= leftEnd) {
            arrayAux[auxIndex++] = array[leftIndex++];
        }
        
        while (rightIndex <= end) {
            arrayAux[auxIndex++] = array[rightIndex++];
        }
        
        
    }


    public static <T extends Comparable<T>> void quickSortAnyPartitionLessThenL (T[] array, int start, int end) {
        int pivot, transitionToInsertion = 15;

        if (start < end) {
            
            pivot = partition(array, start, end);

            if(pivot - start <= transitionToInsertion ) {
                InsertionSort.insertionSort(array, start, pivot-1);
            } else {
                quickSortAnyPartitionLessThenL(array, start, pivot-1);
            }
            if(end - pivot <= transitionToInsertion) {
                InsertionSort.insertionSort(array,pivot+1, end);
            } else {
                quickSortAnyPartitionLessThenL(array, pivot+1 , end);
            }
        }

    }

    private static <T extends Comparable<T>> int partition(T[] array, int startIndex, int endIndex) {
        int pivotIndex = (startIndex + endIndex)/2;
        int iterator = startIndex;

        // T pivot = array[pivotIndex];

        while (iterator <= endIndex) {
            if (array[iterator].compareTo(array[pivotIndex]) < 0) {
                T aux = array[startIndex];
                array[startIndex] = array[iterator];
                array[iterator] = aux;
                startIndex++;
            }
            iterator++;
        }

        T aux2 = array[startIndex];
        array[startIndex] = array[pivotIndex];
        array[pivotIndex] = aux2;

        return startIndex;

    }

    public static <T extends Comparable<T>> void quickSortAllPartitionsLessThenL (T[] array, int start, int end) {
        int pivot, transitionToInsertion = 15;

        if (start < end) {
            
            pivot = partition(array, start, end);

            if(pivot - start <= transitionToInsertion && end - pivot <= transitionToInsertion) {
                InsertionSort.insertionSort(array, start, pivot-1);
                InsertionSort.insertionSort(array,pivot+1, end);
            } 
            if (pivot - start >= transitionToInsertion) {
                quickSortAllPartitionsLessThenL(array, start, pivot-1);
            }
            if (end - pivot >= transitionToInsertion) {
                quickSortAllPartitionsLessThenL(array, pivot+1 , end);

            }
            
        }
    }

}



