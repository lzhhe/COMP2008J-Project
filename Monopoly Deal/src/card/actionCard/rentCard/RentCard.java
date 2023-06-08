package card.actionCard.rentCard;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Colour;
import general.Player;

import java.awt.*;

public class RentCard extends ActionCard implements Rent{


    public RentCard() {
        super(1,"RentCard",CardKind.RectCard);

    }



    @Override
    public void use(Player user, Player target, Colour colour) {

    }




    ;



}
