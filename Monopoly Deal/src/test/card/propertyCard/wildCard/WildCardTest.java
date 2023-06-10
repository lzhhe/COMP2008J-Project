package test.card.propertyCard.wildCard; 

import card.propertyCard.wildCard.WildCard;
import general.Colour;
import general.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.time.LocalDate;

/** 
* WildCard Tester. 
* 
* @author tianj
*/ 
public class WildCardTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: flip() 
* 
*/ 
@Test
public void testFlip() throws Exception {
    Player player=new Player("Tom", LocalDate.of(2009,1,1));
    WildCard wildCard = new WildCard(0,"",new int[4], Colour.RAILROAD,new int[5], Colour.LIGHT_BLUE);
    Assert.assertEquals(wildCard.otherColour,Colour.LIGHT_BLUE);
    wildCard.flip(player);
    Assert.assertEquals(wildCard.otherColour,Colour.RAILROAD);

}
} 
