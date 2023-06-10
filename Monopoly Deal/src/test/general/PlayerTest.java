package test.general;

import card.Card;
import card.CardKind;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Game;
import general.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/** 
* Player Tester. 
* 
* @author tianj
*/ 
public class PlayerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: toString() 
* 
*/ 
@Test
public void testToString() throws Exception { 
	Player player = new Player("john",LocalDate.of(2001, 9, 10));
	player.decks = new ArrayList<>();
	String expected = "Player{" +"decks=" + player.decks +'}';
    String actual = expected.toString();
    assertEquals(expected, actual);
} 

/** 
* 
* Method: calculateCount() 
* 
*/ 
@Test
public void testCalculateCount() throws Exception {
    Player player = new Player("john",LocalDate.of(2001, 9, 10));
    player.bankCount = new ArrayList<>();
    Card card1  = new PropertyCard(2,"",null,new int[4], Colour.RAILROAD);
    Card card2  = new PropertyCard(3,"",null,new int[4], Colour.RAILROAD);
    Card card3  = new PropertyCard(4,"",null,new int[4], Colour.RAILROAD);
    player.bankCount.add(card1);
    player.bankCount.add(card2);
    player.bankCount.add(card3);
    Assert.assertEquals( player.calculateCount(),9);
}

/** 
* 
* Method: calculateProperty() 
* 
*/ 
@Test
public void testCalculateProperty() throws Exception {
    Player player = new Player("john",LocalDate.of(2001, 9, 10));
    player.propertiesByColour = new HashMap<>();

    ArrayList<PropertyCard> clist1=new ArrayList<>();
    PropertyCard card1  = new PropertyCard(2,"",null,new int[4], Colour.RAILROAD);
    PropertyCard card2  = new PropertyCard(3,"",null,new int[4], Colour.RAILROAD);
    clist1.add(card1);
    clist1.add(card2);
    player.propertiesByColour.put(Colour.RAILROAD,clist1);
    ArrayList<PropertyCard> clist2=new ArrayList<>();
    PropertyCard card3  = new PropertyCard(5,"",null,new int[4], Colour.BLUE);
    PropertyCard card4  = new PropertyCard(6,"",null,new int[4], Colour.BLUE);
    clist2.add(card3);
    clist2.add(card4);
    player.propertiesByColour.put(Colour.BLUE,clist2);

    Assert.assertEquals(player.calculateProperty(),16);
} 

/** 
* 
* Method: totalValue() 
* 
*/ 
@Test
public void testTotalValue() throws Exception {
	Player player = new Player("john",LocalDate.of(2001, 9, 10));
    player.bankCount = new ArrayList<>();
    player.propertiesByColour = new HashMap<>();
    
    Card card1  = new PropertyCard(2,"",null,new int[4], Colour.RAILROAD);
    Card card2  = new PropertyCard(3,"",null,new int[4], Colour.RAILROAD);
    Card card3  = new PropertyCard(4,"",null,new int[4], Colour.RAILROAD);
    player.bankCount.add(card1);
    player.bankCount.add(card2);
    player.bankCount.add(card3);
    Assert.assertEquals( player.calculateCount(),9);
    player.propertiesByColour = new HashMap<>();

    ArrayList<PropertyCard> clist1=new ArrayList<>();
    PropertyCard card4  = new PropertyCard(2,"",null,new int[4], Colour.RAILROAD);
    PropertyCard card5  = new PropertyCard(3,"",null,new int[4], Colour.RAILROAD);
    clist1.add(card4);
    clist1.add(card5);
    player.propertiesByColour.put(Colour.RAILROAD,clist1);
    ArrayList<PropertyCard> clist2=new ArrayList<>();
    PropertyCard card6  = new PropertyCard(5,"",null,new int[4], Colour.BLUE);
    PropertyCard card7  = new PropertyCard(6,"",null,new int[4], Colour.BLUE);
    clist2.add(card6);
    clist2.add(card7);
    player.propertiesByColour.put(Colour.BLUE,clist2);

    Assert.assertEquals(player.calculateProperty(),16);
    Assert.assertEquals(player.totalValue(),25);
    

} 


/** 
* 
* Method: completeSet(ArrayList<PropertyCard> propertyCards) 
* 
*/ 
@Test
public void testCompleteSet() throws Exception { 
	Player player = new Player("john",LocalDate.of(2001, 9, 10));
	player.propertiesByColour = new HashMap<>();

    ArrayList<PropertyCard> clist1=new ArrayList<>();
    PropertyCard card1  = new PropertyCard(2,"",null,new int[4], Colour.RAILROAD);
    PropertyCard card2  = new PropertyCard(3,"",null,new int[4], Colour.RAILROAD);
    PropertyCard card3  = new PropertyCard(5,"",null,new int[4], Colour.RAILROAD);
    PropertyCard card4  = new PropertyCard(6,"",null,new int[4], Colour.RAILROAD);
    clist1.add(card1);
    clist1.add(card2);
    clist1.add(card3);
    clist1.add(card4);
    player.propertiesByColour.put(Colour.RAILROAD,clist1);
    assertEquals(player.completeSet(clist1),true);
    
    ArrayList<PropertyCard> clist2=new ArrayList<>();
    PropertyCard card5  = new PropertyCard(2,"",null,new int[4], Colour.RAILROAD);
    PropertyCard card6  = new PropertyCard(3,"",null,new int[4], Colour.RAILROAD);
    PropertyCard card7  = new PropertyCard(5,"",null,new int[4], Colour.RAILROAD);
    clist2.add(card5);
    clist2.add(card6);
    clist2.add(card7);
  
    player.propertiesByColour.put(Colour.RAILROAD,clist2);
    assertEquals(player.completeSet(clist2),false);

}

/** 
* 
* Method: winGame() 
* 
*/ 
@Test
public void testWinGame() throws Exception { 
	Player player = new Player("john", LocalDate.of(2001, 9, 10));
	
	player.propertiesByColour = new HashMap<>();

	ArrayList<PropertyCard> clist1=new ArrayList<>();
    PropertyCard card1  = new PropertyCard(2,"",null,new int[]{1, 2, 3, 4}, Colour.RAILROAD);
    PropertyCard card2  = new PropertyCard(3,"",null,new int[]{1, 2, 3, 4}, Colour.RAILROAD);
    PropertyCard card3  = new PropertyCard(5,"",null,new int[]{1, 2, 3, 4}, Colour.RAILROAD);
    PropertyCard card4  = new PropertyCard(6,"",null,new int[]{1, 2, 3, 4}, Colour.RAILROAD);
    clist1.add(card1);
    clist1.add(card2);
    clist1.add(card3);
    clist1.add(card4);
    player.propertiesByColour.put(Colour.RAILROAD,clist1);
    
    ArrayList<PropertyCard> clist2=new ArrayList<>();
    PropertyCard card5  = new PropertyCard(2,"",null,new int[]{1,2,3}, Colour.LIGHT_BLUE);
    PropertyCard card6  = new PropertyCard(3,"",null,new int[]{1,2,3}, Colour.LIGHT_BLUE);
    PropertyCard card7  = new PropertyCard(5,"",null,new int[]{1,2,3}, Colour.LIGHT_BLUE);
    
    clist2.add(card5);
    clist2.add(card6);
    clist2.add(card7);

    player.propertiesByColour.put(Colour.LIGHT_BLUE,clist2);
    
    ArrayList<PropertyCard> clist3=new ArrayList<>();
    
    PropertyCard card9  = new PropertyCard(3,"",null,new int[]{2,3,6}, Colour.RED);
    PropertyCard card10  = new PropertyCard(3,"",null,new int[]{2,3,6}, Colour.RED);
    

    clist3.add(card9);
    clist3.add(card10);
    

    
    player.propertiesByColour.put(Colour.RED,clist3);
    assertEquals(player.winGame(),false);
    
    PropertyCard card11  = new PropertyCard(3,"",null,new int[]{2,3,6}, Colour.RED);
    clist3.add(card11);
    player.propertiesByColour.put(Colour.RED,clist3);
    assertEquals(player.winGame(),true);
}


} 