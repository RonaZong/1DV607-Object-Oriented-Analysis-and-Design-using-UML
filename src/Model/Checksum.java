package Model;

import java.time.LocalDate;

public class Checksum {
    private ValidDigitForChecksum firstDigit;
    private ValidDigitForChecksum secondDigit;
    private ValidDigitForChecksum thirdDigit;
    private ValidDigitForChecksum fourthDigit;
    private int checksum;

    public Checksum(ValidDigitForChecksum firstDigit,ValidDigitForChecksum secondDigit,ValidDigitForChecksum thirdDigit,ValidDigitForChecksum fourthDigit){
        setFirstDigit(firstDigit);
        setSecondDigit(secondDigit);
        setThirdDigit(thirdDigit);
        setFourthDigit(fourthDigit);
    }
     public Checksum(int newNumber){
        setChecksum(newNumber);
     }

    private void setChecksum(int newNumber) {
        if(newNumber<0 || newNumber>9999)
            throw new IllegalArgumentException("Invalid personal number check last 4 digits");
        this.checksum = newNumber;
    }

    private void setFirstDigit(ValidDigitForChecksum firstDigit) {
        this.firstDigit = firstDigit;
    }

    private void setSecondDigit(ValidDigitForChecksum secondDigit) {
        this.secondDigit = secondDigit;
    }

    private void setThirdDigit(ValidDigitForChecksum thirdDigit) {
        this.thirdDigit = thirdDigit;
    }

    private void setFourthDigit(ValidDigitForChecksum fourthDigit) {
        this.fourthDigit = fourthDigit;
    }

    public String getChecksum(){
        return this.checksum+"";
    }

}
