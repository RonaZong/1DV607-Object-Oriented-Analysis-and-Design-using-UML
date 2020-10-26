package Model;


public class SearchStrategy implements SelectionStrategy{

    public SearchStrategy() {
    }

    @Override
    public void searchMembersByName(BoatClub boatClub, String input) {

        for (Member member : boatClub.getAllMember()) {
            if (member.getName().charAt(0) == input.charAt(0));
        }
    }


}
