package card.actionCard;

import card.CardKind;
import general.Player;

public class SayNo extends ActionCard{
    public SayNo(int value, String name) {
        super(value, name, CardKind.SayNo);
    }

    public void use(Player user,Player target){
        user.setBlocked();
    }
}
