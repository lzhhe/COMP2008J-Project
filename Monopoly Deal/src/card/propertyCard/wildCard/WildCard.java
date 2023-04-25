package card.propertyCard.wildCard;

import card.CardKind;
import card.propertyCard.PropertyCard;
import general.Colour;

public class WildCard extends PropertyCard{
    public Colour otherColour;
    int otherFullSets;
    int[] otherRentList;

    public WildCard(int value, String name, int[] rentList, Colour colour, int[] otherRentList, Colour otherColour) {
        super(value, name, CardKind.WildCard, rentList, colour);
        this.otherColour = otherColour;
        this.otherFullSets = otherRentList.length;
        this.otherRentList = otherRentList;
    }



    public void flip() {
        Colour temp1 = colour;
        int temp2 = fullSets;
        int[] temp3 = rentList;

        colour = otherColour;
        fullSets = otherFullSets;
        rentList = otherRentList;

        otherColour = temp1;
        otherFullSets = temp2;
        otherRentList = temp3;
    }




}
