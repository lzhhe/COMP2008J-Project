package card.actionCard;

import card.CardKind;

import general.Player;

public class DoubleRent extends ActionCard{

    public DoubleRent() {

        super(1,"DoubleRent", CardKind.DoubleRent);
    }

    public void use(Player user,Player target){
        user.setDoubleRent(true);
    }
}
