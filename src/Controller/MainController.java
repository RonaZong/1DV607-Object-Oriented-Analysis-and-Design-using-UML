package Controller;

import Extra.MemberCreationMenu;
import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Util.UserChoiceInBoatMenu;
import Util.UserChoiceInMemberMenu;
import Util.UserChoiceInStartMenu;
import View.*;

public class MainController {

    private BoatClub boatClub;
    private StartMenu menu;
    private MemberCreationMenu memberCreationMenu;
    private BoatMenu boatMenu;
    private MemberMenu memberMenu;
    private Member member;
    private Boat boat;

    public MainController(BoatClub boatClub) {
        this.boatClub = boatClub;
       // this.menu = console;
    }

    //every scenarios would happen in this method
    public void memberAction(StartMenu menu){
        boatClub.getAllMembersFromRegistry();
        while(!actUponUserInputInStartMenu(menu)) ;
    }

    //handling all user choices in main menu
    private boolean actUponUserInputInStartMenu(StartMenu menu) {
        //this.menu.showInstruction();
       // StartMenu menu = new StartMenu();
        menu.showInstruction();
        UserChoiceInStartMenu userChoice = menu.getUserInputInStartMenu();

        while (userChoice !=null) {
            switch (userChoice) {
                case ADD_NEW_MEMBER:
                   // MemberCreationController memberCreationController = new MemberCreationController();
                   // memberCreationController.userWantsToAddMember(boatClub);
                    userWantsToAddMember(menu);
                   // if(!memberCreationMenu.userWantsToAddMoreMemebr())
                    userChoice=null;//for exiting the loop after add a member
                    break;
                case MEMBER_MENU:
                   // MemberMenuController memberMenuController = new MemberMenuController();
                   // memberMenuController.actUponUserInputInMemberMenu(boatClub);
                    actUponUserInputInMemberMenu();
                    userChoice=null;//for exit the loop since userchoice does not change after member menu closed so we always come back here and user choice would be same
                    break;
                case SAVE:
                    boatClub.save();
                    userChoice=null;
                    menu.showSaveMsg();
                    break;
                case QUIT:
                    return true;
            }
        }
        return false;
    }


    /** Probably do not need to use (BoatClub) as they are all in onw controller **/

    //handling user choices in adding new member menu

    private void userWantsToAddMember(StartMenu menu){
        //memberCreationMenu = new MemberCreationMenu();
       // MemberCreationMenu menu = new MemberCreationMenu();
       // memberCreationMenu.showInstruction();
        do {
            menu.showInstructionOfCreateMember();
            Member member = boatClub.creatMember(menu.getName(), menu.getPersonalNumber());
            for (int i = 0; i < menu.getNumberOfBoats(); i++) {
                member.registerNewBoat(menu.getType()[i], menu.getBoatLength()[i]);
            }
           // boatClub.saveOnVerboseList(member);
            menu.confirmationMsg();
        }while(menu.userWantsToAddMoreMemebr());


    }

    //handling all user choices in member menu
    private void actUponUserInputInMemberMenu() {
        memberMenu = new MemberMenu();
       // MemberMenu menu = new MemberMenu();
        boolean IWantToGoBack = false;
        while (!IWantToGoBack) {
            memberMenu.showInstruction();
            UserChoiceInMemberMenu userChoice = memberMenu.getUserInputInMemberMenu();
            switch (userChoice) {
                case COMPACT_LIST:
                    this.member = memberMenu.showCompactList(boatClub);//this boat club here show the list and assign the members to the boat club
                    actionOnCompactList();
                   // if(this.member!=null)
                       IWantToGoBack = true;
                    break;
                case VERBOSE_LIST:
                    memberMenu.showVerboseList(boatClub);
                    IWantToGoBack=true;
                    break;
                case QUIT:
                    IWantToGoBack = true;
                    break;

            }
        }
    }

    //handling all user choices in showing list of members
    private void actionOnCompactList(){
        //  Iterable<Member> members = boatClub.getAllMembersFromRegistry();
      //  Registry registry = new Registry();
        //UserChoiceInMemberMenu choice = null;
        boolean goBack=false;
        while(!goBack  ){
            UserChoiceInMemberMenu choice = this.memberMenu.getInputInCompactList();
            switch (choice){
                case DELETE:
                    //for debug
                    // boatClub.loadAllInformationOfMembers(registry);//this should update the arraylist of members from registry
                    memberMenu.showConfirmationMsg(boatClub.deleteMember(this.member));
                   // registry.updateRegistryFile(boatClub);
                    goBack = true;
                    break;
                case UPDATE:
                    memberMenu.showUpdateMenu();
                    boatClub.updateMemberInformation(member, memberMenu.getName(), memberMenu.getPersonalNumber());
                   // registry.updateRegistryFile(boatClub);
                     goBack = true;
                    break;
                case SPECIFIC_MEMBER:
                    this.boat = memberMenu.showMemberInformation(member);
                    actUponUserInputInBoatMenu();
                   // registry.updateRegistryFile(boatClub);
                    goBack = true;
                    break;
                case QUIT:
                    goBack =true;
                    break;
            }
        }
    }

    //handling all user choices for boat issues
    private void actUponUserInputInBoatMenu(){
        this.boatMenu = new BoatMenu();
        boatMenu.showInstruction();
        UserChoiceInBoatMenu choice = boatMenu.getUserInputInBoatMenu();

        switch (choice){
            case ADD_NEW_BOAT:
                //member= boatClub.getMember(menu.ShowAccessToMember());
                boatMenu.showRegisterOrChangeABoat();
                member.registerNewBoat(boatMenu.getBoatType(),boatMenu.getLength());
                boatMenu.showAddConfirmation();
                System.out.println(member.numberOfBoats());
                break;
            case CHANGE_BOAT_INFORMATION:
                // member= boatClub.getMember(menu.ShowAccessToMember());
                boatMenu.showRegisterOrChangeABoat();
                this.boat.setType(boatMenu.getBoatType());
                this.boat.setLength(boatMenu.getLength());
                break;

            case DELETE_BOAT:
                //member= boatClub.getMember(menu.ShowAccessToMember());
                member.deleteBoat(this.boat);
                break;

        }
    }

}
