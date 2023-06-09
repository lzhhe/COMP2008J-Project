package card.actionCard.singleChoice;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Player;

import java.util.ArrayList;

public class DebtCollector extends ActionCard implements SingleChoice {

    public DebtCollector() {
        super(3,"DebtCollector", CardKind.DebtCollector);
    }


    @Override
    public void use(Player user,Player target) {

        if (target.whetherSayNo()){
            return;
        }else{
            target.pay(5,user);
        }

    }
}
