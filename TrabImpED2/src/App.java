import java.util.Scanner;

public class App {
    
    public static <T extends Comparable<T>> void main(String[] args) throws Exception
    {
        // example using Strings
        // String[]                 arrayOfStrings = {"Andree", "Leana", "Faviola", "Loyce", "Quincy", "Milo", "Jamila", "Toccara", "Nelda", "Blair", "Ernestine", "Chara", "Kareen", "Monty", "Rene", "Cami", "Winifred", "Tara", "Demetrice", "Azucena"};
        // MergeSortGeneric stringSorter = new MergeSortGeneric();
        // String[] arrayAuxOfStrings = new String[arrayOfStrings.length];
        // stringSorter.mergeSort(arrayOfStrings, arrayAuxOfStrings, 0, arrayOfStrings.length - 1);
        // stringSorter.mergeWithInsertion(arrayOfStrings, arrayAuxOfStrings, 0, arrayOfStrings.length - 1);
        // stringSorter.mergeAlreadySorted(arrayOfStrings, arrayAuxOfStrings, 0, arrayOfStrings.length - 1);
        // stringSorter.mergeSortWithNoCopy(arrayOfStrings, arrayAuxOfStrings, 0, arrayOfStrings.length - 1);
        // stringSorter.quickSortAnyPartitionLessThenL(arrayOfStrings, 0, arrayOfStrings.length - 1);
        // stringSorter.quickSortAllPartitionsLessThenL(arrayOfStrings, 0, arrayOfStrings.length - 1);
        // System.out.println(java.util.Arrays.toString(arrayOfStrings));

        // example using Doubles
        // Double[]                 arrayOfDoubles = {0.35, 0.02, 0.36, 0.82, 0.27, 0.49, 0.41, 0.17, 0.30, 0.89, 0.37, 0.66, 0.82, 0.17, 0.20, 0.96, 0.18, 0.25, 0.37, 0.52};
        // Double[] arrayAuxOfDoubles = new Double[arrayOfDoubles.length];
        // MergeSortGeneric doubleSorter = new MergeSortGeneric();
        // doubleSorter.mergeSort(arrayOfDoubles, arrayAuxOfDoubles, 0, arrayOfDoubles.length - 1);
        // doubleSorter.mergeWithInsertion(arrayOfDoubles, arrayAuxOfDoubles, 0, arrayOfDoubles.length - 1);
        // doubleSorter.mergeAlreadySorted(arrayOfDoubles, arrayAuxOfDoubles, 0, arrayOfDoubles.length - 1);
        // doubleSorter.mergeSortWithNoCopy(arrayOfDoubles, arrayAuxOfDoubles, 0, arrayOfDoubles.length - 1);
        // doubleSorter.quickSortAnyPartitionLessThenL(arrayOfDoubles, 0, arrayOfDoubles.length - 1);
        // doubleSorter.quickSortAllPartitionsLessThenL(arrayOfDoubles, 0, arrayOfDoubles.length - 1);
        // System.out.println(java.util.Arrays.toString(arrayOfDoubles));
        

        // doubleSorter.mergeSort(arrayOfDoubles, 0, arrayOfDoubles.length - 1);
        // System.out.println(java.util.Arrays.toString(arrayOfDoubles));

        Scanner input = new Scanner(System.in);

        T[] arrayData;

        while(true) {

            System.out.println("1 > Merge Sort Original\n2 > Merge Sort com Insertion Sort abaixo de 15 elementos\n3 > Merge Sort com teste se já está ordenado\n4 > Merge Sort sem cópia de valores do vetor auxiliar para o original\n5 > Quick Sort 1\n6 > Quick Sort 2\n7 > Sair do programa\n");


            int optionSortMethod = input.nextInt();
            if (optionSortMethod == 7) break;


            System.out.println("Escolha o tipo de dado a ser ordenado:\n\n1 > Tipo A - String(chave), Double(valor)\n2 > Tipo B - Double(chave), String(valor)\n3 > Tipo C - Integer(chave), Integer[](valor)\n4 > Sair do Programa\n");

            int optionTypeOfData = input.nextInt();
            if (optionTypeOfData == 4) break;

            System.out.println("Escolha o tamanho da quantidade de dados:\n1 > Pequeno\n2 > Médio\n3 > Grande\n4 > Sair do Programa\n");

            int optionSizeOfData = input.nextInt();
            if (optionSizeOfData == 4) break;


            arrayData = SelectedTypeOfSort.create( optionTypeOfData, optionSizeOfData);

            arrayData = MergeSortGeneric.chooseMethodType(arrayData, optionSortMethod);


            System.out.println("______ARRAY ORDENADO____\n\n");
            for (int i =0; i < arrayData.length - 1; i++) {
                System.out.println(arrayData[i].toString());
            }
        }

        input.close();
        System.out.println("Programa terminado.");


        
    }

    
}
