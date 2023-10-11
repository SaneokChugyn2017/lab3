package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"4900", "90", "107", "109"},
                {"113", "100", "90", "137"},
                {"139", "149", "6400", "157"},
                {"163", "167", "173", "12"}
        };

        try {
            System.out.println("Сумма чисел матрицы: " + method(array));
        }
        catch (MyArraySizeException | MyArrayDataException | MyPowException e){
                e.printStackTrace();
        }
    }
    public static int method(String[][] array) throws MyArraySizeException, MyArrayDataException, MyPowException {

        if(array.length != 4){
            throw new MyArraySizeException("Размер матрицы не 4x4!");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4){
                throw new MyArraySizeException("Размер матрицы не 4x4!");
            }
        }
        int number;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    number = Integer.parseInt(array[i][j]);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j,array[i][j]);
                }

                try {
                    if (array[i][j].length() == 6 && myPow(number))
                        throw new MyPowException(i, j, array[i][j]);
                } catch (MyPowException ee) {
                    ee.printStackTrace();
                }
            }

        }

        return sum;
    }
    public static boolean myPow(int number)
    {
        if (number >= 1000000 && number <= 9999999) {
            double squareRoot = Math.sqrt(number);
            double cubeRoot = Math.cbrt(number);

            if (squareRoot % 1 == 0 || cubeRoot % 1 == 0) {
                return false;
            }
        }

        return true;
    }

}