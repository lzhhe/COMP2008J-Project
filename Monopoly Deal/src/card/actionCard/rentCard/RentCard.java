package card.actionCard.rentCard;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Colour;
import general.Player;

import java.awt.*;

public class RentCard extends ActionCard implements Rent{

    Colour colour1;
    Colour colour2;


    public RentCard(Colour colour1,Colour colour2) {
        //maybe some question
        super(1,"RentCard",CardKind.RectCard);
        this.colour1 = colour1;
        this.colour2 = colour2;


    }



    @Override
    public void use(Player user, Player target, Colour colour) {

    }




    ;



}
