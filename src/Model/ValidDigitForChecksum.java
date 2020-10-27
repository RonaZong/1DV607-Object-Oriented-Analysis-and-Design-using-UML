package Model;

import java.util.InputMismatchException;

public class ValidDigitForChecksum {
    private int number;

    public ValidDigitForChecksum(int newNumber){
        setNumber(newNumber);
        }

    private void setNumber(int newNumber) {
        if(newNumber<0 || newNumber>9)
            throw new InputMismatchException("wrong input");

    }
}

