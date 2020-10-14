package Model;

import Util.BoatType;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Registry {
    private Scanner reader;
    private PrintWriter saver=null;


   /* public void saveFile(Member member) {
        File file = new File("VerboseList.txt");
        try {
            saver = new PrintWriter(new FileWriter(file,true));

            saver.print( member.getName() + ":" + member.getPersonalNumber() +":"
                    + member.getMemberID() + ":" + member.numberOfBoats());
            for(Boat boat:member.boatsOwnedByMember())
                saver.print(":" + boat.getType() + ":" + boat.getLength());
         saver.println();
            saver.close();

        }catch(Exception e){

        }
    }*/

    public String verboseList(String filePath){
        String result = "";
        try {
            reader = new Scanner(new File(filePath));
            result+=reader.nextLine()+"\n";
            while (reader.hasNextLine()){
              /* String thisLine = reader.nextLine();
               String[] parameters = thisLine.split(",");
               Member member = new Member(parameters[1], parameters[2]);
               member.setNumbersOfBoatsOwnByAMember(Integer.parseInt(parameters[3]));*/
                result+=reader.nextLine()+"\n";
            }
        }catch(Exception e){
            try {
                saver = new PrintWriter(new File(filePath));//if text file is not there this will make it first
            }catch (Exception ex){

            }
        }
        return result;
    }

    public Iterable<Member> loadFromSavedFile(String result){
        BoatClub boatClub = new BoatClub();
        ArrayList<Member> members = new ArrayList<>();
        String[] eachLines = result.split("[\\r\\n]+");//separate each line and put them in and array of string
        if(!eachLines[0].trim().isEmpty()){//In order to check if file is empty or not to not get error of index out boundary in line 62 (we have an array of length 1 which contains \\r\\n
           for (String lines : eachLines) {
               String[] parameters = lines.split(":");//separate each word and put them in an array
               Member member = boatClub.makeMemberForLoadingInStartOfProgram(parameters[0], parameters[1],parameters[2]);
               member.setNumbersOfBoatsOwnByAMember(Integer.parseInt(parameters[3]));
               for (int i = 4; i < parameters.length - 1; i = i + 2) {
                     member.registerANewBoat(new Boat(BoatType.valueOf(parameters[i]),Double.parseDouble(parameters[i+1])));
               }
               members.add(member);
             //  boatClub.setMembers(members);
           }
       }
        return members;
    }

    public void updateRegistryFile(BoatClub boatClub){
        File file = new File("SaveFile.txt");
        try {
            saver = new PrintWriter(file);
            for(Member member : boatClub.getAllMembersLocally()) {
                saver.print(member.getName() + ":" + member.getPersonalNumber() + ":"
                        + member.getMemberID() + ":" + member.numberOfBoats());
                for (Boat boat : member.boatsOwnedByMember()) {
                    saver.print(":" + boat.getType() + ":" + boat.getLength());
                }
                saver.println();
            }
            saver.close();

        }catch(Exception ignored) {

        }
    }
}
