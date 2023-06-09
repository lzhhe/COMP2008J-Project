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
        if (target.whetherSayNo()){
            return;
        }



        PropertyCard targetPropertyCard = target.propertiesByColour.get(colour).get(0);

        if (user.propertiesByColour.containsKey(colour)){
            ArrayList<PropertyCard> originalList = user.propertiesByColour.get(colour);
            originalList.add(targetPropertyCard);
            user.propertiesByColour.replace(colour, originalList);
        }else{
            ArrayList<PropertyCard> newList = new ArrayList<>();
            newList.add(targetPropertyCard);
            user.propertiesByColour.put(colour,newList);
        }

        ArrayList<PropertyCard> tempArrayList = target.propertiesByColour.get(colour);
        tempArrayList.remove(targetPropertyCard);
        target.propertiesByColour.replace(colour,tempArrayList);


        user.decks.remove(this);

    }
}
