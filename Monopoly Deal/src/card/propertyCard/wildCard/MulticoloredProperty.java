package card.propertyCard.wildCard;

import card.CardKind;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Player;

import java.util.ArrayList;



public class MulticoloredProperty extends PropertyCard{
    public MulticoloredProperty() {
        super(0, "MulticoloredProperty", CardKind.MulticoloredProperty,new int[0],Colour.NOCOLOUR);
    }
    //In initialization, not any specific parameter to avoid some trouble (not sure)
    //value is 0 forever

    PropertyCard blue = new PropertyCard(4,"Blue1",CardKind.PropertyCard,new int[]{3,8},Colour.BLUE);

    PropertyCard brown = new PropertyCard(1,"Brown1",CardKind.PropertyCard,new int[]{1,2},Colour.BROWN);

    PropertyCard utility = new PropertyCard(1,"Utility1",CardKind.PropertyCard,new int[]{1,2},Colour.UTILITY);

    PropertyCard green = new PropertyCard(4,"Green1",CardKind.PropertyCard,new int[]{2,4,7},Colour.GREEN);

    PropertyCard yellow = new PropertyCard(3,"Yellow1",CardKind.PropertyCard,new int[]{2,4,6},Colour.YELLOW);

    PropertyCard red = new PropertyCard(3,"Red1",CardKind.PropertyCard,new int[]{2,3,6},Colour.RED);

    PropertyCard orange = new PropertyCard(2,"Orange1",CardKind.PropertyCard,new int[]{1,3,5},Colour.ORANGE);


    PropertyCard pink = new PropertyCard(2,"Pink1",CardKind.PropertyCard,new int[]{1,2,4},Colour.PINK);

    PropertyCard lightBlue = new PropertyCard(1,"lightBlue1",CardKind.PropertyCard,new int[]{1,2,3},Colour.LIGHT_BLUE);

    PropertyCard railroad = new PropertyCard(1,"RailRoad1",CardKind.PropertyCard,new int[]{1,2,3,4},Colour.RAILROAD);

    public void flip(Player player, Colour newColour){// user need input a colour to avoid null before using
        if (!player.propertiesByColour.containsKey(newColour)){
            System.out.print("You can not flip, you have not any property card in this colour");
        }else{
            ArrayList<PropertyCard> tempArrayList = player.propertiesByColour.get(this.colour);
            tempArrayList.remove(this);
            player.propertiesByColour.replace(this.colour,tempArrayList);

            this.colour = newColour;
            switch(newColour){
                case RAILROAD:
                    update(railroad);
                    break;
                case RED:
                    update(red);
                    break;
                case BLUE:
                    update(blue);
                    break;
                case LIGHT_BLUE:
                    update(lightBlue);
                    break;
                case UTILITY:
                    update(utility);
                    break;
                case BROWN:
                    update(brown);
                    break;
                case GREEN:
                    update(green);
                    break;
                case YELLOW:
                    update(yellow);
                    break;
                case ORANGE:
                    update(orange);
                    break;
                case PINK:
                    update(pink);
                    break;
            }

            tempArrayList = player.propertiesByColour.get(newColour);
            tempArrayList.add(this);
            player.propertiesByColour.replace(newColour,tempArrayList);



        }
    }

    public void use(Player player){
        super.use(player);
    }

    public void update(PropertyCard propertyCard){
        this.fullSets = propertyCard.fullSets;
        this.rentList = propertyCard.rentList;
        this.colour = propertyCard.colour;
        if (colour == Colour.UTILITY || colour == Colour.RAILROAD){
            addHouse = false;
        }

    }

}
