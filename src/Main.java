import Controller.MainController;
import Model.BoatClub;
import Model.Member;
import Model.PersonalNumber;
import Model.searchRule.CompositeSearch;
import Model.searchRule.ISearchingStrategy;
import Model.searchRule.SearchByAge;
import Model.searchRule.SearchNameStartWithString;
import Util.Checksum;
import View.StartMenu;

public class Main {

    public static void main(String[] args) {

        //System.out.print(PersonalNumber.DigitsForChecksum);

        BoatClub boatClub = new BoatClub();

        StartMenu menu=new StartMenu();
        System.out.print(Checksum.R1.getDigit());
        MainController user = new MainController(boatClub);

        user.memberAction(menu);

        ISearchingStrategy search = new SearchByAge(1990);
        ISearchingStrategy search1 = new SearchNameStartWithString("ni");
        CompositeSearch cm = new CompositeSearch();
        cm.add(search);
        cm.add(search1);
        Iterable<Member> members = boatClub.searchForMember(cm);
        for(Member m : members)
            System.out.println(m.getName() + " , " + m.getPersonalNumber());

    }
}
