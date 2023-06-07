package card.actionCard.demandMoney;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Player;

import java.util.ArrayList;

public class BirthdayCard extends ActionCard implements Demand{
    public BirthdayCard() {
        super(2, "BirthdayCard",CardKind.BirthdayCard);
    }

    @Override
    public void use(ArrayList<Player> playerList) {



    }


}
