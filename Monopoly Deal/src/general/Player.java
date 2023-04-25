package general;

import card.Card;
import card.moneyCard.MoneyCard;
import card.propertyCard.PropertyCard;

import java.util.ArrayList;
import java.util.HashMap;

//import java.time.LocalDate;


public class Player {

    public String name;

    //LocalDate birth;

    public ArrayList<Card> bankCount;

    public ArrayList<Card> decks;

    //give up use an ArrayList and change to use Hashmap
    //public ArrayList<PropertyCard> properties;

    public HashMap<Colour, ArrayList<PropertyCard>> propertiesByColour = new HashMap<>();


    protected int calculateCount(){
        int value = 0;
        for(Card card : bankCount){
            value+=card.value;
        }
        return value;

    }

    protected int calculateProperty(){
        int value = 0;
        for(ArrayList<PropertyCard> properties: propertiesByColour.values()){
            for (PropertyCard properCard: properties){
                value+=properCard.value;
            }
        }
        return value;
    }

    protected int totalValue(){
        return calculateCount()+calculateProperty();
    }

    //Draw cards from the library but not delete in the library
    protected void drawCard (Card card){
        decks.add(card);
    }

    //have problem
    protected void useCard(Card card){

        card.use();

        //need a condition to check whether it is finished the process
        //in case someone is not target or someone can not afford

        decks.remove(card);
    }

    //the card to pay for rent
    public void pay (ArrayList<Card> demand){
        for (Card card: demand){
            if (card.getClass()== MoneyCard.class){
                bankCount.remove(card);
            } else if (card.getClass()==PropertyCard.class) {
                Colour colour = ((PropertyCard) card).colour;//maybe problem
                ArrayList<PropertyCard> colourArrayList = propertiesByColour.get(colour);
                colourArrayList.remove(card);
            } else {
                throw new IllegalArgumentException("this card is not in this player deck, it must be bugs");
            }
        }
    }

    public void deleteCard(){
        if (decks.size()>7){
            //wait player choose


        }
    }

    //here need to deal with the extra property: like single colour is full but still has a same colour wild card


    public boolean completeSet(ArrayList<PropertyCard> propertyCards){
        int numberOfFullSets = propertyCards.get(0).fullSets;
        return propertyCards.size() >= numberOfFullSets;

    }

    //check if the player has 3 full sets
    public boolean winGame(){

        int count = 0;
        for (ArrayList<PropertyCard> propertyCards : propertiesByColour.values()){
            if (completeSet(propertyCards)){
                count++;
            }
        }

        return count==3;
    }






}
