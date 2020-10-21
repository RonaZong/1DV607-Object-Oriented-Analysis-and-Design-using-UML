package Util;

public enum MenuOptions {

    QUIT(0, "QUIT"),
    MEMBER_MENU(1, "MEMBER MENU"),
    SHOW_LIST(2, "SHOW LIST"),

    ADD_MEMBER(1, "ADD MEMBER"),
    UPDATE_MEMBER(2,"UPDATE MEMBER"),
    DELETE_MEMBER(3, "DELETE MEMBER"),

    ADD_BOAT(1, "ADD Boat"),
    UPDATE_BOAT(2, "UPDATE BOAT"),
    DELETE_BOAT(3, "DELETE BOAT"),

    COMPACT_LIST(1, "COMPACT LIST"),
    VERBOSE_LIST(2, "VERBOSE LIST");

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
