package model;

import java.util.ArrayList;
import model.Boat.boatType;
import model.Boat;

public class Member {

	private String firstName;
	private String lastName;
	private int memberID;
	private int personalNumber;
	ArrayList<Boat> boatList = new ArrayList<Boat>();;
	
public Member(String fn, int mID, int pn) {
	firstName = fn;
	memberID = mID;
	personalNumber = pn;
	//boatList = new ArrayList<Boat>();
}

public Member(int mID,String fn,String ln, int pn) {
	firstName = fn;
	lastName = ln;
	memberID = mID;
	personalNumber = pn;
}

public void setFirstName(String fn) {
	firstName = fn;
}

public String getfirstName() {
	return firstName;
}

public void setLastName(String ln) {
	lastName = ln;
}

public String getLastName() {
	return lastName;
}

//public void setMemberID(int mID) {
//	memberID = mID;
//}

public int getMemberID() {
	return memberID;
}

public void setPersonalNumber(int pn) {
	personalNumber  = pn;
}

public int getPersonalNumber() {
	return personalNumber;
}

public void registerBoat(double l, boatType t) throws IllegalAccessException {
	Boat boat = new Boat(l, t);
	this.boatList.add(boat);
//	for(Boat b: boatList) {
//		System.out.println(b.getType() + "\t|\t" + b.getLength());
//	}
}

public void updateBoat(double l, boatType t, Boat boat) throws IllegalAccessException {
	boat.setLength(l);
	boat.setType(t);
}

public void deleteBoat(Boat boat) {
	this.boatList.remove(boat);
}

public ArrayList<Boat> getBoats() {
	return boatList;
}

}
