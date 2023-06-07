package card.actionCard.buildHouse;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Colour;
import general.Player;

public class BuildHouse  extends ActionCard implements Build{

    public BuildHouse(){
        super(3, "BuildHouse", CardKind.BuildHouse);
    }
    @Override
    public void use(Player user, Colour colour) {

    }

    public void remove (){}//optional
}
