package model;

public class Boat  {
    private double length;
    private boatType type;

    public Boat(double len,boatType type ) throws IllegalAccessException {
    	this.length = len;
    	this.type=type;
    }
    

    public double getLength() {
        return length;
    }

    public void setLength(double length ) throws IllegalAccessException {
		
		 if(length <= 0){ throw new IllegalAccessException("Wrong value"); }
		 
        this.length = length ;
    }

    public boatType getType() {
        return type;
    }

    public void setType(boatType type) {
        this.type = type;
    }


    public enum boatType{Sailboat(1), Motorsailer(2), kayak_Canoe(3), Other(4);
        private int selectBoatType;
         private  boatType(int i) {
            this.selectBoatType=i;
        }
         public int getSelectBoatType(){
            return this.selectBoatType;
        }
    }


}
