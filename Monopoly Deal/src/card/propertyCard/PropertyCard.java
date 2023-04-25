package card.propertyCard;

import card.Card;
import card.CardKind;
import general.Colour;
import general.Player;

public class PropertyCard extends Card {

    public int fullSets;//after improving , this variable may not be inserted by user, it depends on the length of rentList
    public Colour colour;
    public int[] rentList;//depend on the number in fullSets
    public boolean addHouse = true;


    public PropertyCard(int value, String name, CardKind cardkind, int[] rentList,Colour colour){
        super(value, name, cardkind);//the value is on the up-left side value
        this.fullSets = rentList.length;
        this.rentList = rentList;//one house ... dollars, two houses ... dollars, three houses ... dollars(optional)
        this.colour = colour;// from Colour Enum
        if (colour == Colour.LIGHT_GREEN || colour==Colour.BLACK){//industry can nor add house or hotel
            addHouse = false;
        }

    }

    public void use(Player player){
        player.properties.add(this);
    }

    public Colour getColour(){
        return colour;
    }

    public boolean getAddHouse(){
        return addHouse;
    }






}
