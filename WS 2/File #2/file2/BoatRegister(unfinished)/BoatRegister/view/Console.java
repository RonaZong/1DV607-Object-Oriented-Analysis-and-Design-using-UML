package view;

public class Console {
	private int getInputString() {
		 try {
		      int c = System.in.read();
		      while (c == '\r' || c =='\n') {
		        c = System.in.read();
		      }
		      return c;
		    } catch (java.io.IOException e) {
		      System.out.println("" + e);
		      return 0;
		    }
	}

	 public void DisplayWelcomeMessage() {
		    System.out.println("Hello");
		  }
		  
	 public void DisplayInstructions1() {
		    System.out.println("Print the first name of the new user");
		  }
	 public void DisplayInstructions2() {
		    System.out.println("Print the last name of the new user");
		  }
		  
	public boolean wantsToContinue() {
	    return getInputString() != 'q';
	  }
	public void DisplayResult(String firstName, String lastName) {
		System.out.println("The name of the new member is " + firstName + " " + lastName);
	}
	
}
