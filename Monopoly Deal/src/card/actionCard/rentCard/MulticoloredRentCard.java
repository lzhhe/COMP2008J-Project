package card.actionCard.rentCard;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Colour;
import general.Player;

import java.awt.*;

public class MulticoloredRentCard extends ActionCard implements Rent{


    public MulticoloredRentCard() {
        super(3, "MulticoloredRentCard", CardKind.MulticoloredRentCard);
    }

    @Override
    public void use(Player user, Player target, Colour colour) {

    }



}
