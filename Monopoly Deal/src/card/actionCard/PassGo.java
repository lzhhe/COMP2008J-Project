package card.actionCard;

import card.CardKind;
import general.Player;
import card.Card;

import static general.Game.cardLibrary;

public class PassGo extends ActionCard {
    public PassGo() {
        super(1, "PassGo", CardKind.PassGo);
    }

    public void use(Player user){


        for (int i=0; i<2;i++){
            Card card= cardLibrary.pop();
            user.decks.add(card);
        }

        user.decks.remove(this);

    }
}
