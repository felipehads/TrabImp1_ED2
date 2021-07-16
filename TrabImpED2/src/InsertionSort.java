public class InsertionSort {
    
    static <T extends Comparable<T>> void insertionSort(T[] array, int start, int end) {

        int i, j;
        T key;

        for (i = start + 1; i <= end; i++) {

            key = array[i];
            j = i - 1;


            while (j >= start && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = key;

        }
    }

}
