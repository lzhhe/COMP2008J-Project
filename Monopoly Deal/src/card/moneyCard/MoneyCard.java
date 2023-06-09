package card.moneyCard;

import card.Bank;
import card.Card;
import card.CardKind;
import general.Player;

public class MoneyCard extends Card implements Bank {

    public MoneyCard(int value, String name) {
        super(value, name, CardKind.MoneyCard);
    }

    @Override
    public void bank(Player player) {
        player.bankCount.add(this);
        player.decks.remove(this);
    }


}
