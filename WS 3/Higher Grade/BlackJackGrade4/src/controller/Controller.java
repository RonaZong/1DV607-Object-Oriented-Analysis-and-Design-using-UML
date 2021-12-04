package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Card;
import model.Game;
import model.ICardObserver;
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

    private Image[] deckBack = {new Image("view/PNG/blue_back.png"), new Image("view/PNG/gray_back.png"), new Image("view/PNG/green_back.png"),
            new Image("view/PNG/purple_back.png"), new Image("view/PNG/red_back.png"), new Image("view/PNG/yellow_back.png")};

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
    private Label PlayerWin;

    @FXML
    private Label DealerWin;


//    @FXML
//    private ImageView gettingCard;
//
//    @FXML
//    private Text GameOver;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.factory = new Soft17InternationalDealerFactory();
        this.iVisitor = new PrintVisitor();
        this.a_game = new Game(factory, iVisitor);
        this.a_game.SubscriptionToNewCards(this);
        Hit.setDisable(true);
        Stand.setDisable(true);
        PlayerWin.setVisible(false);
        DealerWin.setVisible(false);
        DeckBack();
    }

    @Override
    public void updateNewCard(Card card) {
        Pause();
    }

    public void showPlayerHand() {
        ImageView[] playerCards = {PlayerCard1,PlayerCard2,PlayerCard3,PlayerCard4,PlayerCard5,PlayerCard6};
        ImageView[] dealerCards = {DealerCard1,DealerCard2,DealerCard3,DealerCard4,DealerCard5,DealerCard6};

        for(ImageView iv : playerCards)
            iv.setVisible(false);
        for (ImageView iv : dealerCards)
            iv.setVisible(false);
        int i = 0;
        int j = 0;
        for(Card card : a_game.GetDealerHand()){

            this.card = new Image("view/PNG/" + card.GetValue()+card.GetColor() + ".png");
            // Pause();
            dealerCards[i].setVisible(true);
            dealerCards[i++].setImage(this.card);
            //Pause();
        }
        for(Card card : a_game.GetPlayerHand()){

            this.card = new Image("view/PNG/" + card.GetValue()+card.GetColor() + ".png");
            playerCards[j].setVisible(true);
            playerCards[j++].setImage(this.card);
            // Pause();
        }


    }

    @FXML
    void PlayNewGame() {

        PlayerWin.setVisible(false);
        DealerWin.setVisible(false);
       // GameOver.setText("");
        Hit.setDisable(false);
        Stand.setDisable(false);
        this.a_game.NewGame();
        showPlayerHand();
        //updateNewCard();

        PlayerScore.setText(String.valueOf(a_game.GetPlayerScore()));
        DealerScore.setText(String.valueOf(a_game.GetDealerScore()));
    }

    @FXML
    void Hit() throws IOException {
            this.a_game.Hit();
            showPlayerHand();
            PlayerScore.setText(String.valueOf(a_game.GetPlayerScore()));
            DealerScore.setText(String.valueOf(a_game.GetDealerScore()));
    }

    @FXML
    void Stand() throws IOException {
            Hit.setDisable(true);
            this.a_game.Stand();
            DeckBack();
            showPlayerHand();
            PlayerScore.setText(String.valueOf(a_game.GetPlayerScore()));
            DealerScore.setText(String.valueOf(a_game.GetDealerScore()));
            gameOver();
    }

    private void DeckBack() {
        this.Deck.setImage(deckBack[(int)(Math.random() * 6)]);
    }

    private void gameOver() {
        if (this.a_game.IsGameOver()) {
            Stand.setDisable(true);
            //GameOver.setText(DisplayGameOver(this.a_game.IsDealerWinner()));
            DisplayGameOver(this.a_game.IsDealerWinner());
        }
    }

    public void DisplayGameOver(boolean a_dealerIsWinner)
    {
        if (a_dealerIsWinner) {
            DealerWin.setVisible(true);
        }
        else {
            PlayerWin.setVisible(true);
        }
    }

//    public String DisplayGameOver(boolean a_dealerIsWinner)
//    {
//        if (a_dealerIsWinner) {
//            return "Dealer Won!";
//        }
//        else {
//            return "You Won!";
//        }
//    }

    public void Pause(){
        try{
            Thread.sleep(200);
        }catch (Exception e){}
    }


}
