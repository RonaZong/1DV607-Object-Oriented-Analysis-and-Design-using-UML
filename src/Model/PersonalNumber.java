package Model;

import javax.swing.text.DateFormatter;
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
    private String birthDate;
    private String personalNumber;
    private Checksum checksum;

        public PersonalNumber(){
        }
        public PersonalNumber(LocalDate newDate , Checksum checksum){
           setDate(newDate);
           setChecksum(checksum);
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
        this.personalNumber = personalNumber;
    }

   /* public String toString(){
            return this.personalNumber;
    }*/

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
        public boolean validChecksum(){
            String birth = date.format(DateTimeFormatter.BASIC_ISO_DATE);
            int ch2 = Integer.parseInt(birth.substring(2,3)) * 2;
            int ch3 = Integer.parseInt(birth.substring(3,4));
            int ch4 = Integer.parseInt(birth.substring(4,5)) * 2;
            int ch5 = Integer.parseInt(birth.substring(5,6));
            int ch6 = Integer.parseInt(birth.substring(6,7)) * 2;
            int ch7 = Integer.parseInt(birth.substring(7,8));
            int ch9 = Integer.parseInt(checksum.getChecksum().substring(0,1)) * 2;
            int ch10 = Integer.parseInt(checksum.getChecksum().substring(1,2));
            int ch11 = Integer.parseInt(checksum.getChecksum().substring(2,3)) * 2;
            int sum = ch2 / 10 + ch2 % 10 + ch3 / 10 + ch3 % 10 + ch4 / 10 + ch4 % 10 + ch5 / 10 + ch5 % 10 + ch6 / 10 + ch6 % 10
                    + ch7 / 10 + ch7 % 10 + ch9 / 10 + ch9 % 10 + ch10 / 10 + ch10 % 10 + ch11 / 10 + ch11 % 10;
            int chech = (10 - sum % 10) % 10;
            int checksum1 = Integer.parseInt(checksum.getChecksum().substring(3));
            if (checksum1 % 10 == chech){
                return true;
            }
            else
                return false;
        }
    private void setChecksum(Checksum checksum) {

        this.checksum = checksum;
        if(!validChecksum())
            throw new IllegalArgumentException("Invalid Personal number");
    }

    public int getyear(){
            return date.getYear();
    }

    public String getBirthDate() {
        return date.format(DateTimeFormatter.BASIC_ISO_DATE);
    }

//    public String getString(){
//            return personalNumber;
//    }

    public String getPersonalNumber(){
            return date.format(DateTimeFormatter.BASIC_ISO_DATE) + checksum.getChecksum();
    }
}
