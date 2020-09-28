package Controller;

import Model.BoatClub;
import Model.Member;
import View.MemberMenu;
import View.StartMenu;

public class MemberMenuController {


    public void actUponUserInputInMemberMenu(BoatClub boatClub,Member member) {
        MemberMenu menu = new MemberMenu();
        boolean IWantToQuit = false;
        while (IWantToQuit) {
            MemberMenu.UserChoice userChoice = menu.getUserInputInMemberMenu();
            switch (userChoice) {
                case COMPACT_LIST:
                    menu.showCompactList(boatClub);
                    IWantToQuit = true;
                    break;
                case VERBOSE_LIST:
                    menu.showVerboseList(boatClub);
                    break;
                case DELETE:
                    menu.showDeleteMemberMenu();
                    boatClub.deleteMember(member);
                    break;
                case UPDATE:
                    menu.showUpdateMenu();
                    boatClub.updateMemberInformation(member,menu.getName(),menu.getPersonalNumber());
                    break;
                case SPECIFIC_MEMBER:

            }


        }
    }

}