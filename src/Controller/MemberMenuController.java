package Controller;

import Model.BoatClub;
import Model.Member;
import Util.UserChoiceInMemberMenu;
import View.MemberMenu;

public class MemberMenuController {

    private MemberMenu menu;
    private Member member;

    public void actUponUserInputInMemberMenu(BoatClub boatClub) {
        menu = new MemberMenu();
        boolean IWantToGoBack = false;
        while (!IWantToGoBack) {
            menu.showInstruction();
            UserChoiceInMemberMenu userChoice = menu.getUserInputInMemberMenu();
            switch (userChoice) {
                case COMPACT_LIST:
                    member =menu.showCompactList(boatClub);
                    IWantToGoBack = true;
                    break;
               case VERBOSE_LIST:
                    menu.showVerboseList(boatClub);
                    break;

            }
        }

    }

    public void actionOnCompactList(BoatClub boatClub){

        boolean goBack=false;
        while(!goBack){
            UserChoiceInMemberMenu choice = menu.getInputInCompactList();
            switch (choice){
                case DELETE:

                    // menu.showDeleteMemberMenu();
                    boatClub.deleteMember(member);
                    goBack = true;
                    break;
                case UPDATE:
                    menu.showUpdateMenu();
                    boatClub.updateMemberInformation(member, menu.getName(), menu.getPersonalNumber());
                    break;
                case SPECIFIC_MEMBER:
                    menu.showMemberInformation(member);
                    break;
            }
        }
    }

}