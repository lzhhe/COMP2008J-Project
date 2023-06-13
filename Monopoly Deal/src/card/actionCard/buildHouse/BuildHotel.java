package card.actionCard.buildHouse;

import card.CardKind;
import card.actionCard.ActionCard;
import card.propertyCard.PropertyCard;
import card.propertyCard.wildCard.WildCard;
import general.Colour;
import general.Player;

import java.util.ArrayList;

public class BuildHotel extends ActionCard implements Build{

    public BuildHotel() {
        super(4, "BuildHotel", CardKind.BuildHotel);
    }



    //it may bind with the colour in the game

    public void use (Player user,  Colour colour){

        if (user.propertiesByColour.get(colour).get(0).addHouse) {
            ArrayList<PropertyCard> tempArrayList = user.propertiesByColour.get(colour);

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
