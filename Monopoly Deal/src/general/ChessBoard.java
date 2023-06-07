package general;

import card.Card;
import card.moneyCard.MoneyCard;
import card.propertyCard.PropertyCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ChessBoard {
     public Stack cardLibrary = new Stack<Card>();
     public ArrayList<Card> discard = new ArrayList<Card>();

     public void establish(){

     }

     public ChessBoard() {


     }
     public void shuffle(){
          Collections.shuffle(cardLibrary);
     }


     public Stack<Card> getCards() {
          return cardLibrary;
     }

}
