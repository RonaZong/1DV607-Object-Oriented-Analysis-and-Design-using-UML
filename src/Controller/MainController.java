package Controller;

import Model.Boat;
import Model.BoatClub;
import Model.Member;
import View.*;

public class MainController {
    private BoatClub boatClub;
    private Member member;
    private StartMenu startMenu;
    private LoginMenu loginMenu;
    private ShowList showList;
    private MemberMenu memberMenu;
    private BoatMenu boatMenu;

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
            case 1: /** LOGIN */
                this.loginMenu = new LoginMenu();
                this.loginMenu.showInstruction();
                checkInputInLoginMenu();
                break;
            case 2: /** SHOW LIST */
                this.showList = new ShowList();
                this.showList.showInstruction();
                checkInputInShowList();
                break;
            case 0:
                return false;
        }
        return true;
    }

    private void checkInputInLoginMenu() {
        int input = this.loginMenu.getInput();

        switch (input) {
            case 1: /** MEMBER MENU */
                this.memberMenu = new MemberMenu();
                this.memberMenu.showInstruction();
                checkInputInMemberMenu();
                break;
            case 2: /** BOAT MENU */
                this.boatMenu = new BoatMenu();
                boatMenu.showInstruction();
                checkInputInBoatMenu();
                break;
            case 0:
                break;

        }
    }

    private void checkInputInShowList() {
        int input = this.startMenu.getInput();

        switch (input) {
            case 1: /** COMPACT LIST */
                break;
            case 2: /** VERBOSE LIST */
                break;
            case 3: /** SPECIFIC MEMBER */
                break;

        }
    }

    private void checkInputInMemberMenu() {

        int input = this.memberMenu.getInput();

        switch (input) {
            case 1: /** ADD MEMBER */
                this.memberMenu.addMember();
                break;
            case 2: /** UPDATE MEMBER */
                this.memberMenu.updateMember(this.member);
                break;
            case 3: /** DELETE MEMBER */


        }
    }

    private void checkInputInBoatMenu() {
        int input = this.memberMenu.getInput();

        switch (input) {
            case 1: /** ADD BOAT */
                Boat boat;
                break;
            case 2: /** UPDATE BOAT */

            case 3: /** DELETE BOAT */

        }
    }


}
