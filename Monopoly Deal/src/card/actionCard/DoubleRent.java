package card.actionCard;

import card.CardKind;

import general.Player;

public class DoubleRent extends ActionCard{

    public DoubleRent(int value, String name, CardKind cardkind) {

        super(value, name, cardkind);
    }

    public void use(Player user,Player target){
        user.setDoubleRent(true);
    }
}
