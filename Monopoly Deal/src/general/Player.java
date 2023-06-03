package general;

import card.Card;
import card.moneyCard.MoneyCard;
import card.propertyCard.PropertyCard;
import static general.Game.*;
import java.util.ArrayList;
import java.util.HashMap;

//import java.time.LocalDate;


public class Player {

    public String name;

    //LocalDate birth;

    public ArrayList<Card> bankCount=new ArrayList<>();

    public ArrayList<Card> decks;
    private Game monopolygame;

    static int j = 0;
    Round r = new Round();

    //give up use an ArrayList and change to use Hashmap
    //public ArrayList<PropertyCard> properties;

    public HashMap<Colour, ArrayList<PropertyCard>> propertiesByColour = new HashMap<>();



    public Player(String name, Game monopolygame) {
        this.name = name;
        this.monopolygame = monopolygame;
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

//    public void dealcards(int num) {
//        if (r.getRound() % 3 == 1) {
//            for (int i = 0; i < num; i++) {
//                player1.decks.add(monopolygame.getDeck().getCards().pop());
//                j++;
//            }
//        } else if (r.getRound() % 3 == 2) {
//            for (int i = 0; i < num; i++) {
//                player2.decks.add(monopolygame.getDeck().getCards().pop());
//                j++;
//            }
//        } else {
//            for (int i = 0; i < num; i++) {
//                player3.decks.add(monopolygame.getDeck().getCards().pop());
//                j++;
//            }
//        }
//    }

//tian:有报错，写test暂时先注释掉，等写的时候恢复
//   public void dealcards() {
//        for (int i = 0; i < 5; i++) {
//            decks.add(monopolygame.getDeck().getCards().pop());
//        }
//    }
//
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
