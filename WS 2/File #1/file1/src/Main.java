package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Boat.boatType;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        Scanner scanner = new Scanner(System.in);
        Registry registry = new Registry();
        ArrayList<Member> memberArrayList = new ArrayList<Member>();


        int choice = -99;
        int memberID, pesonalNumber,typeInt;
        String firstName, lastName;
        Double boatLength;
        boatType type = null;

//        registry.reigstMember("A", "A", 1, 11111);
//        registry.reigstMember("b", "B", 2, 22222);
//        registry.reigstMember("c", "C", 3, 33333);
//        registry.reigstMember("d", "D", 4, 44444);
//        registry.reigstMember("E", "E", 5, 55555);

        registry.importData();
        

        while (choice != 0) {
            System.out.print("Enter your choice\n" + "\t 1- Add member\n" + "\t 2- Show Members in List\n" + "\t 3- Member options\n" + "\t 0- Exit\n" + "\n Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter member ID: ");
                    memberID = scanner.nextInt();
                    System.out.print("Enter Personal  Number: ");
                    pesonalNumber = scanner.nextInt();
                    System.out.print("Enter First Name: ");
                    firstName = scanner.next();
                    System.out.print("Enter Last Name: ");
                    lastName = scanner.next();
                    registry.reigstMember(firstName, lastName, memberID, pesonalNumber);
                    break;

                case 2:
                    memberArrayList = registry.getMemberList();
                    System.out.println("ID" + "\t|\t" + "Full name2");
                    for (Member m : memberArrayList) {
                        System.out.println(" " + m.getMemberID() + "\t|\t" + m.getfirstName() + " " + m.getLastName());
                    }
                    break;

                case 3:
                    System.out.print("Enter your choice\n" + "\t 1- Delete member\n"+ "\t 2- Update member\n" + "\t 3- Add boat\n"+ "\t 4- Delete boat\n" + "Your choice: ");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            memberArrayList = registry.getMemberList();
                            System.out.println("ID" + "\t|\t" + "Full name2");
                            for (Member m : memberArrayList) {
                                System.out.println(" " + m.getMemberID() + "\t|\t" + m.getfirstName() + " " + m.getLastName());
                            }
                            System.out.print("Member ID: ");
                            memberID = scanner.nextInt();
                            for (Member m:memberArrayList){
                                if (m.getMemberID()==memberID){
                                    registry.deletMamber(m);
                                    break;
                                }
                            }
                            break;
                        case 2:

                            memberArrayList = registry.getMemberList();
                            System.out.println("ID" + "\t|\t" + "Full name2");
                            for (Member m : memberArrayList) {
                                System.out.println(" " + m.getMemberID() + "\t|\t" + m.getfirstName() + " " + m.getLastName());
                            }

                            System.out.print("Select Member: ");
                            memberID = scanner.nextInt();
                            for (Member m:memberArrayList){
                                if (m.getMemberID()==memberID){
                                    System.out.print("Enter Personal  Number: ");
                                    pesonalNumber = scanner.nextInt();
                                    System.out.print("Enter First Name: ");
                                    firstName = scanner.next();
                                    System.out.print("Enter Last Name: ");
                                    lastName = scanner.next();
                                    registry.updateMamber(m,firstName,lastName,pesonalNumber);
                                    break;
                                }
                            }


                            break;
                        case 3:
                            memberArrayList = registry.getMemberList();
                            System.out.println("ID" + "\t|\t" + "Full name2");
                            for (Member m : memberArrayList) {
                                System.out.println(" " + m.getMemberID() + "\t|\t" + m.getfirstName() + " " + m.getLastName());
                            }

                            System.out.print("Add boat: ");
                            System.out.print("Select Member: ");
                            memberID = scanner.nextInt();
                            for (Member m:memberArrayList){
                                if (m.getMemberID()==memberID){
                                    System.out.print("Enter Boat length: ");
                                    boatLength = scanner.nextDouble();
                                    System.out.print("Enter Boat Type: ");
                                    System.out.println("1234");
                                    typeInt = scanner.nextInt();
                                    if(typeInt == 1)
                                    	type = boatType.Sailboat;
                                    else if(typeInt == 2)
                                    	type = boatType.Motorsailer;
                                    else if(typeInt == 3)
                                    	type = boatType.kayak_Canoe;
                                    else
                                    	type = boatType.Other;
                                    registry.addBoat(m,boatLength,type);
                                    break;
                                }
                            }




                            break;
                        case 4:
                            System.out.print("Delete boat: ");

                            break;
                    }
                    break;

                case 0:
                	registry.saveData();
                    break;

                default:
                    System.out.println("\nIncorect choice!\n");
            }
        }
        scanner.close();
    }

}
