package Model;

import Util.Checksum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;


public class PersonalNumber {
    public enum DigitsForChecksum{
      DIGITS(new int[]{1,2,3,4,5,6,7,8,9,0});
      private int[] input;
      private DigitsForChecksum(int[] newInput){
          input = newInput;
      }
    }

       private LocalDate date;
    // private DateFormat birthday = new DateFormat();
       // private int checksum;
        private boolean valid;
        private String personalNumber;

        public PersonalNumber(){
        }
        public PersonalNumber(LocalDate newDate , DigitsForChecksum firsNum, ValidDigitForChecksum secondNum , ValidDigitForChecksum thirdNum , ValidDigitForChecksum forthNum){
           setDate(newDate);
            //date =LocalDate.parse(id.substring(0,8), DateTimeFormatter.BASIC_ISO_DATE);
           // setChecksum(id.substring(9));
           // checksum = Integer.parseInt(id.substring(9));
           // this.id = id;
        }
        public PersonalNumber(String dataFromRegistry){
            setPersonalNumber(dataFromRegistry);
        }

    private void setDate(LocalDate newDate) {
            this.date = newDate;
    }

    public void setPersonalNumber(String personalNumber) {
       // if(!validID(personalNumber)){
       //     throw new IllegalArgumentException("Invalid personal number");
       // }
        date =LocalDate.parse(personalNumber.substring(0,8), DateTimeFormatter.BASIC_ISO_DATE);
        this.personalNumber = personalNumber;
    }

    public String toString(){
            return this.personalNumber;
    }

   /* public String showID(){
            return date.toString() + checksum;
        }
        public int getChecksum(){
            return checksum;
        }*/

//        public int comparedTo(PersonalNumber otherID){
//            if (showID().substring(0,7).compareTo(otherID.showID().substring(0,7)) == 0)
//                return 0;
//            else if (showID().substring(0,7).compareTo(otherID.showID().substring(0,7)) > 0){
//                return 1;
//            }
//            else  {
//                return -1;
//            }
//        }
        public boolean validID(String personalNumber){
            if(personalNumber.length()!=12){
                throw new InputMismatchException("Check the length of your input");
            }
            int ch2 = Integer.parseInt(personalNumber.substring(2,3)) * 2;
            int ch3 = Integer.parseInt(personalNumber.substring(3,4));
            int ch4 = Integer.parseInt(personalNumber.substring(4,5)) * 2;
            int ch5 = Integer.parseInt(personalNumber.substring(5,6));
            int ch6 = Integer.parseInt(personalNumber.substring(6,7)) * 2;
            int ch7 = Integer.parseInt(personalNumber.substring(7,8));
            int ch9 = Integer.parseInt(personalNumber.substring(8,9)) * 2;
            int ch10 = Integer.parseInt(personalNumber.substring(9,10));
            int ch11 = Integer.parseInt(personalNumber.substring(10,11)) * 2;
            int sum = ch2 / 10 + ch2 % 10 + ch3 / 10 + ch3 % 10 + ch4 / 10 + ch4 % 10 + ch5 / 10 + ch5 % 10 + ch6 / 10 + ch6 % 10
                    + ch7 / 10 + ch7 % 10 + ch9 / 10 + ch9 % 10 + ch10 / 10 + ch10 % 10 + ch11 / 10 + ch11 % 10;
            int chech = (10 - sum % 10) % 10;
            int checksum = Integer.parseInt(personalNumber.substring(9));
            if (checksum % 10 == chech){
                return true;
            }
            else
                return false;
        }

    public int getyear(){
            return date.getYear();
    }

    public String getPersonalNumber() {
        return personalNumber;
    }
}
