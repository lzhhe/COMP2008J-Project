package card.actionCard.steal;

import card.CardKind;
import card.actionCard.ActionCard;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Player;

import java.util.ArrayList;

public class StealDeal extends ActionCard  implements Steal {
    public StealDeal() {
        super(3, "StealDeal", CardKind.StealDeal);
    }

    @Override
    public void use(Player user, Player target, Colour colour) {
        PropertyCard targetPropertyCard = target.propertiesByColour.get(colour).get(0);

        ArrayList<PropertyCard> targetOriginalList = target.propertiesByColour.get(colour);
        targetOriginalList.add(targetPropertyCard);
        target.propertiesByColour.replace(colour,targetOriginalList);

        if (user.propertiesByColour.containsKey(colour)){
            ArrayList<PropertyCard> originalList = user.propertiesByColour.get(colour);
            originalList.add(targetPropertyCard);
            user.propertiesByColour.replace(colour, originalList);
        }else{
            ArrayList<PropertyCard> newList = new ArrayList<>();
            newList.add(targetPropertyCard);
            user.propertiesByColour.put(colour,newList);
        }

        user.decks.remove(this);
    }
}
