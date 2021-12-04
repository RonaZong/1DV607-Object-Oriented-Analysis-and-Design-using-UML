package model;

import model.rules.*;
import model.rules.hitStrategy.IHitStrategy;
import model.rules.newGameStartegy.INewGameStrategy;
import model.rules.winnerStrategy.IWinnerStrategy;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinnerStrategy m_winRule;

  public Dealer(RulesAbstractFactory a_rulesAbstractFactory, IVisitor iVisitor) {
  
    m_newGameRule = a_rulesAbstractFactory.GetNewGameRule();
    m_hitRule = a_rulesAbstractFactory.GetHitRule();
    m_winRule = a_rulesAbstractFactory.GetWinnerStrategy();

    m_newGameRule.accept(iVisitor);
    m_hitRule.accept(iVisitor);
    m_winRule.accept(iVisitor);

  }


  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(this, a_player);
    }
    return false;
  }

  public void getCard(Player dealer, boolean show) {
    Card card = m_deck.GetCard();
    card.Show(show);
    dealer.DealCard(card);
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      getCard(a_player,true);
      return true;
    }
    return false;
  }

  /** Rona added */
  public boolean Stand() {
    if (m_deck != null) {
      ShowHand();

      while (m_hitRule.DoHit(this)) {
        getCard(this,true);
      }
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {

    return m_winRule.isDealerWinner(CalcScore(),a_player.CalcScore(),g_maxScore);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }
  
}