package card.actionCard.aoe;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Player;

import java.util.ArrayList;
import java.util.Objects;

public class BirthdayCard extends ActionCard implements AOE {
    public BirthdayCard() {
        super(2, "BirthdayCard",CardKind.BirthdayCard);
    }

    @Override
    public void use(ArrayList<Player> playerList, Player user) {
        for (Player player : playerList){
            if (Objects.equals(user,player)){
                continue;
            }
            if (player.whetherSayNo()){
                continue;
            }else{
                player.pay(2,user);
            }
        }
        user.decks.remove(this);



    }


}
