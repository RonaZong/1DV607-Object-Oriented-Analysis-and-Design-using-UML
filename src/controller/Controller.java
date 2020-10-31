package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Card;
import model.Dealer;
import model.Game;
import model.ICardObserver;
import model.rules.BasicHitAmericanGameDealerWinFactory;
import model.rules.IVisitor;
import model.rules.RulesAbstractFactory;
import model.rules.Soft17InternationalDealerFactory;
import view.PrintVisitor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, ICardObserver{
    private RulesAbstractFactory factory;
    private IVisitor iVisitor;
    private Game a_game;

    private Image[] deckBack = {new Image("model/PNG/blue_back.png"), new Image("model/PNG/gray_back.png"), new Image("model/PNG/green_back.png"),
            new Image("model/PNG/purple_back.png"), new Image("model/PNG/red_back.png"), new Image("model/PNG/yellow_back.png")};

    private String cardType;

    private Image card;

    @FXML
    private Button PlayNewGame;

    @FXML
    private Button Hit;

    @FXML
    private Button Stand;

    @FXML
    private Text DealerScore;

    @FXML
    private Text PlayerScore;

    @FXML
    private ImageView Deck;

    @FXML
    private ImageView DealerCard1;

    @FXML
    private ImageView DealerCard2;

    @FXML
    private ImageView DealerCard3;

    @FXML
    private ImageView DealerCard4;

    @FXML
    private ImageView DealerCard5;

    @FXML
    private ImageView DealerCard6;

    @FXML
    private ImageView PlayerCard1;

    @FXML
    private ImageView PlayerCard2;

    @FXML
    private ImageView PlayerCard3;

    @FXML
    private ImageView PlayerCard4;

    @FXML
    private ImageView PlayerCard5;

    @FXML
    private ImageView PlayerCard6;

    @FXML
    private Text GameOver;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.factory = new Soft17InternationalDealerFactory();
        this.iVisitor = new PrintVisitor();
        this.a_game = new Game(factory, iVisitor);
        this.a_game.SubscriptionToNewCards(this);
        DeckBack();
    }

    @Override
    public void updateNewCard(Card card) {
    }

    @FXML
    void PlayNewGame() {
        this.GameOver.setText(null);
        this.PlayerCard1.setImage(null);
        this.PlayerCard2.setImage(null);
        this.PlayerCard3.setImage(null);
        this.PlayerCard4.setImage(null);
        this.PlayerCard5.setImage(null);
        this.PlayerCard6.setImage(null);
        this.DealerCard1.setImage(null);
        this.DealerCard2.setImage(null);
        this.DealerCard3.setImage(null);
        this.DealerCard4.setImage(null);
        this.DealerCard5.setImage(null);
        this.DealerCard6.setImage(null);

        this.a_game.NewGame();
        showCard();
        DeckBack();

        PlayerScore.setText(String.valueOf(a_game.GetPlayerScore()));
        DealerScore.setText(String.valueOf(a_game.GetDealerScore()));
        gameOver();
    }

    @FXML
    void Hit() throws IOException {
        this.a_game.Hit();
        DeckBack();
        showCard();
        PlayerScore.setText(String.valueOf(a_game.GetPlayerScore()));
        DealerScore.setText(String.valueOf(a_game.GetDealerScore()));
        gameOver();
    }

    @FXML
    void Stand() throws IOException {
        this.a_game.Stand();
        DeckBack();
        showCard();
        PlayerScore.setText(String.valueOf(a_game.GetPlayerScore()));
        DealerScore.setText(String.valueOf(a_game.GetDealerScore()));
        gameOver();
    }

    private void DeckBack() {
        this.Deck.setImage(deckBack[(int)(Math.random() * 6)]);
    }

    private void showCard() {
        int i = 0;
        int j = 0;
        ImageView[] PlayerCards = {PlayerCard1, PlayerCard2, PlayerCard3, PlayerCard4 , PlayerCard5, PlayerCard6};
        ImageView[] DealerCards = {DealerCard1, DealerCard2, DealerCard3, DealerCard4, DealerCard5, DealerCard6};

        String cardScores[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";

        for (Card card : this.a_game.GetPlayerHand()) {
            this.cardType = cardScores[card.GetValue().ordinal()] + card.GetColor().toString().charAt(0);
            this.card = new Image("model/PNG/" + this.cardType + ".png");
            PlayerCards[i].setImage(this.card);
            PlayerCards[i].setVisible(true);
            i++;
        }

        for (Card card : this.a_game.GetDealerHand()) {
            this.cardType = cardScores[card.GetValue().ordinal()] + card.GetColor().toString().charAt(0);
            this.card = new Image("model/PNG/" + this.cardType + ".png");
            DealerCards[j].setImage(this.card);
            DealerCards[j].setVisible(true);
            j++;
        }
    }

    private void gameOver() {
        if (this.a_game.IsGameOver()) {
            GameOver.setText(DisplayGameOver(this.a_game.IsDealerWinner()));
        }
    }

    public String DisplayGameOver(boolean a_dealerIsWinner)
    {
        if (a_dealerIsWinner) {
            return "Dealer Won!";
        }
        else {
            return "You Won!";
        }
    }

    public void Pause(){
        try{
            System.out.println("getting ....");
            Thread.sleep(2000);
        }catch (Exception e){}
    }


}
