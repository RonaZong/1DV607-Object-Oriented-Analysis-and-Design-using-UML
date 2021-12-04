package com.yachtclub.domain.boats;

public class Boat {
    private String type;    // Boat type: Sailboat, Motorsailer, Kayak/Canoe, Other.
    private int length;     // Length of boat in centimeters.

    public Boat(String type, int length) {
        this.type = type;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Boat type = " + type + ", Boat length = " + length + " cm";
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public int getLength() {
        return length;
    }
}