package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class VerboseListSave {
    private Scanner reader;
    private PrintWriter saver=null;

    public void saveFileOnCompactList(Member member) {
        File file = new File("CompactList.txt");
        try {
            saver = new PrintWriter(new FileWriter(file,true));

            saver.println( member.getName() + "," + member.getMemberID() + "," + member.numberOfBoats());

            saver.close();

        }catch(Exception e){

        }
    }

    public String compactList(String filePath){

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

    public Iterable<Member> readyToPrintForCompactList(String result){
        ArrayList<Member> members = new ArrayList<>();
        String[] eachLines = result.split("[\\r\\n]+");
        for (String lines: eachLines) {
            String[] parameters = lines.split(",");
            Member member = new Member(parameters[0],parameters[1]);
            member.setNumbersOfBoatsOwnByAMember(Integer.parseInt(parameters[2]));
            members.add(member);
        }
        return members;
    }
}
