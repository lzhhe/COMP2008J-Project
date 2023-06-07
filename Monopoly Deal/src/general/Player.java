package general;

import card.Card;
import card.moneyCard.MoneyCard;
import card.propertyCard.PropertyCard;
import static general.Game.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

//import java.time.LocalDate;


public class Player {

    public String name;

    public LocalDate birth;

    public ArrayList<Card> bankCount=new ArrayList<>();

    public ArrayList<Card> decks=new ArrayList<>();
    public Game monopolygame=new Game();

    public boolean doubleRent;
    public int block = 0;// say no



    //give up use an ArrayList and change to use Hashmap
    //public ArrayList<PropertyCard> properties;

    public HashMap<Colour, ArrayList<PropertyCard>> propertiesByColour = new HashMap<>();



    public Player(String name, Game monopolygame, LocalDate birth) {
        this.name = name;
        this.monopolygame = monopolygame;
        this.birth = birth;
        this.doubleRent = false;
        decks = new ArrayList<>();
    }

//    public Player(String name) {
//        this.name = name;
//        decks = new ArrayList<>();
//    }

    @Override
    public String toString() {
        return "Player{" +
                "decks=" + decks +
                '}';
    }



    public int calculateCount(){
        int value = 0;
        for(Card card : bankCount){
            value+=card.value;
        }
        return value;
    }

    public int calculateProperty(){
        int value = 0;
        for(ArrayList<PropertyCard> properties: propertiesByColour.values()){
            for (PropertyCard properCard: properties){
                value+=properCard.value;
            }
        }
        return value;
    }

    public ArrayList<PropertyCard> getAllProperties() {
        ArrayList<PropertyCard> allProperties = new ArrayList<>();

        for (ArrayList<PropertyCard> properties : propertiesByColour.values()) {
            allProperties.addAll(properties);
        }

        return allProperties;
    }

    public int totalValue(){
        return calculateCount()+calculateProperty();
    }

    //inout some inforamtion


    //Draw cards from the library but not delete in the library
    public void drawCard (Card card){
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
            if (card instanceof MoneyCard){
                bankCount.remove(card);
            } else if (card instanceof PropertyCard) {
                Colour colour = ((PropertyCard) card).colour;//maybe problem
                ArrayList<PropertyCard> colourArrayList = propertiesByColour.get(colour);
                colourArrayList.remove(card);
            } else {
                throw new IllegalArgumentException("this card is not in this player deck, it must be bugs");
            }
        }
    }

    public void deleteCard(){
        while (decks.size()>7){
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

    public void selectCardInDeck(String cardName){

    }






    public ArrayList<Card> getDecks() {
        return this.decks;
    }

    public void setBlocked(){
        this.block=2;
    }

    public boolean isBlocking(){
        return this.block>0;
    }


    public boolean isDoubleRent(){
        return this.doubleRent;
    }

    public void setDoubleRent(boolean b){
        this.doubleRent = b;
    }


    public void printDeck(){
        for (Card card : decks){
            System.out.print(card.toString()+" ");
        }
    }

    public void printBank(){
        for (Card moneyCard:bankCount){
            System.out.print(moneyCard.toString()+" ");
        }

    }

    public void printProperty(){

    }

    public void printInformation(){
        printDeck();
        System.out.println("\n");
        printBank();
        System.out.println("\n");
        printProperty();
        System.out.println("\n");
    }






}
