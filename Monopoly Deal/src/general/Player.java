package general;

import card.Card;
import card.moneyCard.MoneyCard;
import card.propertyCard.PropertyCard;
import static general.Game.*;

import java.time.LocalDate;
import java.util.*;

//import java.time.LocalDate;


public class Player {

    public String name;

    public LocalDate birth;

    public ArrayList<Card> bankCount = new ArrayList<>();

    public ArrayList<Card> decks = new ArrayList<>();

    public boolean doubleRent;
    public int block = 0;// say no



    //give up use an ArrayList and change to use Hashmap
    //public ArrayList<PropertyCard> properties;

    public HashMap<Colour, ArrayList<PropertyCard>> propertiesByColour = new HashMap<>();



    public Player(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
        this.doubleRent = false;
        decks = new ArrayList<>();
    }



    @Override
    public String toString() {
        return "Player: "+name;

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

    public int totalValue(){
        return calculateCount()+calculateProperty();
    }






    //have problem

    //test code;
    public void bank(Card card){
        bankCount.add(card);
        decks.remove(card);
    }

    //the card to pay for rent
    /*public void pay (ArrayList<Card> demand){
        for (Card card: demand){
            if (card instanceof MoneyCard){
                bankCount.remove(card);
            } else if (card instanceof PropertyCard) {
                Colour colour = ((PropertyCard) card).colour;//maybe problem
                ArrayList<PropertyCard> colourArrayList = propertiesByColour.get(colour);
                colourArrayList.remove(card);
                propertiesByColour.replace(colour,colourArrayList);
            } else {
                throw new IllegalArgumentException("this card is not in this player deck, it must be bugs");
            }
        }
    }*/

    public void pay (int rentValue){

        //check the total value
        if (totalValue()==0){

        }

    }

    public void deleteCard(){
        while (decks.size()>7){
            System.out.println("cards in your deck is over 7 please select and drop them");
            printDeck();
            Card temp = selectCardInDeck();
            decks.remove(temp);
            discard.add(temp);

        }
    }




    public Card selectCardInDeck(){

        Scanner in = new Scanner(System.in);
        int index = in.nextInt()-1;
        if(index>decks.size()-1){
            System.out.println("it is out of index of your decks, please try again");
            return selectCardInDeck();
        }else{
            return decks.get(index);
        }

    }

    public void selectBankAndProperty(){}



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





    //we override toString method and use in here
    //but in other print method it is unnecessary to print all information
    public void printDeck(){
        String str = "your deck: "+"\n";
        int i=1;
        for (Card card : decks){
            str = str+"["+i+"]"+card.toString()+"\n";
            i++;

        }
        str=str+"\n";
        System.out.println(str);
    }

    public void printBank(){
        String str = "your bank account: ";
        for (Card moneyCard:bankCount){
            //here just to check value
            str = str + moneyCard.value+" ";

        }

        str=str+"\n";
        System.out.println(str);
    }

    public void printProperty(){
        String colourName;
        int number;
        Colour colour;
        String str = "your Property: ";

        for (Colour value : propertiesByColour.keySet()) {
            colour = value;
            colourName = colour.name();
            number = propertiesByColour.get(colour).size();
            str = str + colourName+": " + number + " ";


        }
        str=str+"\n";
        System.out.println(str);

    }

    public void printInformation(){
        printDeck();
        //System.out.println("\n");
        printBank();
        //System.out.println("\n");
        printProperty();
        //System.out.println("\n");
    }







}
