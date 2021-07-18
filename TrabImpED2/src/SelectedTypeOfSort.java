import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class SelectedTypeOfSort {
    
    private static final int small = 50;
    private static final int medium = 50000;
    private static final int big = 300000;

    public static <T extends Comparable<T>> T[] create(int type, int size) {

        int sizeOfIntArrayInTypeC = 30;

        if(size == 1) size = small;
        else if (size == 2) size = medium;
        else size = big;


        String directory = System.getProperty("user.dir");


        System.out.println(directory);

        String choosed_data_path = "";

        if (directory.contains("src")) {
            choosed_data_path = "../";
        }



        if (type == 1) choosed_data_path += "data/string_double.csv";
        else if (type == 2) choosed_data_path += "data/double_string.csv";
        else choosed_data_path += "data/int_intarr.csv";

        File inputDataFile = new File(choosed_data_path);

        T[] selectedElements;
        if (type == 1) selectedElements = (T[]) new TipoA[size];
        else if (type == 2) selectedElements = (T[]) new TipoB[size];
        else selectedElements = (T[]) new TipoC[size];


        if(inputDataFile.canRead()) {

            Scanner inputData;

            try {

                inputData = new Scanner(inputDataFile).useDelimiter("\\,|\\n");
                inputData.useLocale(Locale.US);
                int sizeIndex = 0;

                try {

                    while (inputData.hasNext() && sizeIndex < size) {
                        if (type == 1) {
                            String key = inputData.next();
                            Double value = inputData.nextDouble();
                            selectedElements[sizeIndex] = (T) new TipoA(key, value);
                        }
                        else if (type == 2) {
                            Double key = inputData.nextDouble();
                            String value = inputData.next();
                            selectedElements[sizeIndex] = (T) new TipoB(key, value);
                        }
                        else {
                            int key = inputData.nextInt();
                            int[] value = new int[sizeOfIntArrayInTypeC];
                            for (int i = 0; i < sizeOfIntArrayInTypeC; i++) {
                                value[i] = inputData.nextInt();
                            }
                            selectedElements[sizeIndex] =  (T) new TipoC(key, value);
                        }
                        sizeIndex++;
                    }
                    inputData.close();
                    return selectedElements;
                } catch(Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Problema com arquivo.");
        }

        return null;
    }

    

}
