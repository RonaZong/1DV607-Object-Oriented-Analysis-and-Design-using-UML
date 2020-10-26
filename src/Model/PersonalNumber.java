package Model;

public class PersonalNumber {

        private DateFormat birthday = new DateFormat();
        private int checksum;
        private boolean valid;
        private String id;

        public PersonalNumber(){
        }
        public PersonalNumber(String id){
//            birthday.setYear(Integer.parseInt(id.substring(0,4)));
//            birthday.setMonth(Integer.parseInt(id.substring(4,6)));
//            birthday.setDay(Integer.parseInt(id.substring(6,8)));
//            birthday.setPunctuation('!');
//            birthday.setFormat('b');
//            checksum = Integer.parseInt(id.substring(9));
            this.id = id;
        }
        public String showID(){
            return birthday.getDate(true) + "-" + checksum;
        }
        public int getChecksum(){
            return checksum;
        }
//        public boolean isFemale(){
//            if (showID().charAt(11) % 2 == 1){
//                return false;
//            }
//            else {
//                return true;
//            }
//        }
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
        public boolean validID(){
            int ch2 = Integer.parseInt(showID().substring(2,3)) * 2;
            int ch3 = Integer.parseInt(showID().substring(3,4));
            int ch4 = Integer.parseInt(showID().substring(4,5)) * 2;
            int ch5 = Integer.parseInt(showID().substring(5,6));
            int ch6 = Integer.parseInt(showID().substring(6,7)) * 2;
            int ch7 = Integer.parseInt(showID().substring(7,8));
            int ch9 = Integer.parseInt(showID().substring(9,10)) * 2;
            int ch10 = Integer.parseInt(showID().substring(10,11));
            int ch11 = Integer.parseInt(showID().substring(11,12)) * 2;
            int sum = ch2 / 10 + ch2 % 10 + ch3 / 10 + ch3 % 10 + ch4 / 10 + ch4 % 10 + ch5 / 10 + ch5 % 10 + ch6 / 10 + ch6 % 10
                    + ch7 / 10 + ch7 % 10 + ch9 / 10 + ch9 % 10 + ch10 / 10 + ch10 % 10 + ch11 / 10 + ch11 % 10;
            int chech = (10 - sum % 10) % 10;

            if (checksum % 10 == chech){
                return true;
            }
            else
                return false;
        }


    public String getId() {
        return id;
    }
}
