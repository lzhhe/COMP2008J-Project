package card.actionCard;

import card.CardKind;
import general.Player;
import card.Card;

public class PassGo extends ActionCard {
    public PassGo(int value, String name, CardKind cardkind) {
        super(value, name, cardkind);
    }

    public void use(Player user,Player target,Card card){
        for(int i=0; i<2; i++){
            if(user.getDecks().size()<7){//deck amount must less than 7
                user.drawCard(card);
            }
        }

    }
}
