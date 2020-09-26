package Controller;

import Model.BoatClub;
import View.MemberCreationMenu;
import View.Menu;
import View.StartMenu;

public class MemberCreationController {

    private MemberCreationMenu menu;

   

    public void userWantsToAddMember(BoatClub boatClub){

        menu = new MemberCreationMenu();

        boatClub.creatMember(menu.getName() , menu.getPersonalNumber());

    }


}
