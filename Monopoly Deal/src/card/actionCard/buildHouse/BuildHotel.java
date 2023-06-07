package card.actionCard.buildHouse;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Colour;
import general.Player;

public class BuildHotel extends ActionCard implements Build{

    public BuildHotel() {
        super(4, "BuildHotel", CardKind.BuildHotel);
    }

    @Override
    public void use (Player user,  Colour colour){


    }

    public void remove (){}//optional
}
