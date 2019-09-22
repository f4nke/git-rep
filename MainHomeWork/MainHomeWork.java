package MainHomeWork;

import java.util.Arrays;

public class MainHomeWork {



    public static int getMass(String a[][]) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;



        String[][] mass = new String[4][4];

        if(a.length != mass.length) {
            throw  new MyArraySizeException("Неверный размер массива");
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                try {

                    sum += Integer.parseInt(a[i][j]);


                }
                catch (NumberFormatException e) {

                    throw new MyArrayDataException("Не удается преобразование в ячейках", i, j);
                }

            }
        }
        return sum;

    }

    public static void main(String[] args) {

        String[][] mass = new String[][]{{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};





        try {
            try {
                int result =  getMass(mass);
                System.out.println(result);
            } catch
            (MyArraySizeException e) {
                System.out.println(e.getMessage());
            }
        }
        catch (MyArrayDataException r) {
            System.out.println(r.getMessage() + " " + r.i + "," + r.j);
        }

    }
}


