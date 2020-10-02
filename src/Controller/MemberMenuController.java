package Controller;

import Model.BoatClub;
import Model.Member;
import Model.Registry;
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
                    member = menu.showCompactList(boatClub);//this boat club here show the list and assign the members to the boat club
                    actionOnCompactList(boatClub);
                    IWantToGoBack = true;
                    break;
               case VERBOSE_LIST:
                    menu.showVerboseList(boatClub);
                    IWantToGoBack=true;
                    break;

            }
        }
    }

    public void actionOnCompactList(BoatClub boatClub){
      //  Iterable<Member> members = boatClub.getAllMembersFromRegistry();
        Registry registry = new Registry();
        //UserChoiceInMemberMenu choice = null;
        boolean goBack=false;
        while(!goBack  ){
            UserChoiceInMemberMenu choice = menu.getInputInCompactList();
            switch (choice){
                case DELETE:
                    //for debug
                    // boatClub.loadAllInformationOfMembers(registry);//this should update the arraylist of members from registry
                    try {
                        menu.showConfirmationMsg(boatClub.deleteMember(member));
                    }catch (NullPointerException e){

                    }
                    registry.updateRegistryFile(boatClub);

                    goBack = true;
                    break;
                case UPDATE:
                    menu.showUpdateMenu();
                    boatClub.updateMemberInformation(member, menu.getName(), menu.getPersonalNumber());
                    registry.updateRegistryFile(boatClub);
                    goBack = true;
                    break;
                case SPECIFIC_MEMBER:
                    menu.showMemberInformation(member);
                    goBack = true;
                    break;
            }
        }
    }

}