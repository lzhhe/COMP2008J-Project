package card.actionCard.steal;

import card.CardKind;
import card.actionCard.ActionCard;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Player;

import java.util.ArrayList;

public class DealBreaker extends ActionCard implements Steal {


    public DealBreaker() {
        super(5, "DealBreaker", CardKind.DealBreaker);
    }

    @Override
    public void use(Player user, Player target, Colour colour) {
        if (target.whetherSayNo()){
            user.decks.remove(this);
            return;
        }


        ArrayList<PropertyCard> targetList = target.propertiesByColour.get(colour);
        target.propertiesByColour.remove(colour);
        //here is may have some bugs, it the user have the colour property like wildCard, it may have some trouble
        //have fixed up
        if (user.propertiesByColour.containsKey(colour)){
            ArrayList<PropertyCard> originalList = user.propertiesByColour.get(colour);
            originalList.addAll(targetList);
            user.propertiesByColour.replace(colour, originalList);
        }else{
            user.propertiesByColour.put(colour,targetList);
        }

        user.decks.remove(this);



    }
}
