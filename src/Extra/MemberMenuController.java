package Extra;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import Model.Registry;
import Util.UserChoiceInBoatMenu;
import Util.UserChoiceInMemberMenu;
import View.BoatMenu;
import View.MemberMenu;

public class MemberMenuController {

  /*  private MemberMenu menu;
    private Member member;
    private Boat boat;

    public void actUponUserInputInMemberMenu(BoatClub boatClub) {
        this.menu = new MemberMenu();
        boolean IWantToGoBack = false;
        while (!IWantToGoBack) {
            this.menu.showInstruction();
            UserChoiceInMemberMenu userChoice = this.menu.getUserInputInMemberMenu();
            switch (userChoice) {
                case COMPACT_LIST:
                    this.member = this.menu.showCompactList(boatClub);//this boat club here show the list and assign the members to the boat club
                    actionOnCompactList(boatClub);
                    if(this.member!=null)
                    IWantToGoBack = true;
                    break;
               case VERBOSE_LIST:
                    this.menu.showVerboseList(boatClub);
                    IWantToGoBack=true;
                    break;
                case QUIT:
                    IWantToGoBack = true;

            }
        }
    }

    public void actionOnCompactList(BoatClub boatClub){
      //  Iterable<Member> members = boatClub.getAllMembersFromRegistry();
        Registry registry = new Registry();
        //UserChoiceInMemberMenu choice = null;
        boolean goBack=false;
        while(!goBack  ){
            UserChoiceInMemberMenu choice = this.menu.getInputInCompactList();
            switch (choice){
                case DELETE:
                    //for debug
                    // boatClub.loadAllInformationOfMembers(registry);//this should update the arraylist of members from registry
                    try {
                        menu.showConfirmationMsg(boatClub.deleteMember(this.member));
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
                    this.boat = menu.showMemberInformation(member);
                    actUponUserInputInBoatMenu();
                    registry.updateRegistryFile(boatClub);
                    goBack = true;
                    break;
            }
        }
    }

    public void actUponUserInputInBoatMenu(){
        BoatMenu menu = new BoatMenu();
       // menu.showInstruction();
        UserChoiceInBoatMenu choice = this.menu.getUserInputInBoatMenu();

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
    }*/

}