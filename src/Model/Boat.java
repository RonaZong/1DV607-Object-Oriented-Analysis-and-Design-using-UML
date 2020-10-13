package Model;


import Util.BoatType;

public class Boat {

    private BoatType type;
    private double length;


    public Boat(BoatType type, double length) {
       // this.type = type;
        setType(type);
        this.length = length;
    }

    public BoatType getType() {
        return type;
    }

    public void setType(BoatType type) {
        this.type = type;

    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(length > 70 || length <= 0)
            throw new IllegalArgumentException("Boat length should be between 1 and 70 meters");
        this.length = length;
    }

}
