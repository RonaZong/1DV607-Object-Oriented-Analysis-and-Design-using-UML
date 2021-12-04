package model;

import model.Boat;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private File members = new File("members.txt");
    private File boats = new File("boats.txt");
    ArrayList<Member> memberArrayListRead;
    ArrayList<Boat> boatsArrayListRead;


    public Database() {

    }

    private boolean checkFile(File file) throws IOException {
        if (file.exists()) {
            return true;
        } else if (file.exists()) {
            file.createNewFile();
            return true;
        }
        return false;
    }

    public void writeToFile(File membersFile,File boatsFile, ArrayList<Member> memberList) throws IOException {

        try {
            FileWriter writer = new FileWriter(membersFile.getAbsoluteFile());
            StringBuilder members = new StringBuilder();
            StringBuilder boats = new StringBuilder();
            for (Member member : memberList) {
                members.append(member.getMemberID() + ",");
                members.append(member.getfirstName() + ",");
                members.append(member.getLastName() + ",");
                members.append(member.getPersonalNumber());
                for (Boat boat : member.getBoats()) {
                    boats.append(member.getMemberID() + ",");
                    boats.append(boat.getLength() + ",");
                    boats.append(boat.getType() + ",");
                    boats.append("\n");
                }
                members.append("\n");
            }
            if (checkFile(membersFile.getAbsoluteFile())) {
                writer.write(members.toString());
                writer.write(boats.toString());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void readFile(File memberFile, File boatsFile) throws IllegalAccessException, IOException {
       checkFile(members);
       checkFile(boats);
    	Scanner scanner = new Scanner(memberFile.getAbsoluteFile());
        memberArrayListRead = new ArrayList<>();
        boatsArrayListRead = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] strtemp = scanner.nextLine().split(",");
            memberArrayListRead.add(new Member(Integer.parseInt(strtemp[0]), strtemp[1], strtemp[2], Integer.parseInt(strtemp[3])));
        }
        scanner.close();

        scanner = new Scanner(boatsFile.getAbsoluteFile());

        while (scanner.hasNext()) {
            String[] strtemp = scanner.nextLine().split(",");
            for (Member m : memberArrayListRead) {
                if (m.getMemberID() == Integer.parseInt(strtemp[0])) {
                    m.registerBoat(Double.parseDouble(strtemp[1]), Boat.boatType.valueOf(strtemp[2]));
                }
            }
        }

        scanner.close();
    }
    public ArrayList<Member>loadData() throws IllegalAccessException, IOException {
        readFile(members.getAbsoluteFile(),boats.getAbsoluteFile());
        return memberArrayListRead;
    }
    public  void  saveData(ArrayList<Member>memberList) throws IOException {
        writeToFile(members.getAbsoluteFile(),boats.getAbsoluteFile(),memberList);
    }

    public void checkDataFiles() throws IOException {
    	checkFile(members);
    	checkFile(boats);
    }
}
