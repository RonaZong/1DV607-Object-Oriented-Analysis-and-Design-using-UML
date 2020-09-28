package Model;

import java.io.File;
import java.io.PrintWriter;
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

        }catch(Exception e){

        }
        return file;
    }

    
}
