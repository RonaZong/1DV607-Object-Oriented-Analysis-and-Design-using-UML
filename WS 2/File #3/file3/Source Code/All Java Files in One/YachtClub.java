package com.yachtclub;
import com.yachtclub.domain.members.MemberManager;
import com.yachtclub.technicalservices.persistence.TextFileDataBase;
import com.yachtclub.ui.text.YachtClubTextUI;


public class YachtClub {
    public static void main(String[] args) {
        // Create a persistent storage in Technical Services.
        TextFileDataBase textFileDataBase= new TextFileDataBase("TextFileDataBase.txt");

        // Create a manager for members in the Domain.
        MemberManager memberManager = new MemberManager();

        // Load data from Technical Services into the Domain.
        memberManager.populateFromPersistentStorage(textFileDataBase.loadTextFromFile());

        // Create a console interface in the UI.
        YachtClubTextUI yachtClubTextUI = new YachtClubTextUI(memberManager);
        yachtClubTextUI.show();

        // Save data to persistent storage with Technical Services.
        System.out.println("\nSaving to persistent storage with Technical Services...");
        textFileDataBase.saveTextToFile(memberManager.forwardToPersistentStorage());
    }
}
