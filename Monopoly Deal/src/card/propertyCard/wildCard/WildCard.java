package card.propertyCard.wildCard;

import card.CardKind;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Player;

import java.util.ArrayList;
import java.util.Scanner;

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

    public void use(Player player){
        //System.out.println("wildCard method");
        /*if (player.propertiesByColour.containsKey(colour)){
            ArrayList<PropertyCard>newList = player.propertiesByColour.get(colour);
            newList.add(this);
            player.propertiesByColour.replace(colour,newList);
        }else{
            ArrayList<PropertyCard> tempArrayList = new ArrayList<PropertyCard>();
            tempArrayList.add(this);
            player.propertiesByColour.put(colour,tempArrayList);
        }*/
        super.use(player);

        player.decks.remove(this);
    }



    public void flip(Player player) {

        if (player.propertiesByColour.containsKey(colour)) {
            ArrayList<PropertyCard> tempArrayList = player.propertiesByColour.get(colour);
            if (tempArrayList != null) {
                tempArrayList.remove(this);
                player.propertiesByColour.replace(colour, tempArrayList);
            }
        }

        Colour temp1 = colour;
        int temp2 = fullSets;
        int[] temp3 = rentList;

        colour = otherColour;
        fullSets = otherFullSets;
        rentList = otherRentList;

        otherColour = temp1;
        otherFullSets = temp2;
        otherRentList = temp3;

        super.use(player);
    }

}





