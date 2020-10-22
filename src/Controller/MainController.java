package Controller;

import Model.BoatClub;
import Model.Member;
import Util.MenuOptions;
import View.MemberMenu;
import View.ShowList;
import View.StartMenu;

public class MainController {
    private BoatClub boatClub;
    private Member member;
    private StartMenu startMenu;
    private MemberMenu memberMenu;
    private ShowList showList;

    public MainController(BoatClub boatClub, StartMenu startMenu) {
        this.boatClub = boatClub;
        this.startMenu = startMenu;
    }

    public void memberAction() {
        while (checkInputInStartMenu()) ;
    }

    private boolean checkInputInStartMenu() {
        this.startMenu.showInstruction();
        int input = this.startMenu.getInput();

        switch (input) {
            case 1: /** MEMBER MENU */
                checkInputInMemberMenu();
                break;
            case 2: /** SHOW LIST */
                this.showList = new ShowList();
                this.showList.showInstruction();
                break;
            case 3:
                return false;
        }
        return true;
    }

    private void checkInputInMemberMenu() {
        this.memberMenu = new MemberMenu();
        this.memberMenu.showInstruction();

        int input = this.memberMenu.getInput();

        switch (input) {
            case 1:
                Member member;
        }
    }


}
