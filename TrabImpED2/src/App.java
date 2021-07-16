
public class App {
    
    public static void main(String[] args) throws Exception
    {
        // example using Strings
        String[]                 arrayOfStrings = {"Andree", "Leana", "Faviola", "Loyce", "Quincy", "Milo", "Jamila", "Toccara", "Nelda", "Blair", "Ernestine", "Chara", "Kareen", "Monty", "Rene", "Cami", "Winifred", "Tara", "Demetrice", "Azucena"};
        MergeSortGeneric stringSorter = new MergeSortGeneric();
        stringSorter.mergeSort(arrayOfStrings, 0, arrayOfStrings.length - 1);
        System.out.println(java.util.Arrays.toString(arrayOfStrings));

        // example using Doubles
        Double[]                 arrayOfDoubles = {0.35, 0.02, 0.36, 0.82, 0.27, 0.49, 0.41, 0.17, 0.30, 0.89, 0.37, 0.66, 0.82, 0.17, 0.20, 0.96, 0.18, 0.25, 0.37, 0.52};
        MergeSortGeneric doubleSorter = new MergeSortGeneric();
        doubleSorter.mergeAlreadySorted(arrayOfDoubles, 0, arrayOfDoubles.length - 1);
        System.out.println(java.util.Arrays.toString(arrayOfDoubles));
        

        // doubleSorter.mergeSort(arrayOfDoubles, 0, arrayOfDoubles.length - 1);
        // System.out.println(java.util.Arrays.toString(arrayOfDoubles));

        
    }

    
}
