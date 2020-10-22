package View;

import Model.Card;

public class SwedishView extends BaseView implements IView{
    public boolean play() {
        return getInput() == 'q';
    }

    public boolean hit() {
        return getInput() == 'h';
    }

    public boolean stand() {
        return getInput() == 's';
    }

    public boolean quit() {
        return getInput() == 'q';
    }

    public void DisplayWelcomeMessage()
    {
        for(int i = 0; i < 50; i++) {System.out.print("\n");};

        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
    }

    public void DisplayCard(Card card)
    {
        if (card.GetColor() == Card.Color.Hidden)
        {
            System.out.println("Dolt Kort");
        }
        else
        {
            String colors[] = { "Hjärter", "Spader", "Ruter", "Klöver" };
            String values[] = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
            System.out.println("" + colors[card.GetColor().ordinal()] + " " + values[card.GetValue().ordinal()]);
        }
    }

    public void DisplayPlayerHand(Iterable<Card> hand, int score) {
        DisplayHand("Spelare", hand, score);
    }

    public void DisplayDealerHand(Iterable<Card> hand, int score) {
        DisplayHand("Croupier", hand, score);
    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("Slut: ");
        if (a_dealerIsWinner)
        {
            System.out.println("Croupiern Vann!");
        }
        else
        {
            System.out.println("Du vann!");
        }
    }

    private void DisplayHand(String name, Iterable<Card> hand, int score)
    {
        System.out.println(name + " Har: " + score);
        for(Card c : hand)
        {
            DisplayCard(c);
        }
        System.out.println("Poäng: " + score);
        System.out.println("");
    }
}
