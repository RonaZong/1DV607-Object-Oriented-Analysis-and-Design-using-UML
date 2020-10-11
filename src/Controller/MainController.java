package Controller;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Model.Registry;
import Util.UserChoiceInBoatMenu;
import Util.UserChoiceInMemberMenu;
import Util.UserChoiceInStartMenu;
import View.*;

public class MainController {

    private BoatClub boatClub;
    private StartMenu menu;
    private MemberCreationMenu memberCreationMenu;
    private MemberMenu memberMenu;
    private Member member;
    private Boat boat;

    public MainController(BoatClub boatClub, StartMenu console) {
        this.boatClub = boatClub;
        this.menu = console;
    }

    //every scenarios would happen in this method
    public void memberAction(){
        while(!actUponUserInputInStartMenu()) ;
    }

    private boolean actUponUserInputInStartMenu() {

        this.menu.showInstruction();
        UserChoiceInStartMenu userChoice = this.menu.getUserInputInStartMenu();

        while (userChoice !=null) {
            switch (userChoice) {
                case ADD_NEW_MEMBER:
                   // MemberCreationController memberCreationController = new MemberCreationController();
                   // memberCreationController.userWantsToAddMember(boatClub);
                    userWantsToAddMember(boatClub);
                    userChoice=null;//for exiting the loop after add a member
                    break;
                case MEMBER_MENU:
                   // MemberMenuController memberMenuController = new MemberMenuController();
                   // memberMenuController.actUponUserInputInMemberMenu(boatClub);
                    actUponUserInputInMemberMenu(boatClub);
                    break;
                case QUIT:
                    return true;
            }
        }
        return false;
    }

    private void userWantsToAddMember(BoatClub boatClub){
        memberCreationMenu = new MemberCreationMenu();
        memberCreationMenu.showInstruction();
        Member member = boatClub.creatMember(memberCreationMenu.getName(), memberCreationMenu.getPersonalNumber());
        for(int i = 0 ; i < memberCreationMenu.getNumberOfBoats(); i++){
            member.registerNewBoat(memberCreationMenu.getType()[i] , memberCreationMenu.getBoatLength()[i]);
        }
        boatClub.saveOnVerboseList(member);
        memberCreationMenu.confirmationMsg();
    }

    private void actUponUserInputInMemberMenu(BoatClub boatClub) {
        memberMenu = new MemberMenu();
        boolean IWantToGoBack = false;
        while (!IWantToGoBack) {
            this.memberMenu.showInstruction();
            UserChoiceInMemberMenu userChoice = this.memberMenu.getUserInputInMemberMenu();
            switch (userChoice) {
                case COMPACT_LIST:
                    this.member = this.memberMenu.showCompactList(boatClub);//this boat club here show the list and assign the members to the boat club
                    actionOnCompactList(boatClub);
                    if(this.member!=null)
                        IWantToGoBack = true;
                    break;
                case VERBOSE_LIST:
                    this.memberMenu.showVerboseList(boatClub);
                    IWantToGoBack=true;
                    break;
                case QUIT:
                    IWantToGoBack = true;

            }
        }
    }

    private void actionOnCompactList(BoatClub boatClub){
        //  Iterable<Member> members = boatClub.getAllMembersFromRegistry();
        Registry registry = new Registry();
        //UserChoiceInMemberMenu choice = null;
        boolean goBack=false;
        while(!goBack  ){
            UserChoiceInMemberMenu choice = this.memberMenu.getInputInCompactList();
            switch (choice){
                case DELETE:
                    //for debug
                    // boatClub.loadAllInformationOfMembers(registry);//this should update the arraylist of members from registry
                    try {
                        memberMenu.showConfirmationMsg(boatClub.deleteMember(this.member));
                    }catch (NullPointerException e){

                    }
                    registry.updateRegistryFile(boatClub);

                    goBack = true;
                    break;
                case UPDATE:
                    memberMenu.showUpdateMenu();
                    boatClub.updateMemberInformation(member, memberMenu.getName(), memberMenu.getPersonalNumber());
                    registry.updateRegistryFile(boatClub);
                    goBack = true;
                    break;
                case SPECIFIC_MEMBER:
                    this.boat = memberMenu.showMemberInformation(member);
                    actUponUserInputInBoatMenu();
                    registry.updateRegistryFile(boatClub);
                    goBack = true;
                    break;
            }
        }
    }

    private void actUponUserInputInBoatMenu(){
        BoatMenu menu = new BoatMenu();
        // menu.showInstruction();
        UserChoiceInBoatMenu choice = this.memberMenu.getUserInputInBoatMenu();

        switch (choice){
            case ADD_NEW_BOAT:
                //member= boatClub.getMember(menu.ShowAccessToMember());
                menu.showRegisterOrChangeABoat();
                member.registerNewBoat(menu.getBoatType(),menu.getLength());
                break;
            case CHANGE_BOAT_INFORMATION:
                // member= boatClub.getMember(menu.ShowAccessToMember());
                menu.showRegisterOrChangeABoat();
                this.boat.setType(menu.getBoatType());
                this.boat.setLength(menu.getLength());
                break;

            case DELETE_BOAT:
                //member= boatClub.getMember(menu.ShowAccessToMember());
                member.deleteBoat(this.boat);
                break;

        }
    }

}
