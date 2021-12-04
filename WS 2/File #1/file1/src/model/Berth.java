package model;

public class Berth {

	private int berthID;
	private int wharfID;
	private int berthLong;
	private int berthWidth;
	
public Berth(int bID, int wID) {
	berthID = bID;
	wharfID = wID;
	}

public Berth(int bID, int wID,int l, int w) {
	berthID = bID;
	wharfID = wID;
	berthLong = l;
	berthWidth = w;
	}

public int getBerth() {
	return berthID;
}

public int getWharf() {
	return wharfID;
}

public void setLong(int l) {
	berthLong = l;
}

public int getLong() {
	return berthLong;
}

public void setWidth(int w) {
	berthWidth = w;
}

public int getWidth() {
	return berthWidth;
}

}
