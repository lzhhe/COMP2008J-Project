package card.actionCard.demandMoney;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Player;

import java.util.ArrayList;

public class DebtCollector extends ActionCard implements Demand{

    public DebtCollector() {
        super(3,"DebtCollector", CardKind.DEBTCOLLECTOR);
    }



    @Override
    public void use(ArrayList<Player> playerList) {

    }
}
