package card.actionCard;

import card.Card;
import card.CardKind;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Player;

import java.util.ArrayList;

public class ForcedDeal extends ActionCard{
    public ForcedDeal() {
        super(3, "ForcedDeal" , CardKind.ForceDeal);
    }


    public void use(Player user, Player target, Colour colour, Colour targetColour) {
        if (target.whetherSayNo()){
            user.decks.remove(this);//need to add otherwise it may happen nothing
            return;
        }
        exchangeProperty(user, target, colour);

        exchangeProperty(target, user, targetColour);




    }

    public void exchangeProperty(Player user, Player target, Colour colour){


        PropertyCard targetPropertyCard = target.propertiesByColour.get(colour).get(0);//defalut is first//it need to consider the wild card

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

    }
}
