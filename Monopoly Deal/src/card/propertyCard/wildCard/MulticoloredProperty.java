package card.propertyCard.wildCard;

import card.CardKind;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Player;

public class MulticoloredProperty extends PropertyCard{
    public MulticoloredProperty() {
        super(0, "MulticoloredProperty", CardKind.MulticoloredProperty,new int[0],null);
    }
    //In initialization, not any specific parameter to avoid some trouble (not sure)
    //value is 0 forever

    public void flip(Player player, Colour colour){// user need input a colour to avoid null before using
        if (player.propertiesByColour.isEmpty()){
            System.out.print("You can not flip, you have not any property card");
        }else{
            this.colour=colour;
            switch(colour){
                case RAILROAD:
                    rentList = new int[]{1, 2, 3, 4};
                case RED:
                    rentList = new int[]{2,3,6};
                case BLUE:
                    rentList = new int[]{3,8};
                case LIGHT_BLUE:
                    rentList = new int[]{1,2,3};
                case UTILITY:
                    rentList = new int[]{1,2};
                case BROWN:
                    rentList = new int[]{1,2};
                case GREEN:
                    rentList = new int[]{2,4,7};
                case YELLOW:
                    rentList = new int[]{2,4,6};
                case ORANGE:
                    rentList = new int[]{1,3,5};
                case PINK:
                    rentList = new int[]{1,2,4};
            }

        }
    }

}
