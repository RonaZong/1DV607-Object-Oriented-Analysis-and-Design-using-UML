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

    public ArrayList<Member> loadForVerboseList(String result){
        BoatClub boatClub = new BoatClub();
        ArrayList<Member> members = new ArrayList<>();
        String[] eachLines = result.split("[\\r\\n]+");
        for (String lines: eachLines) {
            String[] parameters = lines.split(":");
            Member member = new Member(parameters[0],parameters[1]);
            member.setMemberID(parameters[2]);
            member.setNumbersOfBoatsOwnByAMember(Integer.parseInt(parameters[3]));

            ArrayList<Boat> boats = new ArrayList<>();
            for(int i = 4; i < parameters.length-1; i = i+2){
                Boat boat = new Boat(BoatType.valueOf(parameters[i]),Float.parseFloat(parameters[i+1]));
                boats.add(boat);
//                member.registerNewBoat(BoatType.valueOf(parameters[i]),Double.parseDouble(parameters[i+1]));
                member.setBoats(boats);
            }
            members.add(member);
            boatClub.setMembers(members);
        }
        return members;
    }

    public void updateRegistryFile(BoatClub boatClub){
        ArrayList<Member> members = boatClub.getAllMembersLocally();
        File file = new File("VerboseList.txt");
        try {
            saver = new PrintWriter(file);
            for(Member member : members) {
                saver.print(member.getName() + ":" + member.getPersonalNumber() + ":"
                        + member.getMemberID() + ":" + member.numberOfBoats());
                for (Boat boat : member.boatsOwnedByMember()) {
                    saver.print(":" + boat.getType() + ":" + boat.getLength());
                }
                saver.println();
            }
            saver.close();

        }catch(Exception e) {

        }
    }
}
