package card.actionCard;

import card.CardKind;
import general.Player;

public class SayNo extends ActionCard{
    public SayNo() {
        super(4, "SayNo", CardKind.SayNo);
    }

    public void use(Player user,Player target){
        user.setBlocked();
    }
}
