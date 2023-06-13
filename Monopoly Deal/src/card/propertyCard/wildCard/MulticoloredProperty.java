package card.propertyCard.wildCard;

import card.CardKind;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Player;

import java.util.ArrayList;

public class MulticoloredProperty extends PropertyCard{
    public MulticoloredProperty() {
        super(0, "MulticoloredProperty", CardKind.MulticoloredProperty,new int[0],null);
    }
    //In initialization, not any specific parameter to avoid some trouble (not sure)
    //value is 0 forever

    public void flip(Player player, Colour newColour){// user need input a colour to avoid null before using
        if (player.propertiesByColour.get(this.colour).isEmpty()){
            System.out.print("You can not flip, you have not any property card in this colour");
        }else{
            if (this.colour!=null){//have been put in other colour need to be removed
                ArrayList<PropertyCard> tempArrayList = player.propertiesByColour.get(this.colour);
                tempArrayList.remove(this);

            }
            this.colour = newColour;
            switch(newColour){
                case RAILROAD:
                    rentList = new int[]{1, 2, 3, 4};
                    break;
                case RED:
                    rentList = new int[]{2,3,6};
                    break;
                case BLUE:
                    rentList = new int[]{3,8};
                    break;
                case LIGHT_BLUE:
                    rentList = new int[]{1,2,3};
                    break;
                case UTILITY:
                    rentList = new int[]{1,2};
                    break;
                case BROWN:
                    rentList = new int[]{1,2};
                    break;
                case GREEN:
                    rentList = new int[]{2,4,7};
                    break;
                case YELLOW:
                    rentList = new int[]{2,4,6};
                    break;
                case ORANGE:
                    rentList = new int[]{1,3,5};
                    break;
                case PINK:
                    rentList = new int[]{1,2,4};
                    break;
            }

            ArrayList<PropertyCard> tempArrayList = player.propertiesByColour.get(newColour);
            tempArrayList.add(this);
            player.propertiesByColour.replace(newColour,tempArrayList);



        }
    }

    public void use(Player player){
        super.use(player);
    }

}
