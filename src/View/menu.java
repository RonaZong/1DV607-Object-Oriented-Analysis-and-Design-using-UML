package View;

import Util.BoatType;

import java.util.Scanner;

public class menu {

    protected String userStringInput(){
        Scanner sc =new Scanner(System.in);
        return sc.nextLine();
    }


    protected BoatType correctBoatType(){
        boolean correctFormat=false;
        BoatType input = null ;
        do{
            try{
                input = BoatType.values()[Integer.parseInt(userStringInput())-1];
                correctFormat=true;
            }catch (NumberFormatException ex){
                System.out.println("Enter a number");
            }catch (ArrayIndexOutOfBoundsException ex){
                System.out.println("You have to choose between 1 to 4");
            }
        }while(!correctFormat);
        return input;

    }

    protected int correctInteger(){
        boolean correctFormat=false;
        int inputToInteger = 0;
        do{
            try{
                inputToInteger = Integer.parseInt(userStringInput());
                correctFormat=true;
            }catch (NumberFormatException ex){
                System.out.println("Enter a correct number");
            }
        }while(!correctFormat);
        return inputToInteger;
    }

    protected double correctDouble(){
        boolean isValid=false;
        double inputToDouble = 0;
        do{
            try{
                inputToDouble = Double.parseDouble(userStringInput());
                isValid = true;
            }catch (NumberFormatException ex){
                System.out.println("Enter a correct number");
            }
        }while(!isValid);
        return inputToDouble;
    }
}
