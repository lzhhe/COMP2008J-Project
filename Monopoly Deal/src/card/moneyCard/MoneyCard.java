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
    public void Bank(Player player) {
        player.bankCount.add(this);
    }

    @Override
    public String toString() {
        return "MoneyCard{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
