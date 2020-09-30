package Model;


import Util.BoatType;

public class Boat {



    private BoatType type;
    private float length;

    //since we have only this 4 fixed type better to have enum in my idea
    public Boat(BoatType type, float length) {
        this.type = type;
        this.length = length;
        //the method for saving boat should be here too
    }

    public BoatType getType() {
        return type;
    }

    public void setType(BoatType type) {
        this.type = type;
        //after updating information it should be saved
    }

    public double getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
        //after updating information it should be saved
    }


}
