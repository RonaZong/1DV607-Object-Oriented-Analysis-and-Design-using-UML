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

    public void saveFile(Member member) {
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
    }

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

        }
        return result;
    }

    public Iterable<Member> loadForVerboseList(String result){
        ArrayList<Member> members = new ArrayList<>();
        ArrayList<Boat> boats = new ArrayList<>();
        String[] eachLines = result.split("[\\r\\n]+");
        for (String lines: eachLines) {
            String[] parameters = lines.split(":");
            Member member = new Member(parameters[0],parameters[1]);
            member.setMemberID(parameters[2]);
            member.setNumbersOfBoatsOwnByAMember(Integer.parseInt(parameters[3]));
            for(int i = 4;i<parameters.length-1;i=i+2){
                member.registerNewBoat(BoatType.valueOf(parameters[i]),Float.parseFloat(parameters[i+1]));
            }
            members.add(member);
        }
        return members;
    }

    public Iterable<Member> loadForCompactList(String result){
        ArrayList<Member> members = new ArrayList<>();
        String[] eachLines = result.split("[\\r\\n]+");
        for (String lines: eachLines) {
            String[] parameters = lines.split(":");
            Member member = new Member(parameters[0],parameters[1]);
            member.setMemberID(parameters[2]);
            member.setNumbersOfBoatsOwnByAMember(Integer.parseInt(parameters[3]));
            members.add(member);
        }
        return members;
    }

    public void updateRegistryFile(BoatClub boatClub){
        ArrayList<Member> members = (ArrayList<Member>) boatClub.getAllMembersFromRegistry();
        File file = new File("VerboseList.txt");
        try {
            saver = new PrintWriter(file);
            for(Member member : members) {
                saver.print(member.getName() + ":" + member.getPersonalNumber() + ":"
                        + member.getMemberID() + ":" + member.numberOfBoats());
                for (Boat boat : member.boatsOwnedByMember())
                    saver.print(":" + boat.getType() + ":" + boat.getLength());
            }
            saver.println();
            saver.close();

        }catch(Exception e){

        }
    }

}
