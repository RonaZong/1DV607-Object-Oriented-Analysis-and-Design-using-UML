package Model;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CompactListSave {
    private Scanner reader;
    private PrintWriter saver;

    public File saveFileOnCompactList(BoatClub boatClub) {
        File file = new File("CompactList.txt");
        int index = 1;
        try {
            saver = new PrintWriter(file);
            for(Member member : boatClub.getAllMembers()){
                saver.println(index + "," + member.getName() + "," + member.getMemberID() + "," + member.numberOfBoats());
                index++;
            }
            saver.close();

        }catch(Exception e){

        }
        return file;
    }

    public String loadFromCompactList(File file){
        ArrayList<Member> members = new ArrayList<>();
        String result = "";
       try {
           reader = new Scanner(file);
           while (reader.hasNextLine()){
               String thisLine = reader.nextLine();
               String[] parameters = thisLine.split(",");
               Member member = new Member(parameters[1], parameters[2]);
               member.setNumbersOfBoatsOwnByAMember(Integer.parseInt(parameters[3]));


               result+=thisLine;
           }
       }catch(Exception e){

       }
       return result;
    }

    public Iterable<Member> readyToPrintForCompactList(String result){
        ArrayList<Member> members = new ArrayList<>();
        String[] eachLines = result.split("[\\r\\n]+");
        for (String lines: eachLines) {
            String[] parameters = lines.split(",");
            Member member = new Member(parameters[1],parameters[2]);
            member.setNumbersOfBoatsOwnByAMember(Integer.parseInt(parameters[3]));
            members.add(member);
        }
        return members;
    }

}
