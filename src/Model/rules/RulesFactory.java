package Model.rules;

public class RulesFactory {
    public HitStrategy GetHitRule() {
        return new BasicHitStrategy();
    }

    public NewGameStrategy GetNewGameRule() {
        return new AmericanNewGameStrategy();
    }

    // TODO: variable rule for who wins the game
}
