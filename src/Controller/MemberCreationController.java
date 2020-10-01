package Controller;

import Model.BoatClub;
import Model.Member;
import Util.BoatType;
import View.MemberCreationMenu;
import View.Menu;
import View.StartMenu;

public class MemberCreationController {

    private MemberCreationMenu menu;

    public void userWantsToAddMember(BoatClub boatClub){
        menu = new MemberCreationMenu();
        menu.showInstruction();
        Member member = boatClub.creatMember(menu.getName(), menu.getPersonalNumber());
        for(int i = 0 ; i < menu.getNumberOfBoats(); i++){
            member.registerNewBoat(menu.getType()[i] , menu.getBoatLength()[i]);
        }
       // boatClub.saveOnCompactList(member);
        boatClub.saveOnVerboseList(member);
        menu.confirmationMsg();
    }


}
