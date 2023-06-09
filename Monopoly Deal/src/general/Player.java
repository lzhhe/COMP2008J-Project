package general;

import card.Card;
import card.moneyCard.MoneyCard;
import card.propertyCard.PropertyCard;
import card.propertyCard.wildCard.WildCard;

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

    public void bank(Card card){
        bankCount.add(card);
        decks.remove(card);
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

    public Card selectBankAndProperty(){
        Scanner in = new Scanner(System.in);
        Action action = Action.valueOf(in.next());
        Card card = null;
        int orderValue;
        switch (action){
            case CASH:
                System.out.println("Please insert value of cash");
                in = new Scanner(System.in);
                orderValue = in.nextInt();
                for (Card moneyCard : bankCount){
                    if (moneyCard.value==orderValue){
                        card = moneyCard;
                        bankCount.remove(card);
                        return card;
                    }
                }
                break;
            case PROPERTY:
                System.out.println("Please insert a colour and value(to decide use wildcard or not)");
                in = new Scanner(System.in);
                Colour colour = Colour.valueOf(in.next());
                orderValue = in.nextInt();
                ArrayList<PropertyCard> tempArrayList= propertiesByColour.get(colour);
                for (PropertyCard propertyCard: tempArrayList){
                    if (propertyCard.value==orderValue){
                        card = propertyCard;
                        tempArrayList.remove(propertyCard);
                        propertiesByColour.replace(colour,tempArrayList);
                        return card;
                    }
                }

                break;
        }
        //to finish, if the user insert a correct value it can not arrive here.
        return card;


    }

    public void pay (int rentValue,Player target){//the target is the user ask rent
        ArrayList<Card> giveList = new ArrayList<>();
        Card card;


        //check the total value
        while (rentValue>0&&totalValue()!=0){
            card = selectBankAndProperty();

            rentValue = rentValue-card.value;
            giveList.add(card);

        }

        for (Card card1:giveList){
            if (card1 instanceof MoneyCard moneyCard){
                moneyCard.bank(target);
            }else if (card1 instanceof PropertyCard propertyCard){
                propertyCard.use(target);
            }
        }

    }





    //here need to deal with the extra property: like single colour is full but still has a same colour wild card
    public boolean completeSet(ArrayList<PropertyCard> propertyCards){
        if(!propertyCards.isEmpty()){
            int numberOfFullSets = propertyCards.get(0).fullSets;
            return propertyCards.size() >= numberOfFullSets;
        }else{
            return false;
        }


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
        String str = name+"'s deck: "+"\n";
        int i=1;
        for (Card card : decks){
            str = str+"["+i+"]"+card.toString()+"\n";
            i++;

        }
        str=str+"\n";
        System.out.println(str);
    }

    public void printBank(){
        String str = name+"'s bank account: ";
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
        String str = name+"'s Property: ";

        for (Colour value : propertiesByColour.keySet()) {
            colour = value;
            colourName = colour.name();
            number = propertiesByColour.get(colour).size();
            str = str + colourName+": " + number + " ";
        }
        str = str+"\n";
        str = str + "It includes wildCard: ";
        for (ArrayList<PropertyCard> propertyCards : propertiesByColour.values()){
            for (PropertyCard propertyCard : propertyCards){
                if (propertyCard instanceof WildCard wildCard){
                    str = str + wildCard.colour.toString() + " " + wildCard.otherColour.toString();
                }
            }
        }
        str = str +"\n";
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

    //use for check other player inforamtion except decks in hand.
    public void printBankAndProperty(){

        printBank();
        printProperty();
    }







}
