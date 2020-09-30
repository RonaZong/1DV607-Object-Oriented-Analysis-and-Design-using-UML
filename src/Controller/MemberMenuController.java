package Controller;

import Model.BoatClub;
import Model.CompactListSave;
import Model.Member;
import Util.UserChoiceInMemberMenu;
import View.MemberMenu;
import View.StartMenu;

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
                    menu.showCompactList(boatClub);
                    IWantToGoBack = true;
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