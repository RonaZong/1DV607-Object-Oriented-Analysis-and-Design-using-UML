package Model;

public class DateFormat {

        private int year;
        private int month;
        private int day;
        private char punctuation;
        private char format;

        public DateFormat(){
        }
        public DateFormat(int y,int m, int d,char p, char f){
            year = y;
            month = m;
            day = d;
            punctuation = p;
            format = f;
        }
        public void setYear(int y){
            year = y;
        }
        public void setMonth(int m){
            month = m;
        }
        public void setDay(int d){
            day = d;
        }
        public void setPunctuation(char p){
            punctuation = p;
        }
        public void setFormat(char f){
            format = f;
        }

        public String getDate(boolean fullYear){
            String stringYear = year + "";
            String stringMonth;
            if (month < 10){
                stringMonth = "0" + month;
            }
            else stringMonth = month + "";

            String stringDay;
            if (day < 10){
                stringDay = "0" + day;
            }
            else stringDay = day + "";

            if (year <= 1900 || year >= 2100 || month < 1 || month > 12 || day < 1 || day > 31){
                if (year <= 1900 || year >= 2100){
                    year = 0;
                }
                if (month < 1 || month > 12){
                    month = 0;
                }
                if (day < 1 || day > 31){
                    day = 0;
                }

                return "Invalid date";
            }

            //exercise 7
            else if (notValid(year,month,day)){
                return "Invalid date";
            }

            else {
                if (fullYear){
                    if (punctuation != '!'){
                        if (format == 'b'){
                            return stringYear + punctuation + stringMonth + punctuation + stringDay;
                        }
                        else if (format == 'l'){
                            return stringDay + punctuation + stringMonth + punctuation + stringYear;
                        }
                        else if (format == 'm'){
                            return stringMonth + punctuation + stringDay + punctuation + stringYear;
                        }
                        else return "Invalid input";
                    }
                    else {
                        if (format == 'b'){
                            return stringYear + stringMonth + stringDay;
                        }
                        else if (format == 'l'){
                            return stringDay + stringMonth + stringYear;
                        }
                        else if (format == 'm'){
                            return stringMonth + stringDay + stringYear;
                        }
                        else return "Invalid input";
                    }
                }
                else {
                    stringYear = stringYear.substring(2);
                    if (punctuation != '!'){
                        if (format == 'b'){
                            return stringYear + punctuation + stringMonth + punctuation + stringDay;
                        }
                        else if (format == 'l'){
                            return stringDay + punctuation + stringMonth + punctuation + stringYear;
                        }
                        else if (format == 'm'){
                            return stringMonth + punctuation + stringDay + punctuation + stringYear;
                        }
                        else return "Invalid input";
                    }
                    else {
                        if (format == 'b'){
                            return stringYear + stringMonth + stringDay;
                        }
                        else if (format == 'l'){
                            return stringDay + stringMonth + stringYear;
                        }
                        else if (format == 'm'){
                            return stringMonth + stringDay + stringYear;
                        }
                        else return "Invalid input";
                    }
                }
            }
        }

        //exercise 7
        public static boolean notValid(int year, int month, int day){
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                if (month == 2 && day > 29){
                    return true;
                }
                else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){
                    return true;
                }
                else
                    return false;
            }
            else {
                if (month == 2 && day > 28){
                    return true;
                }
                else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){
                    return true;
                }
                else
                    return false;
            }

        }



}
