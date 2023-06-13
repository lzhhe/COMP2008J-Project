package card.actionCard.buildHouse;

import card.CardKind;
import card.actionCard.ActionCard;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Player;

import java.util.ArrayList;

public class BuildHouse  extends ActionCard implements Build{

    public BuildHouse(){
        super(3, "BuildHouse", CardKind.BuildHouse);
    }
    @Override
    public void use(Player user, Colour colour) {
        if (user.completeSet(user.propertiesByColour.get(colour))&&(colour!=Colour.RAILROAD || colour!=Colour.UTILITY)) {
            ArrayList<PropertyCard> tempArrayList = user.propertiesByColour.get(colour);
            //maybe need consider different type
            //however it may have some problem
            int[] tempArr;
            for (PropertyCard propertyCard : tempArrayList) {
                tempArr = propertyCard.rentList;
                tempArr[propertyCard.fullSets-1] = tempArr[propertyCard.fullSets-1] + 3;
                propertyCard.addHouse = true;
                System.out.println("new rent value is " + tempArr[propertyCard.fullSets-1]);
            }


        }else{
            System.out.println("The color does not meet the requirements of adding house.");
        }




    }


}
