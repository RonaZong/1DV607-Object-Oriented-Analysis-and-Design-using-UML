package controller;

import java.util.Scanner;

public class User {
	

	public void register(model.Member a_member, view.Console a_view) {
		a_view.DisplayWelcomeMessage();
		a_view.DisplayInstructions1();
		ScanFirstName();
		a_view.DisplayInstructions2();
		ScanLastName();
		a_view.DisplayResult(a_member.addFirstName(), a_member.addLastName());
		
		System.exit(0);
	}
	
	public String ScanFirstName() {
		Scanner scan = new Scanner(System.in);
		String first = scan.next();
		scan.close();
		return first;
	}
	public String ScanLastName() {
		Scanner scan = new Scanner(System.in);
		String last = scan.next();
		scan.close();
		return last;
	}
}
