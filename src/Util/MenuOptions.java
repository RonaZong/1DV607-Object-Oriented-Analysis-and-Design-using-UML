package Util;

public enum MenuOptions {
    GO_BACK(0, "GO BACK"),

    /** Start Menu */
    QUIT(0, "QUIT"),
    LOG_IN(1, "LOG IN"),
    SHOW_LIST(2, "SHOW LIST"),

    /** Show List */
    COMPACT_LIST(1, "COMPACT LIST"),
    VERBOSE_LIST(2, "VERBOSE LIST"),
    SPECIFIC_MEMBER(3, "SPECIFIC MEMBER"),

    /** LOG IN */
    MEMBER_MENU(1, "MEMBER MENU"),
    BOAT_MENU(2, "BOAT MENU"),

    /** Member Menu */
    ADD_MEMBER(1, "ADD MEMBER"),
    UPDATE_MEMBER(2,"UPDATE MEMBER"),
    DELETE_MEMBER(3, "DELETE MEMBER"),

    /** Boat Menu */
    ADD_BOAT(1, "ADD BOAT"),
    UPDATE_BOAT(2, "UPDATE BOAT"),
    DELETE_BOAT(3, "DELETE BOAT"),

    /** Boat Type */
    SAILBOAT(1, "SAILBOAT"),
    MOTORSAILOR(2, "MOTORSAILOR"),
    KAYAK_OR_CANOE(3, "KAYAK_OR_CANOE"),
    OTHER(4, "OTHER");


    private int input;
    private String message;

    MenuOptions(int input, String message) {
        this.input = input;
        this.message = message;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
