package org.example;

public class MyPowException extends RuntimeException{

    public MyPowException(int i, int j, String value){
        super("В матрице в строке [" + (i+1) + "] в столбце ["+ (j+1) +"] находится: " + value);
    }
}
