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
                for (Member member : boatClub.getAllMember()) {
                    if (this.startMenu.loginAuthentication(member)) {
                        this.member = member;
                        checkInputInLoginMenu();
                    }
                }
                break;
            case 2: /** SHOW LIST */
                checkInputInShowList();
                break;
            case 0:
                return false;
        }
        return true;
    }

    private void checkInputInLoginMenu() {
        this.loginMenu = new LoginMenu();
        this.loginMenu.showInstruction();
        this.memberController = new MemberController();
        int input = this.loginMenu.getInput();

        switch (input) {
            case 1: /** MEMBER MENU */
                checkInputInMemberMenu();
                break;
            case 2: /** BOAT MENU */
                checkInputInBoatMenu();
                break;
            case 0:
                break;

        }
    }

    private void checkInputInShowList() {
        this.showList = new ShowList();
        this.showList.showInstruction();
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
        this.memberMenu = new MemberMenu();
        this.memberMenu.showInstruction();
        int input = this.memberMenu.getInput();

        switch (input) {
            case 1: /** ADD MEMBER */
                this.boatClub.addMember(this.memberMenu.addMember());
                break;
            case 2: /** UPDATE MEMBER */
                this.memberMenu.updateMember(this.member);
                break;
            case 3: /** DELETE MEMBER */
        }
    }

    private void checkInputInBoatMenu() {
        this.boatMenu = new BoatMenu();
        this.boatMenu.showInstruction();
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
