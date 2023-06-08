package card.actionCard;

import card.Bank;
import card.Card;
import card.CardKind;
import general.Player;

public abstract class ActionCard extends Card implements Bank {



    public ActionCard (int value, String name, CardKind cardkind){
        super(value, name, cardkind);

    }

    @Override
    public void bank(Player player) {
        player.bankCount.add(this);
        player.decks.remove(this);
    }

    public void use(){}
}
